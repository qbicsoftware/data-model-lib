package life.qbic.datamodel.datasets

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.files.maxquant.AllPeptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Evidence
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ExperimentalDesignTemplate
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Parameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Peptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ProteinGroups
import life.qbic.datamodel.datasets.datastructure.files.maxquant.RunParameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Summary
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.datasets.datastructure.folders.maxquant.MaxQuantRunFolder
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Class that holds information about the output of a maxQuantRun
 *
 * @since 2.10.0
 */
final class MaxQuantRunResult {

    // Fully qualified domain name of the maxQuant folder structure package
    private final static String FQDN_FOLDERS = "life.qbic.datamodel.datasets.datastructure.folders.maxquant"
    // Fully qualified domain name of the maxQuant file structure package
    private final static String FQDN_FILES = "life.qbic.datamodel.datasets.datastructure.files.maxquant"

    private final static Set maxQuantFileTypes = [
            FQDN_FILES + ".AllPeptides",
            FQDN_FILES + ".Evidence",
            FQDN_FILES + ".ExperimentalDesignTemplate",
            FQDN_FILES + ".Parameters",
            FQDN_FILES + ".Peptides",
            FQDN_FILES + ".ProteinGroups",
            FQDN_FILES + ".RunParameters",
            FQDN_FILES + ".Summary"
    ]

    private final static Set maxQuantFolderTypes = [
            FQDN_FOLDERS + ".MaxQuantRunFolder",
    ]

    private MaxQuantRunFolder maxQuantRunFolder

    MaxQuantRunResult(MaxQuantRunFolder maxQuantRunFolder) {
        Objects.requireNonNull(maxQuantRunFolder, "Please provide a maxQuantRun folder.")

        this.maxQuantRunFolder = maxQuantRunFolder
    }

    /**
     * Static factory method that creates a new maxQuantRunResult instance from the bioinformatic pipeline output.
     * See this @{link <a href="https://github.com/qbicsoftware/data-model-lib/blob/master/src/test/resources/examples/resultset/maxquant/valid-resultset-example.json">example</a>}
     * for a JSON representation of a valid map structure
     *
     * @param Map maxQuantRunOutput
     * @return MaxQuantRunResult A new instance of a maxQuantRunResult object.
     * @since 2.10.0
     */
    static MaxQuantRunResult createFrom(Map maxQuantRunOutput) {

        //Check if the required folders is in root directory
        Objects.requireNonNull(maxQuantRunOutput.get("maxQuantRun"), "The root folder must contain a maxQuantRun folder.")
        //Check if all required files are in the pipeline_info directory
        Map maxQuantRunMap = maxQuantRunOutput["maxQuantRun"] as Map
        Objects.requireNonNull(maxQuantRunMap.get("allPeptides"), "The maxQuantRun folder must contain a allPeptides.txt file.")
        Objects.requireNonNull(maxQuantRunMap.get("evidence"), "The maxQuantRun folder must contain a evidence.txt file.")
        Objects.requireNonNull(maxQuantRunMap.get("experimentalDesignTemplate"), "The maxQuantRun folder must contain a experimentalDesignTemplate.txt file.")
        Objects.requireNonNull(maxQuantRunMap.get("parameters"), "The maxQuantRun folder must contain a parameters.txt file.")
        Objects.requireNonNull(maxQuantRunMap.get("peptides"), "The maxQuantRun folder must contain a peptides.txt file.")
        Objects.requireNonNull(maxQuantRunMap.get("proteinGroups"), "The maxQuantRun folder must contain a proteinGroups.txt file.")
        Objects.requireNonNull(maxQuantRunMap.get("runParameters"), "The maxQuantRun folder must contain a runParameters.xml file.")
        Objects.requireNonNull(maxQuantRunMap.get("summary"), "The maxQuantRun folder must contain a summary.pdf file.")

        //Parse all folders in the root directory
        MaxQuantRunFolder maxQuantRunFolder = parseFolder(maxQuantRunOutput.get("maxQuantRun") as Map) as MaxQuantRunFolder

        //These files are not stored as children but as properties of the pipeline_info folder
        DataFile allPeptides = parseFile(maxQuantRunMap.get("allPeptides") as Map)
        DataFile evidence = parseFile(maxQuantRunMap.get("evidence") as Map)
        DataFile experimentalDesignTemplate = parseFile(maxQuantRunMap.get("experimentalDesignTemplate") as Map)
        DataFile parameters = parseFile(maxQuantRunMap.get("parameters") as Map)
        DataFile peptides = parseFile(maxQuantRunMap.get("peptides") as Map)
        DataFile proteinGroups = parseFile(maxQuantRunMap.get("proteinGroups") as Map)
        DataFile runParameters = parseFile(maxQuantRunMap.get("runParameters") as Map)
        DataFile summary = parseFile(maxQuantRunMap.get("summary") as Map)

        //Set information of maxQuantRunFolder properties
        maxQuantRunFolder.allPeptides = allPeptides as AllPeptides
        maxQuantRunFolder.evidence = evidence as Evidence
        maxQuantRunFolder.experimentalDesignTemplate = experimentalDesignTemplate as ExperimentalDesignTemplate
        maxQuantRunFolder.parameters = parameters as Parameters
        maxQuantRunFolder.peptides = peptides as Peptides
        maxQuantRunFolder.proteinGroups = proteinGroups as ProteinGroups
        maxQuantRunFolder.runParameters = runParameters as RunParameters
        maxQuantRunFolder.summary = summary as Summary

        //Create new MaxQuantRunResult object with parsed information
        return new MaxQuantRunResult(maxQuantRunFolder)
    }

    /**
     * Provides access to the information stored in the MaxQuantRun folder
     * @return MaxQuantRunFolder
     * @since 2.10.0
     */
    MaxQuantRunFolder getMaxQuantRunInformation() {
        return maxQuantRunFolder
    }

    /*
     * Helper method that creates a DataFile instance from a map
     */
    private static DataFile parseFile(Map fileTree) throws IllegalArgumentException {
        String name = fileTree.get("name")
        String path = fileTree.get("path")
        
        for (String maxQuantFileType : maxQuantFileTypes) {
            Class<?> c = Class.forName(maxQuantFileType)
            Method method = c.getDeclaredMethod("create", String.class, String.class)
            try {
                DataFile dataFile = method.invoke(null, name, path) as DataFile
                return dataFile
            } catch (InvocationTargetException e) {
                // Do nothing as we need to try out all specialisations that extend the
                // DataFile class

            }
        }
        // If we cannot create a DataFile object at all, throw an exception
        throw new IllegalArgumentException("File $name with path $path is of unknown maxQuant file type.")
    }

    /*
     * Helper method that creates a DataFolder instance from a map
     */
    private static DataFolder parseFolder(Map fileTree) throws IllegalArgumentException {

        def name = fileTree.get("name") as String
        def path = fileTree.get("path") as String
        def children = parseChildren(fileTree.get("children") as List)

        for (String maxQuantFolderType : maxQuantFolderTypes) {
            Class<?> c = Class.forName(maxQuantFolderType)
            Method method = c.getDeclaredMethod("create", String.class, String.class, List.class)
            Optional<DataFolder> folder = tryToCreateDataFolder(method, name, path, children)
            if (folder.isPresent()) {
                return folder.get()
            }
        }
        // If we reach this point, no DataFolder could be created based on the known folder types
        // in life.qbic.datamodel.datasets.datastructure.folders.maxquant *
        throw new IllegalArgumentException("Folder $name with path $path is of unknown maxQuant folder type.")
    }

    /*
     * Helper method that tries to create a DataFolder instance
     * based on the DataFolder's different static factory create methods.
     */
    private static Optional<DataFolder> tryToCreateDataFolder(Method method,
                                                              String name,
                                                              String relativePath,
                                                              List children) {
        Optional<DataFolder> folder = Optional.empty()
            try {
                // We only have named folders
                def dataFolder = method.invoke(null, name, relativePath, children) as DataFolder
                folder = Optional.of(dataFolder)
            } catch (InvocationTargetException e2) {
                // Do nothing
            }

        return folder
    }

    /*
     * Helper method that parses the children of a folder.
     */
    private static List parseChildren(List<Map> children) {
        def parsedChildren = []
        children.each { Map unknownChild ->
            try {
                def child = parseFile(unknownChild)
                //only add child if the Datafile is not null
                if (child) {
                    parsedChildren.add(child)
                }
            } catch (IllegalArgumentException e) {
                // We do not capture the second parse call, as we want to fail the parsing at this point.
                // This means that we ultimately found a child of unknown type, which should
                // break the parsing.
                def child = parseFolder(unknownChild)
                parsedChildren.add(child)
            }
        }
        return parsedChildren
    }

}
