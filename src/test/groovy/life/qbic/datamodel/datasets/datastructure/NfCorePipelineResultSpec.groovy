package life.qbic.datamodel.datasets.datastructure

import groovy.json.JsonSlurper
import life.qbic.datamodel.datasets.NfCorePipelineResult
import spock.lang.Shared
import spock.lang.Specification

/**
 * Tests for the NfCoreExperiment class
 *
 * @since 2.5.0
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
        final NfCorePipelineResult validExperiment = NfCorePipelineResult.createFrom(validExample)
        final List<?> validResultSet = validExperiment.getResultSet()
        then:
        assert validResultSet.size() == 5
    }

    def "Invalid fileTree will return a NullPointerException"() {
        given:
        final Map invalidExample = invalidDataStructure

        when:
        final NfCorePipelineResult invalidExperiment = NfCorePipelineResult.createFrom(invalidExample)
        final List<?> invalidResultSet = invalidExperiment.getResultSet()

        then:
        thrown(NullPointerException)
    }

    def "missing PipelineInfo Folder will return a NullPointerException"() {
        given:
        final Map noPipelineFolderExample = missingPipelineInfoDataStructure

        when:
        final NfCorePipelineResult noPipelineFolderExperiment = NfCorePipelineResult.createFrom(noPipelineFolderExample)
        final List<?> noPipelineFolderResultSet = noPipelineFolderExperiment.getResultSet()

        then:
        thrown(NullPointerException)
    }

    def "Missing Process Folders will return a NullPointerException"() {
        given:
        final Map noProcessFolderExample = missingProcessFoldersDataStructure

        when:
        final NfCorePipelineResult noProcessFolderExperiment = NfCorePipelineResult.createFrom(noProcessFolderExample)
        final List<?> resultSet = noProcessFolderExperiment.getResultSet()

        then:
        thrown(NullPointerException)
    }

    def "Missing QualityControl Folder will return a NullPointerException"() {
        given:
        final Map noQualityControlFolderExample = missingQualityControlDataStructure

        when:
        final NfCorePipelineResult noQualityControlFolderExperiment = NfCorePipelineResult.createFrom(noQualityControlFolderExample)
        final List<?> noQualityControlFolderResultSet = noQualityControlFolderExperiment.getResultSet()

        then:
        thrown(NullPointerException)
    }

}
