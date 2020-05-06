package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.nanopore.DriftCorrectionLog
import spock.lang.Specification

/**
 * Test for the DriftCorrectionLog class
 *
 * @author: Sven Fillinger
 */
class DriftCorrectionLogSpec extends Specification {

    def "shall create a DriftCorrectionLog instance"() {
        given:
        final name = "drift_correction_testfile.log"
        final path = "root/drift_correction_testfile.log"

        when:
        def dataObject = DriftCorrectionLog.create(name, path)

        then:
        assert dataObject instanceof DriftCorrectionLog
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "drift_testfile.log"
        final path = "root/drift_testfile.log"

        when:
        def dataObject = DriftCorrectionLog.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }

}
