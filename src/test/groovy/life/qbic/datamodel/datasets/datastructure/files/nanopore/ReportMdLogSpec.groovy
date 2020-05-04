package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class ReportMdLogSpec extends Specification {

    def "shall create a ReportMdLog instance"()  {
        given:
        final name = "report_test.md"
        final relativePath = "root/report_test.md"

        when:
        def dataObject = ReportMdLog.create(name, relativePath)

        then:
        assert dataObject instanceof ReportMdLog
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "report.md"
        final relativePath = "root/report.md"

        when:
        def dataObject = ReportMdLog.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }
}
