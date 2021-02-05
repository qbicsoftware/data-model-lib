package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class ThroughputLogSpec extends Specification {

    def "shall create a ThroughputLog instance"() {
        given:
        final name = "throughput_test.csv"
        final relativePath = "root/throughput_test.csv"

        when:
        def dataObject = ThroughputLog.create(name, relativePath)

        then:
        assert dataObject instanceof ThroughputLog
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "throughput.txt"
        final relativePath = "root/throughput.txt"

        when:
        def dataObject = ThroughputLog.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }
}
