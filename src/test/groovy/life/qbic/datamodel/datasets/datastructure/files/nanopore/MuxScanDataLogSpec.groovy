package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class MuxScanDataLogSpec extends Specification {

    def "shall create a MaxScanDataLog instance"() {
        given:
        final name = "mux_scan_data.csv"
        final relativePath = "root/mux_scan_data.txt"

        when:
        def dataObject = MuxScanDataLog.create(name, relativePath)

        then:
        assert dataObject instanceof MuxScanDataLog
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "mux_scan.txt"
        final relativePath = "root/mux_scan.txt"

        when:
        def dataObject = MuxScanDataLog.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }

}
