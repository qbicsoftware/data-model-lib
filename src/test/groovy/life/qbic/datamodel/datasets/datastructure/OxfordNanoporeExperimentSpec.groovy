package life.qbic.datamodel.datasets.datastructure

import groovy.json.JsonSlurper
import life.qbic.datamodel.datasets.OxfordNanoporeExperiment
import spock.lang.Shared
import spock.lang.Specification

/**
 * Tests for the OxfordNanoporeExperiment class
 *
 * @author: Sven Fillinger
 */
class OxfordNanoporeExperimentSpec extends Specification {

    /**
     * Map that stores the Oxford Nanopore folder structure
     * according to the schema_
     */
    @Shared
    Map minimalWorkingSimpleDataStructure

    def setupSpec() {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid-example.json")
        minimalWorkingSimpleDataStructure = (Map) new JsonSlurper().parse(stream)
    }

    def "Create simple sample Oxford Nanopore experiment successfully"() {
        given:
        final def example = minimalWorkingSimpleDataStructure

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements.get(0).logFiles.size() == 8

    }
}
