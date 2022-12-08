package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 */
class GuppyBasecallLogSpec extends Specification {

    def "shall create a GuppyBasecallingLog instance"() {
        given:
        final name = "guppy_basecall_client_log-.log"
        final relativePath = "root/basecalling/guppy_basecall_client_log-.log"

        when:
        def dataObject = GuppyBasecallLog.create(name, relativePath)

        then:
        assert dataObject instanceof GuppyBasecallLog
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "guppy_basecall.log"
        final relativePath = "root/basecalling/guppy_basecall.log"

        when:
        def dataObject = GuppyBasecallLog.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }

}
