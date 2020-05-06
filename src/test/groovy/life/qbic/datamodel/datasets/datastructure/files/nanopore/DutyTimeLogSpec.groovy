package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class DutyTimeLogSpec extends Specification {

    def "shall create a DutyTimeLog instance"() {
        given:
        final name = "duty_time_test.csv"
        final relativePath = "root/duty_time_test.csv"

        when:
        def dataObject = DutyTimeLog.create(name, relativePath)

        then:
        assert dataObject instanceof DutyTimeLog
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "duty_test.log"
        final relativePath = "root/duty_test.log"

        when:
        def dataObject = DutyTimeLog.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }

}
