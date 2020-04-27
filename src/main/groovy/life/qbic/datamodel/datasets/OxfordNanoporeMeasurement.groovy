package life.qbic.datamodel.datasets

import life.qbic.datamodel.datasets.datastructure.files.DataFile
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

    OxfordNanoporeMeasurement(String name, String path, List<?> children) {
        fast5PassedContent = new ArrayList<>()
        fast5FailedContent = new ArrayList<>()
        fastQFailedContent = new ArrayList<>()
        fastQPassedContent = new ArrayList<>()
        logFiles = new ArrayList<>()

        this.measurementFolder = MeasurementFolder.create(name, path, children)

        createContent()
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




}
