package life.qbic.datamodel.datasets.datastructure

import life.qbic.datamodel.datasets.Experiment
import life.qbic.datamodel.datasets.OxfordNanoporeExperiment
import life.qbic.datamodel.datasets.OxfordNanoporeMeasurement
import life.qbic.datamodel.datasets.datastructure.files.nanopore.Fast5File
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.Fast5FailFolder
import spock.lang.Shared
import spock.lang.Specification

import static org.mockito.Mockito.*


/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class OxfordNanoporeMeasurementSpec extends Specification {

    @Shared List fast5PassedFolder
    @Shared Fast5FailFolder fast5FailedFolder
    @Shared List fastQPassedFolder
    @Shared List fastQFailedFolder

    def setupSpec() {
        def fast5File = Fast5File.create("test.fast5", "root/fast5")
        fast5FailedFolder = Fast5FailFolder.create("root/fast5_fail", [fast5File])
    }

    def "create measurement successfully"() {

        given:
        final def measurement = OxfordNanoporeMeasurement.create(
                "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                [fast5FailedFolder])

        and:
        final def mockedExperiment = mock(Experiment.class)
        when(mockedExperiment.getSampleId()).thenReturn("QABCD001AE")

        when:
        def result = measurement.getRawDataPerSample(mockedExperiment)


        then:
        assert result.size() == 1
    }

}
