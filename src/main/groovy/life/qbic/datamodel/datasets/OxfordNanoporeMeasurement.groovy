package life.qbic.datamodel.datasets

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.BarcodedFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.Fast5FailFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.Fast5PassFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.FastQFailFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.FastQPassFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.MeasurementFolder

/**
 * A dataset that represents a Oxford Nanopore Measurement.
 *
 * @author: Sven Fillinger
 */
class OxfordNanoporeMeasurement {

    private final List<?> fast5PassedContent

    private final List<?> fast5FailedContent

    private final List<?> fastQPassedContent

    private final List<?> fastQFailedContent

    private final List<DataFile> logFiles

    private final MeasurementFolder measurementFolder

    private final boolean pooledMeasurement

    OxfordNanoporeMeasurement(String name, String path, List<?> children) {
        fast5PassedContent = new ArrayList<>()
        fast5FailedContent = new ArrayList<>()
        fastQFailedContent = new ArrayList<>()
        fastQPassedContent = new ArrayList<>()
        logFiles = new ArrayList<>()

        this.measurementFolder = MeasurementFolder.create(name, path, children)

        createContent()

        pooledMeasurement = fast5PassedContent.get(0) instanceof BarcodedFolder
    }

    private void createContent() {
        measurementFolder.children.each { element ->
            switch (element) {
                case element instanceof Fast5PassFolder:
                    fast5PassedContent.add(element as Fast5PassFolder)
                    break
                case element instanceof Fast5FailFolder:
                    fast5FailedContent.add(element as Fast5FailFolder)
                    break
                case element instanceof FastQPassFolder:
                    fastQPassedContent.add(element as FastQPassFolder)
                    break
                case element instanceof FastQFailFolder:
                    fastQFailedContent.add(element as FastQFailFolder)
                    break
                case element instanceof DataFile:
                    logFiles.add(element as DataFile)
            }
        }
    }

    List getFastQPassedContent() {
        return this.fast5PassedContent
    }

    List<DataFile> getLogFiles() {
        def logFileList = []
        this.logFiles.each { logfile ->
            logFileList.add(DataFile.create(logfile.getName(), logfile.getRelativePath(), logfile.getFileType()))
        }
        return logFileList
    }

    boolean containsPooledSamples() {
        return this.pooledMeasurement
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
