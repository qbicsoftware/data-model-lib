package life.qbic.datamodel.datasets


import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.files.nfcore.ExecutionReport
import life.qbic.datamodel.datasets.datastructure.files.nfcore.PipelineReport
import life.qbic.datamodel.datasets.datastructure.files.nfcore.RunId
import life.qbic.datamodel.datasets.datastructure.files.nfcore.SampleIds
import life.qbic.datamodel.datasets.datastructure.files.nfcore.SoftwareVersions
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.datasets.datastructure.folders.nfcore.PipelineInformationFolder
import life.qbic.datamodel.datasets.datastructure.folders.nfcore.ProcessFolder
import life.qbic.datamodel.datasets.datastructure.folders.nfcore.QualityControlFolder

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Class that holds information about a the output of a nf-core pipeline
 *
 * @since 2.6.0
 */
final class NfCorePipelineResult {

    // Fully qualified domain name of the nfcore folder structure package
    private final static String FQDN_FOLDERS = "life.qbic.datamodel.datasets.datastructure.folders.nfcore"
    // Fully qualified domain name of the nfcore file structure package
    private final static String FQDN_FILES = "life.qbic.datamodel.datasets.datastructure.files.nfcore"

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

    private SampleIds sampleIds

    private RunId runId

    private PipelineInformationFolder pipelineInformationFolder

    private QualityControlFolder qualityControlFolder

    private List<DataFolder> processFolders

    NfCorePipelineResult(PipelineInformationFolder pipelineInformationFolder, QualityControlFolder qualityControlFolder, List<DataFolder> processFolders,  RunId runId, SampleIds sampleIds) {
        Objects.requireNonNull(pipelineInformationFolder, "Please provide a PipelineInformation folder.")
        Objects.requireNonNull(qualityControlFolder, "Please provide a QualityControl folder")
        Objects.requireNonNull(processFolders, "Please provide a List of process folders")
        Objects.requireNonNull(runId, "Please provide a runId file")
        Objects.requireNonNull(sampleIds, "Please provide a sampleIds file")

        this.pipelineInformationFolder = pipelineInformationFolder
        this.qualityControlFolder = qualityControlFolder
        this.processFolders = processFolders
        this.runId = runId
        this.sampleIds = sampleIds
    }

    /**
     * Static factory method that creates a new nfcoreExperiment instance from the bioinformatic pipeline output.
     * See this @{link <a href="https://github.com/qbicsoftware/data-model-lib/blob/master/src/test/resources/examples/resultset/valid-resultset-example.json">example</a>}
     * for a JSON representation of a valid map structure
     *
     * @param Map bioinformaticPipelineOutput
     * @return NfCoreExperiment A new instance of a nfcore bioinformatic experiment.
     */
    static NfCorePipelineResult createFrom(Map bioinformaticPipelineOutput) {

        //Check if all required folders are in root directory
        Objects.requireNonNull(bioinformaticPipelineOutput.get("pipelineInformation"), "The root folder must contain a PipelineInformation folder.")
        Objects.requireNonNull(bioinformaticPipelineOutput.get("qualityControl"),"The root folder must contain a QualityControl folder.")
        Objects.requireNonNull(bioinformaticPipelineOutput.get("processFolders"), "The root folder must contain at least one process folder.")
        //Check if all required files are in the pipeline_info directory
        Map pipelineInfoMap = bioinformaticPipelineOutput["pipelineInformation"] as Map
        Objects.requireNonNull(pipelineInfoMap.get("softwareVersions"), "The pipeline_info folder must contain a softwareVersions.csv file.")
        Objects.requireNonNull(pipelineInfoMap.get("executionReport"), "The pipeline_info folder must contain a executionReport.txt file.")
        Objects.requireNonNull(pipelineInfoMap.get("pipelineReport"), "The pipeline_info folder must contain a pipeline_info.txt file.")
        //Check if all required files are in root directory
        Objects.requireNonNull(bioinformaticPipelineOutput.get("runId"), "The root folder must contain a run_id.txt file.")
        Objects.requireNonNull(bioinformaticPipelineOutput.get("sampleIds"), "The root folder must contain an sample_ids.txt file.")

        //Parse all folders in the root directory
        PipelineInformationFolder pipelineInformation = parseFolder(bioinformaticPipelineOutput.get("pipelineInformation") as Map) as PipelineInformationFolder
        DataFolder qualityControl = parseFolder(bioinformaticPipelineOutput.get("qualityControl") as Map) as QualityControlFolder
        List<DataFolder> processFolders = []
        //The root folder contains one or multiple Process folders stored in the "processFolders" key
        bioinformaticPipelineOutput.get("processFolders").each { it ->
            ProcessFolder processFolder = parseFolder(it as Map) as ProcessFolder
            processFolders.add(processFolder)
        }

        //These files are not stored as children but as properties of the pipeline_info folder
        DataFile softwareVersions = parseFile(pipelineInfoMap.get("softwareVersions") as Map)
        DataFile executionReport = parseFile(pipelineInfoMap.get("executionReport") as Map)
        DataFile pipelineReport = parseFile(pipelineInfoMap.get("pipelineReport") as Map)

        //Set information of pipelineInformation properties
        pipelineInformation.softwareVersions = softwareVersions as SoftwareVersions
        pipelineInformation.pipelineReport = pipelineReport as PipelineReport
        pipelineInformation.executionReport = executionReport as ExecutionReport

        //Parse all files in the root directory
        DataFile runId = parseFile(bioinformaticPipelineOutput.get("runId") as Map) as RunId
        DataFile sampleIds = parseFile(bioinformaticPipelineOutput.get("sampleIds") as Map) as SampleIds

        //Create new NfCorePipelineResult with parsed information
        return new NfCorePipelineResult(pipelineInformation, qualityControl, processFolders, runId, sampleIds)
    }

    /**
     * Provides access to the information stored in the pipeline information folder
     * @return PipelineInformationFolder
     */
    PipelineInformationFolder getPipelineInformation() {
        return pipelineInformationFolder
    }

    /**
     * Provides access to the information stored in the quality Control folder
     * @return QualityControlFolder
     */
    QualityControlFolder getQualityControlFolder() {
        return qualityControlFolder
    }

    /**
     * Provides access to the information stored in the process folders
     * @return List<DataFolder>
     */
    List<DataFolder> getProcessFolders() {
        return processFolders
    }

    /**
     * Provides access to the information stored in the runId file
     * @return RunId
     */
    RunId getRunId() {
        return runId
    }

    /**
     * Provides access to the information stored in the sampleIds file
     * @return SampleIds
     */
    SampleIds getSampleIds() {
        return sampleIds
    }


    /*
     * Helper method that creates a DataFile instance from a map
     */

    private static DataFile parseFile(Map fileTree) throws IllegalArgumentException {
        String name = fileTree.get("name")
        String fileType = fileTree.get("fileType")
        String path = fileTree.get("path")
        for (String nfCoreFileType : nfCoreFileTypes) {
            Class<?> c = Class.forName(nfCoreFileType)
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
            Class<?> c = Class.forName(bioinformaticPipelineFolderType)
            Method method = c.getDeclaredMethod("create", String.class, String.class, List.class)
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

}
