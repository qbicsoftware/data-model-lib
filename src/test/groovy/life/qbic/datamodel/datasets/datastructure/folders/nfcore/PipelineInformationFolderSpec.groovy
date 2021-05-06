package life.qbic.datamodel.datasets.datastructure.folders.nfcore

import life.qbic.datamodel.datasets.datastructure.files.nfcore.ExecutionReport
import spock.lang.Specification

/**
 * Tests for the PipelineInformationFolder Object
 *
 * @since 2.5.0
 */
class PipelineInformationFolderSpec extends Specification {

    def "create pipelineInformation folder"() {
        given:
        final def name = "pipeline_info"
        final def relativePath = "root/pipeline_info"
        final def children = []
        final def datafile = ExecutionReport.create("execution_report_test.txt", "root/execution_report_test.txt")
        children.add(datafile)

        when:
        final def dataFolder = PipelineInformationFolder.create(name, relativePath, children)

        then:
        assert dataFolder.getChildren().get(0) instanceof ExecutionReport

    }

    def "naming schema violation should raise an IllegalArgumentException"() {
        given:
        final def name = "pipeline_unsatisfied"
        final def relativePath = "root/pipeline_unsatisfied"
        final def children = []
        final def datafile =  ExecutionReport.create("execution_report_test.txt", "root/execution_report_test.txt")
        children.add(datafile)

        when:
        final def dataFolder = PipelineInformationFolder.create(name, relativePath, children)

        then:
        thrown(IllegalArgumentException)

    }
}
