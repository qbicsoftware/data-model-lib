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

    @Shared
    Map minimalWorkingPooledDataStructure

    def setupSpec() {
        InputStream singleSampleStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid-example.json")
        minimalWorkingSimpleDataStructure = (Map) new JsonSlurper().parse(singleSampleStream)

        InputStream pooledSampleStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid-example-pooled.json")
        minimalWorkingPooledDataStructure = (Map) new JsonSlurper().parse(pooledSampleStream)
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
    }

    def "Create a simple pooled Oxford Nanopore experiment successfully"() {
        given:
        final def example = minimalWorkingPooledDataStructure

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements.get(0).logFiles.size() == 8
        // two samples in measurement
        assert measurements.get(0).getRawDataPerSample(experiment).keySet().size() == 2

    }
}
