package life.qbic.datamodel.datasets

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

import life.qbic.datamodel.identifiers.SampleCodeFunctions

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Class that holds information about a the output of a nf-core pipeline
 *
 * @since 2.5.0
 */
final class NfCoreExperiment {

    // Fully qualified domain name of the nfcore folder structure package
    private final static String FQDN_FOLDERS = "life.qbic.datamodel.datasets.datastructure.folders.nfcore"
    // Fully qualified domain name of the nfcore file structure package
    private final static String FQDN_FILES = "life.qbic.datamodel.datasets.datastructure.files.nfcore"

    private final List<?> resultSet

    private final static Set nfCoreFileTypes = [
            FQDN_FILES + ".ExecutionReport",
            FQDN_FILES + ".SampleIds",
            FQDN_FILES + ".PipelineReport",
            FQDN_FILES + ".SoftwareVersions",
            FQDN_FILES + ".RunId"
    ]

    private final static Set nfCoreFolderTypes = [
            FQDN_FOLDERS + ".PipelineInformationFolder",
            FQDN_FOLDERS + ".QualityControlFolder",
            FQDN_FOLDERS + ".ProcessFolder"
    ]

    private NfCoreExperiment(List<?> resultSet) {
        this.resultSet = Objects.requireNonNull(resultSet as Object, "resultSet must not be null") as List<?>
    }

    /**
     * Static factory method that creates a new nfcoreExperiment instance from the bioinformatic pipeline output.
     *
     * @param Map bioinformaticPipelineOutput
     * @return NfCoreExperiment A new instance of a nfcore bioinformatic experiment.
     */
    static NfCoreExperiment create(Map bioinformaticPipelineOutput) {

        //Check if all required folders are in root directory
        Objects.requireNonNull(bioinformaticPipelineOutput.get("pipelineInformation"), "The root folder must contain a PipelineInformation folder.")
        Objects.requireNonNull(bioinformaticPipelineOutput.get("qualityControl"),"The root folder must contain a QualityControl folder.")
        Objects.requireNonNull(bioinformaticPipelineOutput.get("processFolders"), "The root folder must contain at least one process folder.")
        //Check if all required files are in root directory
        Objects.requireNonNull(bioinformaticPipelineOutput.get("runId"), "The root folder must contain a run_id.txt file.")
        Objects.requireNonNull(bioinformaticPipelineOutput.get("sampleIds"), "The root folder must contain an sample_ids.txt file.")

        //Parse all folders in the root directory
        DataFolder pipelineInformation = parseFolder(bioinformaticPipelineOutput.get("pipelineInformation") as Map)
        DataFolder qualityControl = parseFolder(bioinformaticPipelineOutput.get("qualityControl") as Map)
        List<DataFolder> processFolders = []
        //The root folder contains one or multiple Process folders stored in the "processFolders" key
        bioinformaticPipelineOutput.get("processFolders").each { it ->
            DataFolder processFolder = parseFolder(it as Map)
            processFolders.add(processFolder)
        }

        //Parse all files in the root directory
        DataFile runId = parseFile(bioinformaticPipelineOutput.get("runId") as Map)
        DataFile sampleIds = parseFile(bioinformaticPipelineOutput.get("sampleIds") as Map)


        List<?> resultSet = [pipelineInformation, qualityControl, processFolders, runId, sampleIds] as List<?>
        return new NfCoreExperiment(resultSet)
    }

    List<?> getResultSet() {
        return this.resultSet
    }

    /*
     * Helper method that creates a DataFile instance from a map
     */

    private static DataFile parseFile(Map fileTree) throws IllegalArgumentException {
        def name = fileTree.get("name")
        def path = fileTree.get("path")
        for (String nanoPoreFileType : nfCoreFileTypes) {
            Class<?> c = Class.forName(nanoPoreFileType)
            Method method = c.getDeclaredMethod("create", String.class, String.class)
            try {
                DataFile dataFile = method.invoke(null, name, path) as DataFile
                println(dataFile)
                return dataFile
            } catch (InvocationTargetException e) {
                // Do nothing as we need to try out all specialisations that extend the
                // DataFile class
            }
        }
        // If we cannot create a DataFile object at all, throw an exception
        throw new IllegalArgumentException("File $name with path $path is of unknown nfcore file type.")
    }

    /*
     * Helper method that creates a DataFolder instance from a map
     */

    private static DataFolder parseFolder(Map fileTree) throws IllegalArgumentException {

        def name = fileTree.get("name") as String
        def path = fileTree.get("path") as String
        def children = parseChildren(fileTree.get("children") as List)

        for (String bioinformaticPipelineFolderType : nfCoreFolderTypes) {
            Method method = determineMethod(Class.forName(bioinformaticPipelineFolderType))
            Optional<DataFolder> folder = tryToCreateDataFolder(method, name, path, children)
            if (folder.isPresent()) {
                return folder.get()
            }
        }
        // If we reach this point, no DataFolder could be created based on the known folder types
        // in life.qbic.datamodel.datasets.datastructure.folders.nfcore *
        throw new IllegalArgumentException("Folder $name with path $path is of unknown nfcore folder type.")
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
                // We only have named Folders
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
                parsedChildren.add(child)
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

    /*
    Determines the correct static create method for a data folder.
     */

    private static Method determineMethod(Class c) {
        def method
        try {
            // named folder (i.e. QualityControl)
            method = c.getDeclaredMethod("create", String.class, String.class, List.class)
        } catch (NoSuchMethodException e) {
            // Do nothing
        }
        return method
    }
}
