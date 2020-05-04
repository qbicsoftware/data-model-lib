package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class SequencingSummaryLogSpec extends Specification {

    def "shall create a SequencingSummaryLog instance"()  {
        given:
        final name = "sequencing_summary_test.txt"
        final relativePath = "root/sequencing_summary_test.txt"

        when:
        def dataObject = SequencingSummaryLog.create(name, relativePath)

        then:
        assert dataObject instanceof SequencingSummaryLog
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "sequencing_summary.txt"
        final relativePath = "root/sequencing_summary.txt"

        when:
        def dataObject = SequencingSummaryLog.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }


}
