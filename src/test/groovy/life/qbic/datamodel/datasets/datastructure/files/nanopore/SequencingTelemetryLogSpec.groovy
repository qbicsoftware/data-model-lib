package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 */
class SequencingTelemetryLogSpec extends Specification {

    def "shall create a SequencingTelemetryLog instance"() {
        given:
        final name = "sequencing_telemetry_.js"
        final relativePath = "root/basecalling/sequencing_telemetry_.js"

        when:
        def dataObject = SequencingTelemetryLog.create(name, relativePath)

        then:
        assert dataObject instanceof SequencingTelemetryLog
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "telemetry.log"
        final relativePath = "root/basecalling/telemetry.log"

        when:
        def dataObject = SequencingTelemetryLog.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }

}
