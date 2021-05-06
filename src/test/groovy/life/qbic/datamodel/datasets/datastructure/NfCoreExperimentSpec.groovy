package life.qbic.datamodel.datasets.datastructure

import groovy.json.JsonSlurper
import life.qbic.datamodel.datasets.NfCoreExperiment
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import spock.lang.Shared
import spock.lang.Specification

/**
 * Tests for the NfCoreExperiment class
 *
 * @since 2.5.0
 */
class NfCoreExperimentSpec extends Specification {
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
    }

    def "Create simple experiment and resultset successfully"() {
        given:
        final Map validExample = validDataStructure

        when:
        final NfCoreExperiment validExperiment = NfCoreExperiment.create(validExample)
        final List<DataFolder> validResultSet = validExperiment.getResultSet()

        then:
        assert validResultSet.size() == 3
    }

    def "Invalid fileTree will return a NullPointerException"() {
        given:
        final Map invalidExample = invalidDataStructure

        when:
        final NfCoreExperiment invalidExperiment = NfCoreExperiment.create(invalidExample)
        final List<DataFolder> invalidResultSet = invalidExperiment.getResultSet()

        then:
        thrown(NullPointerException)
    }

    def "missing PipelineInfo Folder will return a NullPointerException"() {
        given:
        final Map noPipelineFolderExample = missingPipelineInfoDataStructure

        when:
        final NfCoreExperiment noPipelineFolderExperiment = NfCoreExperiment.create(noPipelineFolderExample)
        final List<DataFolder> noPipelineFolderResultSet = noPipelineFolderExperiment.getResultSet()

        then:
        thrown(NullPointerException)
    }

    def "Missing Process Folders will return a NullPointerException"() {
        given:
        final Map noProcessFolderExample = missingProcessFoldersDataStructure

        when:
        final NfCoreExperiment noProcessFolderExperiment = NfCoreExperiment.create(noProcessFolderExample)
        final List<DataFolder> resultSet = noProcessFolderExperiment.getResultSet()

        then:
        thrown(NullPointerException)
    }

    def "Missing QualityControl Folder will return a NullPointerException"() {
        given:
        final Map noQualityControlFolderExample = missingQualityControlDataStructure

        when:
        final NfCoreExperiment noQualityControlFolderExperiment = NfCoreExperiment.create(noQualityControlFolderExample)
        final List<DataFolder> noQualityControlFolderResultSet = noQualityControlFolderExperiment.getResultSet()

        then:
        thrown(NullPointerException)
    }

}
