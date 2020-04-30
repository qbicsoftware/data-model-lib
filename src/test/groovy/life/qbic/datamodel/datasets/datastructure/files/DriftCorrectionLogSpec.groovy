package life.qbic.datamodel.datasets.datastructure.files

import life.qbic.datamodel.datasets.datastructure.files.nanopore.DriftCorrectionLog
import spock.lang.*

/**
 * Test for the DriftCorrectionLog class
 *
 * @author: Sven Fillinger
 */
class DriftCorrectionLogSpec extends Specification {

    @Shared Map propertyContainer

    def setupSpec() {
        propertyContainer = new HashMap()
        propertyContainer.name = "drift_correction"
    }    // runs once -  before the first feature method
    def setup() {}        // runs before every feature method
    def cleanup() {}      // runs after every feature method
    def cleanupSpec() {}  // runs once -  after the last feature method

    def "shall create a DriftCorrectionLog instance"()  {
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
