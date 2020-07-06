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
     * according to the schema
     */
    @Shared
    Map minimalWorkingSimpleDataStructure

    /**
     * Map that that stores the Oxford Nanopore folder structure
     * according to the schema containing unclassified read information
     */
    @Shared
    Map unclassifiedWorkingDataStructure

    def setupSpec() {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid-example.json")
        minimalWorkingSimpleDataStructure = (Map) new JsonSlurper().parse(stream)
        stream.close()
        // read in unclassified example
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid-unclassified-example.json")
        unclassifiedWorkingDataStructure = (Map) new JsonSlurper().parse(stream)
        stream.close()
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

    def "Create unclassified example Oxford Nanopore experiment sucessfully"() {
        given:
        final def example = unclassifiedWorkingDataStructure

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()
        final def unclassifiedFolder = measurements.get(0).getUnclassifiedDataPerSample(experiment)

        then:
        assert unclassifiedFolder.get(0).fast5.getTheChildren().size() == 2

    }
}
