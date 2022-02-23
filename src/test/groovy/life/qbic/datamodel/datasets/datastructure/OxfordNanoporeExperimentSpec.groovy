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
     * Newer map that stores the Oxford Nanopore folder structure
     * according to the schema that puts some reports in its own folder and adds a new report
     */
    @Shared
    Map minimalWorkingSimpleDataStructureWithReportsFolder
    /**
     * Map that that stores the Oxford Nanopore folder structure
     * according to the schema containing unclassified read information
     */
    @Shared
    Map unclassifiedWorkingDataStructure
    /**
     * Map that that stores the Oxford Nanopore folder structure
     * according to the schema containing pooled samples read information
     */
    @Shared
    Map minimalWorkingPooledDataStructure

    def setupSpec() {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid-example.json")
        minimalWorkingSimpleDataStructure = (Map) new JsonSlurper().parse(stream)
        // new example with slightly different structure
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid-example-newer.json")
        minimalWorkingSimpleDataStructureWithReportsFolder = (Map) new JsonSlurper().parse(stream)
        // read in unclassified example
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid-example-unclassified.json")
        unclassifiedWorkingDataStructure = (Map) new JsonSlurper().parse(stream)
        // read in pooled example
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid-example-pooled.json")
        minimalWorkingPooledDataStructure = (Map) new JsonSlurper().parse(stream)
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
        assert measurements[0].libraryPreparationKit == "SQK-LSK109"
    }

    def "Create simple sample Oxford Nanopore experiment successfully for newer structure"() {
        given:
        final def example = minimalWorkingSimpleDataStructureWithReportsFolder

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].libraryPreparationKit == "SQK-LSK109-XL"
    }

    def "Create a simple pooled Oxford Nanopore experiment successfully"() {
        given:
        final def example = minimalWorkingPooledDataStructure

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()
        final def rawData = measurements[0].getRawDataPerSample(experiment)

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements.get(0).logFiles.size() == 8
        // two samples in measurement
        assert rawData.size() == 2

    }

    def "Create unclassified example Oxford Nanopore experiment sucessfully"() {
        given:
        final def example = unclassifiedWorkingDataStructure

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()
        final def unclassifiedFolder = measurements[0].getUnclassifiedData()
        final def fast5PassUnclassifiedFolder =  unclassifiedFolder.fast5pass
        final def fast5FailUnclassifiedFolder =  unclassifiedFolder.fast5fail
        final def fastQPassUnclassifiedFolder =  unclassifiedFolder.fastqpass
        final def fastQFailUnclassifiedFolder =  unclassifiedFolder.fastqfail

        then:
        assert measurements.size() == 1
        assert fast5PassUnclassifiedFolder.getChildren().size() == 1
        assert fast5FailUnclassifiedFolder.getChildren().size() == 1
        assert fastQPassUnclassifiedFolder.getChildren().size() == 1
        assert fastQFailUnclassifiedFolder.getChildren().size() == 1

    }
}
