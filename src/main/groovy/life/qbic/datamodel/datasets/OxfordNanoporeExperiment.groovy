package life.qbic.datamodel.datasets

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

import java.lang.reflect.Method

/**
 * Class that holds information about an Oxford Nanopore Experiment.
 *
 * @author: Sven Fillinger
 */
final class OxfordNanoporeExperiment {

    private final List<OxfordNanoporeMeasurement> measurements

    private final String qbicId

    private final static Set nanoporeFileTypes = [
            "DriftCorrectionLog",
            "DutyTimeLog",
            "Fast5File",
            "FinalSummaryLog",
            "MuxScanDataLog",
            "ReportMdLog",
            "ReportPDFLog",
            "SequencingSummaryLog",
            "ThroughputLog"
    ]

    private final static Set nanoporeFolderTypes = [
            "Fast5Folder",
            "FastQFolder",
            "Fast5PassFolder",
            "Fast5FailFolder",
            "FastQPassFolder",
            "FastQFailFolder"
    ]

    private OxfordNanoporeExperiment(String qbicId, List<OxfordNanoporeMeasurement> measurements) {
        this.measurements = measurements
        this.qbicId = qbicId
    }

    /**
     * Static factory method that creates a new instance from a Oxford Nanopore sequencer output.
     * @param nanoPoreSequencerOutput
     * @return OxfordNanoporeExperiment A new instance of a nanopore experiment.
     */
    static OxfordNanoporeExperiment create(Map nanoPoreSequencerOutput) {
        final String qbicId = parseQbicIdFromRootFolder(nanoPoreSequencerOutput)
        final List<OxfordNanoporeMeasurement> measurements = parseMeasurements(nanoPoreSequencerOutput)
        return new OxfordNanoporeExperiment(qbicId, measurements)
    }

    /*
    Helper method that parses the QBiC identifier from the root folder name
     */
    private static String parseQbicIdFromRootFolder(Map nanoPoreSequencerOutput) {
        def id = Objects.requireNonNull(nanoPoreSequencerOutput.get("name"), "The root folder must contain a name property.")
        return id
    }

    /*
    Helper method that creates the measurements from the sequencer output
     */
    private static List<OxfordNanoporeMeasurement> parseMeasurements(Map nanoPoreSequencerOutput) {
        final def measurements = []
        Objects.requireNonNull(nanoPoreSequencerOutput.get("children"), "The root folder must contain at least one measurement folder.")
        nanoPoreSequencerOutput.get("children").each { Map measurementItem ->
            def name = measurementItem.get("name") as String
            def relativePath = measurementItem.get("path") as String
            def children = parseMeasurementItems(measurementItem.get("children") as List)
            measurements.add(new OxfordNanoporeMeasurement(name, relativePath, children))
        }
        return measurements
    }

    /*
    Helper method that creates a list of mixed DataFolders and DataFiles instances
     */
    private static List parseMeasurementItems(List<Map> items) {
        final def children = []
        items.each { item ->
            def itemName = Objects.requireNonNull(item.get("name") as String, "A measurement child must contain a name.")
            if (itemName.toLowerCase().contains("log")) {
                children.add(parseFile(item))
            } else {
                children.add(parseFolder(item))
            }
        }
        return children
    }

    /*
    Helper method that creates a DataFile instance from a map
     */
    private static DataFile parseFile(Map fileTree) {
        def name = fileTree.get("name")
        def path = fileTree.get("path")
        for (String nanoPoreFileType : nanoporeFileTypes) {
            Class<?> c = Class.forName(nanoPoreFileType)
            Method method = c.getDeclaredMethod("create", String.class, String.class)
            try {
                DataFile dataFile = method.invoke(null, name, path) as DataFile
                return dataFile
            } catch (IllegalArgumentException e){
                // Do nothing
            }
        }
        throw new IllegalArgumentException("File $name is of unknown Oxford Nanopore file type.")
    }

    /*
    Helper method that creates a DataFolder instance from a map
     */
    private static DataFolder parseFolder(Map fileTree) {
        def name = fileTree.get("name")
        def path = fileTree.get("path")
        def children = []
        fileTree.get("children").each { Map unknownChild ->
            try {
                def child = parseFolder(unknownChild)
                children.add(child)
            } catch (IllegalArgumentException e) {
                // We do not capture the second parse call, as we want to fail the parsing at this point.
                // This means that we ultimately found an child of unknown type, which should
                // break the parsing.
                def child = parseFile(unknownChild)
                children.add(child)
            }
        }
        for (String nanoPoreFolderType : nanoporeFolderTypes) {
            Class<?> c = Class.forName(nanoPoreFolderType)
            Method method = c.getDeclaredMethod("create", String.class, String.class, List.class)
            try {
                DataFolder dataFolder = method.invoke(null, name, path, children) as DataFolder
                return dataFolder
            } catch (IllegalArgumentException e){
                // Do nothing
            }
        }
        throw new IllegalArgumentException("Folder $name is of unknown Oxford Nanopore folder type.")
    }
}
