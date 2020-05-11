package life.qbic.datamodel.datasets

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.*

/**
 * A dataset that represents a Oxford Nanopore Measurement.
 *
 * @author: Sven Fillinger
 */
final class OxfordNanoporeMeasurement {

    private final Map<String, String> metadata

    private final Map<String, DataFolder> folders

    private final List<DataFile> logFiles

    private final MeasurementFolder measurementFolder

    private final boolean pooledSamplesMeasurement

    protected OxfordNanoporeMeasurement(String name, String path, List children, Map metadata) {
        this.logFiles = new ArrayList<>()
        this.folders = new HashMap<>()
        this.metadata = new HashMap()

        this.measurementFolder = MeasurementFolder.create(name, path, children)

        readMetaData(metadata)
        createContent()

        this.pooledSamplesMeasurement = folders["fast5passed"] ? folders["fast5passed"].getTheChildren().get(0) instanceof Fast5Folder : false
    }

    static OxfordNanoporeMeasurement create(String name, String path, List children, Map metadata) {
        return new OxfordNanoporeMeasurement(name, path, children, metadata)
    }

    private void readMetaData(Map<String, String> metadata) {
        this.metadata["start_date"] = metadata["start_date"]
        this.metadata["instrument"] = metadata["instrument"]
        this.metadata["flowcell_id"] = metadata["flowcell_id"]
        this.metadata["flowcell_position"] = metadata["flowcell_position"]
    }

    private void createContent() {
        measurementFolder.getTheChildren().each { element ->
            switch (element) {
                case Fast5PassFolder:
                    folders["fast5passed"] = element as Fast5PassFolder
                    break
                case Fast5FailFolder:
                    folders["fast5failed"] = element as Fast5FailFolder
                    break
                case FastQPassFolder:
                    folders["fastqpass"] = element as FastQPassFolder
                    break
                case FastQFailFolder:
                    folders["fastqfail"] = element as FastQFailFolder
                    break
                case DataFile:
                    logFiles.add(element as DataFile)
            }
        }
    }

    /**
     * This method aggregates all fast5 files and fastq files of an Oxford Nanopore
     * measurement by sample id.
     *
     * The resulting data-structure follows this map schema:
     *
     * "QBiC sample id":
     *      "fast5fail": DataFolder
     *      "fast5pass": DataFolder
     *      "fastqfail": DataFolder
     *      "fastqpass": DataFolder
     * "Other sample id":   // In case of pooled samples
     *      ...
     * @return Map A nested map with sample ids and containing data folders
     */
    Map<String, Map<String, DataFolder>> getRawDataPerSample(Experiment experiment) {
        if (pooledSamplesMeasurement) {
            return prepareRawDataFromPooledMeasurement()
        } else {
            return prepareRawData(experiment.sampleId)
        }
    }

    private Map<String, Map<String, DataFolder>> prepareRawDataFromPooledMeasurement() {
        final def result = new HashMap()
        final def pooledSampleIds = folders
                .get("fast5failed")
                .getTheChildren()
                .collect { (it as BarcodedFolder).getSampleId() }
        pooledSampleIds.each { sampleId ->
            final def map = [
                    "fast5fail": (folders.get("fast5failed") as DataFolder).getTheChildren().find {(it as BarcodedFolder).getSampleId()},
                    "fast5pass": (folders.get("fast5passed") as DataFolder).getTheChildren().find {(it as BarcodedFolder).getSampleId()},
                    "fastqpass": (folders.get("fastqpass") as DataFolder).getTheChildren().find {(it as BarcodedFolder).getSampleId()},
                    "fastqfail": (folders.get("fastqfail") as DataFolder).getTheChildren().find {(it as BarcodedFolder).getSampleId()}
            ]
            result[sampleId] = map
        }
        return result
    }

    private Map<String, Map<String, DataFolder>> prepareRawData(String sampleId) {
        final def result = new HashMap()
        final def folders = [
                "fast5fail": (folders.get("fast5failed") as DataFolder),
                "fast5pass": (folders.get("fast5passed") as DataFolder),
                "fastqpass": (folders.get("fastqpass") as DataFolder),
                "fastqfail": (folders.get("fastqfail") as DataFolder)
        ]
        result.put(sampleId, folders)
        return result
    }

    /**
     * This method returns a list of all log files from the Oxford Nanopore measurement.
     *
     * @return List A list of log files from the experiment
     */
    List<DataFile> getLogFiles() {
        return logFiles.collect { it }
    }

    /**
     * This method is used to return the relative path of a Oxford Nanopore measurement.
     *
     * The path is always relative to the Oxford Nanopore experiment root folder.
     *
     * Example:
     * QABCD001AE_nanopore_experiment
     *      |
     *      - 20200219_1107_1-E3-H3_PAE26974_454b8dc6 (measurement)
     *      |        |
     *      |        - ...
     *      - 20200219_1107_2-E4-H1_PAE00000_454b8dc6
     *
     * The resulting relative path would be:
     * <emph>QABCD001AE_nanopore_experiment/20200219_1107_1-E3-H3_PAE26974_454b8dc6</emph>
     * @return String This returns the relative path within the Nanopore experiment
     */
    String getRelativePath() {
        return this.relativePath
    }


}
