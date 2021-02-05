package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class ReportPDFLogSpec extends Specification {

    def "shall create a ReportPDFLog instance"() {
        given:
        final name = "report_test.pdf"
        final relativePath = "root/report_test.pdf"

        when:
        def dataObject = ReportPDFLog.create(name, relativePath)

        then:
        assert dataObject instanceof ReportPDFLog
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "test.pdf"
        final relativePath = "root/test.pdf"

        when:
        def dataObject = ReportPDFLog.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }


}
