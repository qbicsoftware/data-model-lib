package life.qbic.datamodel.datasets.datastructure

import life.qbic.datamodel.datasets.Experiment
import life.qbic.datamodel.datasets.OxfordNanoporeMeasurement
import life.qbic.datamodel.datasets.datastructure.files.nanopore.Fast5File
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.Fast5FailFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.Fast5PassFolder
import spock.lang.Shared
import spock.lang.Specification

import static org.mockito.Mockito.*


/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class OxfordNanoporeMeasurementSpec extends Specification {

    @Shared Fast5PassFolder fast5PassedFolder
    @Shared Fast5FailFolder fast5FailedFolder
    @Shared List fastQPassedFolder
    @Shared List fastQFailedFolder

    def setupSpec() {
        def fast5File = Fast5File.create("test.fast5", "root/fast5")
        fast5FailedFolder = Fast5FailFolder.create("root/fast5_fail", [fast5File])
        fast5PassedFolder = Fast5PassFolder.create("root/fast5_pass", [fast5File])
    }

    def "create simple measurement successfully"() {

        given:
        final def measurement = OxfordNanoporeMeasurement.create(
                "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                [fast5FailedFolder, fast5PassedFolder])

        and:
        final def mockedExperiment = mock(Experiment.class)
        when(mockedExperiment.getSampleId()).thenReturn("QABCD001AE")

        when:
        def result = measurement.getRawDataPerSample(mockedExperiment)


        then:
        assert result.size() == 1
        assert result.get("QABCD001AE").get("fast5fail").get(0) instanceof DataFolder
        assert result.get("QABCD001AE").get("fast5pass").get(0) instanceof DataFolder
    }

}
