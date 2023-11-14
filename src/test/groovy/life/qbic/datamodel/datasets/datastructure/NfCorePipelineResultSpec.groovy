package life.qbic.datamodel.datasets.datastructure

import groovy.json.JsonSlurper
import life.qbic.datamodel.datasets.NfCorePipelineResult
import life.qbic.datamodel.datasets.datastructure.files.nfcore.RunId
import life.qbic.datamodel.datasets.datastructure.files.general.SampleIds
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.datasets.datastructure.folders.nfcore.PipelineInformationFolder
import life.qbic.datamodel.datasets.datastructure.folders.nfcore.QualityControlFolder
import spock.lang.Shared
import spock.lang.Specification

/**
 * Tests for the NfCoreExperiment class
 *
 * @since 2.6.0
 */
class NfCorePipelineResultSpec extends Specification {
    /**
     * Map that stores the bioinformatic pipeline resultSet folder structure
     * according to the schema
     */
    @Shared
    Map validDataStructure

    @Shared
    Map invalidDataStructure

    @Shared
    Map missingPipelineInfoDataStructure

    @Shared
    Map missingProcessFoldersDataStructure

    @Shared
    Map missingQualityControlDataStructure

    @Shared
    Map validDataStructureWithoutRunId

    def setupSpec() {
        InputStream validStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("examples/resultset/valid-resultset-example.json")
        validDataStructure = (Map) new JsonSlurper().parse(validStream)
        validStream.close()

        InputStream invalidStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("examples/resultset/invalid-resultset-example.json")
        invalidDataStructure = (Map) new JsonSlurper().parse(invalidStream)
        invalidStream.close()

        InputStream missingPipelineStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("examples/resultset/missing-pipeline-info-resultset-example.json")
        missingPipelineInfoDataStructure = (Map) new JsonSlurper().parse(missingPipelineStream)
        missingPipelineStream.close()

        InputStream missingProcessFoldersStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("examples/resultset/missing-process-folders-resultset-example.json")
        missingProcessFoldersDataStructure = (Map) new JsonSlurper().parse(missingProcessFoldersStream)
        missingProcessFoldersStream.close()

        InputStream missingQualityControlStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("examples/resultset/missing-quality-control-resultset-example.json")
        missingQualityControlDataStructure = (Map) new JsonSlurper().parse(missingQualityControlStream)
        missingQualityControlStream.close()

        InputStream validStreamWithoutRunId = Thread.currentThread().getContextClassLoader().getResourceAsStream("examples/resultset/valid-resultset-no-run_id-example.json")
        validDataStructureWithoutRunId = (Map) new JsonSlurper().parse(validStreamWithoutRunId)
        validStreamWithoutRunId.close()
    }

    def "Create NfCorePipelineOutput from Map successfully"() {
        given:
        final Map validExample = validDataStructure

        when:
        final NfCorePipelineResult validPipelineResult = NfCorePipelineResult.createFrom(validExample)
        SampleIds sampleIds = validPipelineResult.getSampleIds()
        RunId runId = validPipelineResult.getRunId()
        List<DataFolder> processFolders = validPipelineResult.getProcessFolders()
        QualityControlFolder qualityControlFolder = validPipelineResult.getQualityControlFolder()
        PipelineInformationFolder pipelineInformationFolder = validPipelineResult.getPipelineInformation()

        then:
        sampleIds.name == "sample_ids.txt"
        runId.name == "run_id.txt"
        processFolders.get(0).name == "salmon"
        qualityControlFolder.name == "multiqc"
        pipelineInformationFolder.getSoftwareVersions().name == "software_versions.yml"
        pipelineInformationFolder.getExecutionReport().name == "execution_report.html"
    }

    def "Invalid fileTree will return a NullPointerException"() {
        given:
        final Map invalidExample = invalidDataStructure

        when:
        final NfCorePipelineResult invalidPipelineOutput = NfCorePipelineResult.createFrom(invalidExample)

        then:
        thrown(NullPointerException)
    }

    def "missing PipelineInfo Folder will return a NullPointerException"() {
        given:
        final Map noPipelineFolderExample = missingPipelineInfoDataStructure

        when:
        final NfCorePipelineResult noPipelineFolderOutput = NfCorePipelineResult.createFrom(noPipelineFolderExample)

        then:
        thrown(NullPointerException)
    }

    def "Missing Process Folders will return a NullPointerException"() {
        given:
        final Map noProcessFolderExample = missingProcessFoldersDataStructure

        when:
        final NfCorePipelineResult noProcessFolderOutput = NfCorePipelineResult.createFrom(noProcessFolderExample)

        then:
        thrown(NullPointerException)
    }

    def "Missing QualityControl Folder will return a NullPointerException"() {
        given:
        final Map noQualityControlFolderExample = missingQualityControlDataStructure

        when:
        final NfCorePipelineResult noQualityControlFolderOutput = NfCorePipelineResult.createFrom(noQualityControlFolderExample)

        then:
        thrown(NullPointerException)
    }

    def "Create NfCorePipelineOutput from Map without RunId successfully"() {
        given:
        final Map validExample = validDataStructureWithoutRunId

        when:
        final NfCorePipelineResult validPipelineResult = NfCorePipelineResult.createFrom(validExample)
        SampleIds sampleIds = validPipelineResult.getSampleIds()
        List<DataFolder> processFolders = validPipelineResult.getProcessFolders()
        QualityControlFolder qualityControlFolder = validPipelineResult.getQualityControlFolder()
        PipelineInformationFolder pipelineInformationFolder = validPipelineResult.getPipelineInformation()

        then:
        sampleIds.name == "sample_ids.txt"
        processFolders.get(0).name == "salmon"
        qualityControlFolder.name == "multiqc"
        pipelineInformationFolder.getSoftwareVersions().name == "software_versions.yml"
        pipelineInformationFolder.getExecutionReport().name == "execution_report.html"
        assert validPipelineResult.runId == null
    }

}
