package life.qbic.datamodel.datasets.datastructure.files.nfcore

import spock.lang.Specification

/**
 * Test for the ExecutionReport class
 *
 * @since 2.6.0
 */
class ExecutionReportSpec extends Specification {

    def "shall create a ExecutionReport instance"() {
        given:
        final name = "execution_report.html"
        final relativePath = "root/execution_report.html"

        when:
        def dataObject = ExecutionReport.create(name, relativePath)

        then:
        assert dataObject instanceof ExecutionReport
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "stalling_report.txt"
        final relativePath = "root/stalling_report.txt"

        when:
        def dataObject = ExecutionReport.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }


}
