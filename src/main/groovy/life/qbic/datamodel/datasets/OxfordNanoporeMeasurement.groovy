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

    private final List fast5PassedContent

    private final List fast5FailedContent

    private final List fastQPassedContent

    private final List fastQFailedContent

    private final List<DataFile> logFiles

    private final MeasurementFolder measurementFolder

    private final boolean pooledMeasurement

    protected OxfordNanoporeMeasurement(String name, String path, List children) {
        fast5PassedContent = new ArrayList<>()
        fast5FailedContent = new ArrayList<>()
        fastQFailedContent = new ArrayList<>()
        fastQPassedContent = new ArrayList<>()
        logFiles = new ArrayList<>()

        this.measurementFolder = MeasurementFolder.create(name, path, children)

        createContent()

        pooledMeasurement = fast5PassedContent ? fast5PassedContent.get(0) instanceof BarcodedFolder : false
    }

    static OxfordNanoporeMeasurement create(String name, String path, List children) {
        return new OxfordNanoporeMeasurement(name, path, children)
    }

    private void createContent() {
        measurementFolder.getTheChildren().each { element ->
            switch (element) {
                case Fast5PassFolder:
                    fast5PassedContent.add(element as Fast5PassFolder)
                    break
                case Fast5FailFolder:
                    fast5FailedContent.add(element as Fast5FailFolder)
                    break
                case FastQPassFolder:
                    fastQPassedContent.add(element as FastQPassFolder)
                    break
                case FastQFailFolder:
                    fastQFailedContent.add(element as FastQFailFolder)
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
        def result = new HashMap()
        def folders = [
                "fast5fail": fast5FailedContent,
                "fast5pass": fast5PassedContent,
                "fastqpass": fastQPassedContent,
                "fastqfail": fastQFailedContent
        ]
        result.put(experiment.getSampleId(), folders)
        return result
    }

    /**
     * This method returns a list of all log files from the Oxford Nanopore measurement.
     *
     * @return List A list of log files from the experiment
     */
    List<DataFile> getLogFiles() {
        def logFileList = []
        this.logFiles.each { logfile ->
            logFileList.add(DataFile.create(logfile.getName(), logfile.getRelativePath(), logfile.getFileType()))
        }
        return logFileList
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
