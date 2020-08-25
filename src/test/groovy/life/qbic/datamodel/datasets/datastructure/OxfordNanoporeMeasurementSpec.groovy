package life.qbic.datamodel.datasets.datastructure

import life.qbic.datamodel.datasets.ExperimentFolder
import life.qbic.datamodel.datasets.OxfordNanoporeMeasurement
import life.qbic.datamodel.datasets.datastructure.files.nanopore.Fast5File
import life.qbic.datamodel.datasets.datastructure.files.nanopore.FastQFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.*
import spock.lang.Shared
import spock.lang.Specification


/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class OxfordNanoporeMeasurementSpec extends Specification {

    @Shared
    Fast5PassFolder fast5PassedFolder
    @Shared
    Fast5FailFolder fast5FailedFolder
    @Shared
    FastQPassFolder fastQPassedFolder
    @Shared
    FastQFailFolder fastQFailedFolder
    @Shared
    Fast5Folder fast5PooledFolder
    @Shared
    FastQFolder fastQPooledFolder
    @Shared
    Fast5Folder otherfast5PooledFolder
    @Shared
    FastQFolder otherfastQPooledFolder
    @Shared
    UnclassifiedFast5Folder unclassifiedFast5Folder
    @Shared
    UnclassifiedFastQFolder unclassifiedFastQFolder
    @Shared
    Map metaData

    def setupSpec() {
        metaData = [
                "adapter": "flongle",
                "asic_temp": "32.631687",
                "base_caller": "Guppy",
                "base_caller_version": "3.2.8+bd67289",
                "device_type" : "promethion",
                "flow_cell_id": "PAE26306",
                "flow_cell_product_code": "FLO-PRO002",
                "flow_cell_position": "2-A3-D3",
                "guppy_version":  "3.2.8+bd67289",
                "hostname": "PCT0094",
                "protocol": "sequencing/sequencing_PRO002_DNA:FLO-PRO002:SQK-LSK109:True",
                "started": "2020-02-11T15:52:10.465982+01:00"
        ]
        def fast5File = Fast5File.create("test.fast5", "root/test.fast5")
        def fastQFile = FastQFile.create("test.fastq", "root/test.fastq")
        fast5FailedFolder = Fast5FailFolder.create("fast5_fail","root/fast5_fail", [fast5File])
        fast5PassedFolder = Fast5PassFolder.create("fast5_pass","root/fast5_pass", [fast5File])
        fastQFailedFolder = FastQFailFolder.create("fastq_fail", "root/fastq_fail", [fastQFile])
        fastQPassedFolder = FastQPassFolder.create("fastq_pass","root/fastq_pass", [fastQFile])
        // Content for the pooled samples
        fast5PooledFolder = Fast5Folder.create("QTEST001AE_test", "root/QTEST001AE_test", [fast5File])
        fastQPooledFolder = FastQFolder.create("QTEST001AE_test", "root/QTEST001AE_test", [fastQFile])
        otherfast5PooledFolder = Fast5Folder.create("QD00M001AE_test", "root/QD00M001AE_test", [fast5File])
        otherfastQPooledFolder = FastQFolder.create("QD00M001AE_test", "root/QD00M001AE_test", [fastQFile])
        // Content for the pooled samples including unclassified folders
        unclassifiedFast5Folder = UnclassifiedFast5Folder.create("unclassified", "fast5_fail/unclassified", [fast5File])
        unclassifiedFastQFolder = UnclassifiedFastQFolder.create("unclassified", "fastq_pass/unclassified", [fastQFile])
    }

    def "create simple measurement successfully"() {
        given:
        final def measurement = OxfordNanoporeMeasurement.create(
                "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                [fast5FailedFolder, fast5PassedFolder, fastQFailedFolder, fastQPassedFolder],
                metaData)

        and:
        final def mockedExperiment = Mock(ExperimentFolder.class)
        mockedExperiment.getSampleCode() >> "QABCD001AE"

        when:
        def result = measurement.getRawDataPerSample(mockedExperiment)
        def libraryKit = measurement.getLibraryPreparationKit()
        def adapter = measurement.getAdapter()

        then:
        assert result.size() == 1
        assert result.get("QABCD001AE").get("fast5fail") instanceof DataFolder
        assert result.get("QABCD001AE").get("fast5pass") instanceof DataFolder
        assert result.get("QABCD001AE").get("fastqfail") instanceof DataFolder
        assert result.get("QABCD001AE").get("fastqpass") instanceof DataFolder
        assert measurement.relativePath == "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6"
        assert libraryKit == "SQK-LSK109"
        assert adapter.equals("flongle")
    }

    def "create pooled sample measurement successfully"() {
        given:
        final def pooledFast5PassFolder = Fast5PassFolder.create("fast5_pass", "root/fast5_pass", [fast5PooledFolder, otherfast5PooledFolder])
        final def pooledFast5FailedFolder = Fast5FailFolder.create("fast5_fail","root/fast5_fail", [fast5PooledFolder, otherfast5PooledFolder])
        final def pooledFastQPassFolder = FastQPassFolder.create("fastq_pass", "root/fastq_pass", [fastQPooledFolder, otherfastQPooledFolder])
        final def pooledFastQFailedFolder = FastQFailFolder.create("fastq_fail", "root/fastq_fail", [fastQPooledFolder, otherfastQPooledFolder])

        final def measurement = OxfordNanoporeMeasurement.create(
                "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                [pooledFast5PassFolder, pooledFast5FailedFolder, pooledFastQPassFolder, pooledFastQFailedFolder],
                metaData)

        and:
        final def mockedExperiment = Mock(ExperimentFolder.class)
        mockedExperiment.getSampleCode() >> "QABCD001AE"

        when:
        def result = measurement.getRawDataPerSample(mockedExperiment)

        then:
        assert result.size() == 2
        assert result.get("QTEST001AE").get("fast5fail") instanceof DataFolder
        assert result.get("QD00M001AE").get("fast5fail") instanceof DataFolder
        assert result.get("QTEST001AE").get("fast5fail") == result.get("QTEST001AE").get("fast5fail")
        assert result.get("QD00M001AE").get("fast5fail") != result.get("QTEST001AE").get("fast5fail")
        assert result.get("QTEST001AE").get("fast5pass") == result.get("QTEST001AE").get("fast5pass")
        assert result.get("QD00M001AE").get("fast5pass") != result.get("QTEST001AE").get("fast5pass")
    }
    
    def "create pooled sample measurement with unclassified folders successfully"() {
        given:
        final def pooledFast5PassFolder = Fast5PassFolder.create("fast5_pass", "root/fast5_pass", [fast5PooledFolder, otherfast5PooledFolder, unclassifiedFast5Folder])
        final def pooledFast5FailedFolder = Fast5FailFolder.create("fast5_fail","root/fast5_fail", [fast5PooledFolder, otherfast5PooledFolder, unclassifiedFast5Folder])
        final def pooledFastQPassFolder = FastQPassFolder.create("fastq_pass", "root/fastq_pass", [fastQPooledFolder, otherfastQPooledFolder, unclassifiedFastQFolder])
        final def pooledFastQFailedFolder = FastQFailFolder.create("fastq_fail", "root/fastq_fail", [fastQPooledFolder, otherfastQPooledFolder, unclassifiedFastQFolder])

        final def measurement = OxfordNanoporeMeasurement.create(
                "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                [pooledFast5PassFolder, pooledFast5FailedFolder, pooledFastQPassFolder, pooledFastQFailedFolder],
                metaData)

        and:
        final def mockedExperiment = Mock(ExperimentFolder.class)
        mockedExperiment.getSampleCode() >> "QABCD001AE"

        when:
        def result = measurement.getRawDataPerSample(mockedExperiment)
        def unclassified = measurement.getUnclassifiedData()

        then:
        assert result.size() == 2
        assert result.get("QTEST001AE").get("fast5fail") instanceof DataFolder
        assert result.get("QD00M001AE").get("fast5fail") instanceof DataFolder
        assert result.get("QTEST001AE").get("fast5fail") == result.get("QTEST001AE").get("fast5fail")
        assert result.get("QD00M001AE").get("fast5fail") != result.get("QTEST001AE").get("fast5fail")
        assert result.get("QTEST001AE").get("fast5pass") == result.get("QTEST001AE").get("fast5pass")
        assert result.get("QD00M001AE").get("fast5pass") != result.get("QTEST001AE").get("fast5pass")
        
        assert unclassified.size() == 4
        assert unclassified.get("fast5fail") instanceof DataFolder
        assert unclassified.get("fast5pass") instanceof DataFolder
        assert unclassified.get("fastqpass") instanceof DataFolder
        assert unclassified.get("fastqfail") instanceof DataFolder
        assert unclassified.get("fast5fail").getChildren().size() == 1
    }
    
    def "incomplete metadata should throw an IllegalArgumentException"() {
        given:
        // Missing hostname
        def metaData = [
                "adapter": "flongle",
                "asic_temp": "32.631687",
                "base_caller": "Guppy",
                "base_caller_version": "3.2.8+bd67289",
                "device_type" : "promethion",
                "flow_cell_id": "PAE26306",
                "flow_cell_product_code": "FLO-PRO002",
                "flow_cell_position": "2-A3-D3",
                "protocol": "sequencing/sequencing_PRO002_DNA:FLO-PRO002:SQK-LSK109:True",
                "started": "2020-02-11T15:52:10.465982+01:00"
        ]

        when:
        final def measurement = OxfordNanoporeMeasurement.create(
                "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
                [fast5FailedFolder, fast5PassedFolder, fastQFailedFolder, fastQPassedFolder],
                metaData)

        then:
        thrown(IllegalArgumentException)

    }

    def "If both fast5 pass and fail folder are empty, an IllegalStateException shall be thrown"() {
        given:
        def emptyfast5FailedFolder = Fast5FailFolder.create("fast5_fail","root/fast5_fail", [])
        def emptyfast5PassedFolder = Fast5PassFolder.create("fast5_pass","root/fast5_pass", [])

        when:
        OxfordNanoporeMeasurement.create(
            "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            [emptyfast5PassedFolder, emptyfast5FailedFolder, fastQPassedFolder, fastQFailedFolder],
            metaData)

        then:
        thrown(IllegalStateException)

    }

    def "If both fastq pass and fail folder are empty, an IllegalStateException shall be thrown"() {
        given:
        def emptyFastQFailedFolder = FastQFailFolder.create("fastq_fail","root/fastq_fail", [])
        def emptyFastQPassedFolder = FastQPassFolder.create("fastq_pass","root/fastq_pass", [])

        when:
        OxfordNanoporeMeasurement.create(
            "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            [fast5PassedFolder, fast5FailedFolder, emptyFastQFailedFolder, emptyFastQPassedFolder],
            metaData)

        then:
        thrown(IllegalStateException)

    }

    def "If either fastq pass or fail folder is empty, no IllegalStateException shall be thrown"() {
        given:
        def emptyFastQFailedFolder = FastQFailFolder.create("fastq_fail","root/fastq_fail", [])

        when:
        OxfordNanoporeMeasurement.create(
            "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            [fast5PassedFolder, fast5FailedFolder, emptyFastQFailedFolder, fastQPassedFolder],
            metaData)

        then:
        noExceptionThrown()
    }

    def "If either fast5 pass or fail folder is empty, no IllegalStateException shall be thrown"() {
        given:
        def emptyFast5FailedFolder = Fast5FailFolder.create("fast5_fail","root/fast5_fail", [])

        when:
        OxfordNanoporeMeasurement.create(
            "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            [fast5PassedFolder, emptyFast5FailedFolder, fastQPassedFolder, fastQFailedFolder],
            metaData)

        then:
        noExceptionThrown()
    }

    def "missing adapter metadata shall return an empty String and not be null"() {
        given:
        def metaData = [
            "asic_temp": "32.631687",
            "base_caller": "Guppy",
            "base_caller_version": "3.2.8+bd67289",
            "device_type" : "promethion",
            "flow_cell_id": "PAE26306",
            "flow_cell_product_code": "FLO-PRO002",
            "flow_cell_position": "2-A3-D3",
            "hostname": "PCT0094",
            "protocol": "sequencing/sequencing_PRO002_DNA:FLO-PRO002:SQK-LSK109:True",
            "started": "2020-02-11T15:52:10.465982+01:00"
        ]

        when:
        final def measurement = OxfordNanoporeMeasurement.create(
            "20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            "path/20200219_1107_1-E3-H3_PAE26974_454b8dc6",
            [fast5FailedFolder, fast5PassedFolder, fastQFailedFolder, fastQPassedFolder],
            metaData)
        final def adapter = measurement.getAdapter()

        then:
        assert adapter.isEmpty()

    }

}
