package life.qbic.datamodel.datasets.datastructure.files.nfcore

import spock.lang.Specification

/**
 * Test for the PipelineReport class
 *
 * @since 2.5.0
 */
class PipelineReportSpec extends Specification {

    def "shall create a PipelineReport instance"() {
        given:
        final name = "pipeline_report_test.txt"
        final relativePath = "root/pipeline_report_test.txt"

        when:
        def dataObject = PipelineReport.create(name, relativePath)

        then:
        assert dataObject instanceof PipelineReport
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "pipeline_report.txt"
        final relativePath = "root/pipeline_report.txt"

        when:
        def dataObject = PipelineReport.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }


}
