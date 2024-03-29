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
    Map minimalSimpleDataStructure
    /**
     * Map that stores the Oxford Nanopore folder structure
     * according to the schema with an alternate report file ending
     */
    @Shared
    Map minimalSimpleDataStructureWithHtmlReport
    /**
     * Newer map that stores the Oxford Nanopore folder structure according to the
     * schema that puts some reports in its own folder and adds a barcode alignment report
     */
    @Shared
    Map extendedDataStructureWithReportsFolder
    /**
     * Addition to the newer structure, that changes report file types and adds a pore
     * activity report
     */
    @Shared
    Map extendedDataStructureWithReportsFolderV3

    /**
     * Addition to the newest structure, containing a second basecalling run
     */
    @Shared
    Map extendedDataStructureWithReportsFolderV4

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
    Map pooledDataStructure

    @Shared
    Map minimalDataStructure

    @Shared
    Map minimalDataStructurePooled

    @Shared
    Map minimalDoradoDataStructure

    @Shared
    Map fullDoradoDataStructure

    def setupSpec() {
        def folder = "nanopore/"
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-example.json")
        minimalSimpleDataStructure = (Map) new JsonSlurper().parse(stream)
        //example with report.html instead of report.html
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-example-html-report.json")
        minimalSimpleDataStructureWithHtmlReport = (Map) new JsonSlurper().parse(stream)
        // example with slightly different structure
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-example-v2.json")
        extendedDataStructureWithReportsFolder = (Map) new JsonSlurper().parse(stream)
        // latest example with slightly different structure
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-example-v3.json")
        extendedDataStructureWithReportsFolderV3 = (Map) new JsonSlurper().parse(stream)
        // nanopore structure containing a second basecalling folder
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-example-v4-with-basecalling.json")
        extendedDataStructureWithReportsFolderV4 = (Map) new JsonSlurper().parse(stream)
        // read in unclassified example
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-example-unclassified.json")
        unclassifiedWorkingDataStructure = (Map) new JsonSlurper().parse(stream)
        // read in pooled example
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-example-pooled.json")
        pooledDataStructure = (Map) new JsonSlurper().parse(stream)
        // read in minimal required example
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-minimal-structure.json")
        minimalDataStructure = (Map) new JsonSlurper().parse(stream)
        // read in minimal required pooled example
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-minimal-structure-pooled.json")
        minimalDataStructurePooled = (Map) new JsonSlurper().parse(stream)
        // read in minimal required example with dorado based basecalling
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-minimal-structure-dorado-basecaller.json")
        minimalDoradoDataStructure = (Map) new JsonSlurper().parse(stream)
        stream.close()
        // read in minimal required example with dorado based basecalling
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(folder+"valid-example-dorado-basecaller.json")
        fullDoradoDataStructure = (Map) new JsonSlurper().parse(stream)
        stream.close()
    }

    def "Create simple sample Oxford Nanopore experiment successfully"() {
        given:
        final def example = minimalSimpleDataStructure

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].libraryPreparationKit == "SQK-LSK109"
    }

    def "Create simple sample Oxford Nanopore experiment including an html report successfully"() {
        given:
        final def example = minimalSimpleDataStructureWithHtmlReport

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].libraryPreparationKit == "SQK-LSK109"
    }

    def "Create sample Oxford Nanopore experiment successfully for newer structure"() {
        given:
        final def example = extendedDataStructureWithReportsFolder

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].asicTemp == "32.631687"
    }

    def "Create sample Oxford Nanopore experiment successfully for latest structure"() {
        given:
        final def example = extendedDataStructureWithReportsFolderV3

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].asicTemp == "32.631687"
    }

    def "Create sample Oxford Nanopore experiment successfully for structure with second basecalling"() {
        given:
        final def example = extendedDataStructureWithReportsFolderV4

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].asicTemp == "32.631687"
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("basecalling")
        assert !measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").get("basecalling").relativePath.isEmpty()
        assert !measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").get("basecalling").children.isEmpty()
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").get("basecalling").name.size() > 0
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("fastqfail")
    }

    def "Create sample Oxford Nanopore experiment successfully for the minimal required structure"() {
        given:
        final def example = minimalDataStructure

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].asicTemp == "32.631687"
        assert !measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("pod5_skip")
        assert !measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("fast5_skip")
    }

    def "Create sample Oxford Nanopore experiment successfully for the minimal required pooled structure"() {
        given:
        final def example = minimalDataStructurePooled

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].asicTemp == "32.631687"
    }

    def "Create sample Oxford Nanopore experiment successfully for dorado basecaller generated minimal structure"() {
        given:
        final def example = minimalDoradoDataStructure

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].asicTemp == "32.631687"
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("pod5skip")
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("fast5skip")
    }

    def "Create sample Oxford Nanopore experiment successfully for dorado basecaller generated full structure"() {
        given:
        final def example = fullDoradoDataStructure

        when:
        final def experiment = OxfordNanoporeExperiment.create(example)
        final def measurements = experiment.getMeasurements()

        then:
        assert experiment.sampleCode == "QABCD001AB"
        assert measurements.size() == 1
        assert measurements[0].asicTemp == "32.631687"
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("pod5skip")
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("fast5skip")
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("fast5pass")
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("fast5fail")
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("pod5pass")
        assert measurements[0].getRawDataPerSample(experiment).get("QABCD001AB").containsKey("pod5fail")
    }

    def "Create a simple pooled Oxford Nanopore experiment successfully"() {
        given:
        final def example = pooledDataStructure

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

    def "Create unclassified example Oxford Nanopore experiment successfully"() {
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
