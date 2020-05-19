package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class FinalSummaryLogSpec extends Specification {

    def "shall create a FinalSummaryLog instance"() {
        given:
        final name = "final_summary_test.txt"
        final relativePath = "root/final_summary_test.txt"

        when:
        def dataObject = FinalSummaryLog.create(name, relativePath)

        then:
        assert dataObject instanceof FinalSummaryLog
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "summary_test.txt"
        final relativePath = "root/summary_test.txt"

        when:
        def dataObject = FinalSummaryLog.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }
}
