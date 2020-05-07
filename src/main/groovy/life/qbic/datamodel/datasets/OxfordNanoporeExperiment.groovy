package life.qbic.datamodel.datasets

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.identifiers.SampleCodeFunctions

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Class that holds information about an Oxford Nanopore Experiment.
 *
 * @author: Sven Fillinger
 */
final class OxfordNanoporeExperiment implements Experiment {

    // Fully qualified domain name of the nanopore folder structure package
    private final static String FQDN_FOLDERS = "life.qbic.datamodel.datasets.datastructure.folders.nanopore"
    // Fully qualified domain name of the nanopore file structure package
    private final static String FQDN_FILES = "life.qbic.datamodel.datasets.datastructure.files.nanopore"

    private final List<OxfordNanoporeMeasurement> measurements

    private final String sampleId

    private final static Set nanoporeFileTypes = [
            FQDN_FILES + ".DriftCorrectionLog",
            FQDN_FILES + ".DutyTimeLog",
            FQDN_FILES + ".Fast5File",
            FQDN_FILES + ".FastQFile",
            FQDN_FILES + ".FastQZippedFile",
            FQDN_FILES + ".FinalSummaryLog",
            FQDN_FILES + ".MuxScanDataLog",
            FQDN_FILES + ".ReportMdLog",
            FQDN_FILES + ".ReportPDFLog",
            FQDN_FILES + ".SequencingSummaryLog",
            FQDN_FILES + ".ThroughputLog"
    ]

    private final static Set nanoporeFolderTypes = [
            FQDN_FOLDERS + ".Fast5Folder",
            FQDN_FOLDERS + ".FastQFolder",
            FQDN_FOLDERS + ".Fast5PassFolder",
            FQDN_FOLDERS + ".Fast5FailFolder",
            FQDN_FOLDERS + ".FastQPassFolder",
            FQDN_FOLDERS + ".FastQFailFolder"
    ]

    private OxfordNanoporeExperiment(String sampleId, List<OxfordNanoporeMeasurement> measurements) {
        this.measurements = measurements
        this.sampleId = sampleId
    }

    /**
     * Static factory method that creates a new instance from a Oxford Nanopore sequencer output.
     * @param nanoPoreSequencerOutput
     * @return OxfordNanoporeExperiment A new instance of a nanopore experiment.
     */
    static OxfordNanoporeExperiment create(Map nanoPoreSequencerOutput) {
        final String sampleId = parseQbicIdFromRootFolder(nanoPoreSequencerOutput)
        final List<OxfordNanoporeMeasurement> measurements = parseMeasurements(nanoPoreSequencerOutput)
        return new OxfordNanoporeExperiment(sampleId, measurements)
    }

    List<OxfordNanoporeMeasurement> getMeasurements() {
        return this.measurements
    }

    @Override
    String getSampleId() {
        return this.sampleId
    }

    /**
     * Helper method that parses the QBiC identifier from the root folder name
     */
    private static String parseQbicIdFromRootFolder(Map nanoPoreSequencerOutput) {
        def name = Objects.requireNonNull(nanoPoreSequencerOutput.get("name"), "The root folder must contain a name property.")
        final def ids = SampleCodeFunctions.findAllQbicSampleIds(name)
        if (ids.isEmpty()) {
            throw new IllegalArgumentException("No QBiC sample identifier found!")
        }
        if (ids.size() > 1) {
            throw new IllegalArgumentException("Name contained more than valid sample id!")
        }
        return ids.get(0)
    }

    /**
     * Helper method that creates the measurements from the sequencer output
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

    /**
     * Helper method that creates a list of mixed DataFolders and DataFiles instances
     */
    private static List<?> parseMeasurementItems(List<Map> items) {
        final def children = []
        items.each { item ->
            def itemName = Objects.requireNonNull(item.get("name") as String, "A measurement child must contain a name.")
            try {
                def putativeFile = parseFile(item)
                children.add(putativeFile)
            } catch (IllegalArgumentException e) {
                def putativeFolder = parseFolder(item)
                children.add(putativeFolder)
            }
        }
        return children
    }

    private boolean isLogFile(String name) {

    }

    /**
     * Helper method that creates a DataFile instance from a map
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
            } catch (InvocationTargetException e) {
                // Do nothing
            }
        }
        throw new IllegalArgumentException("File $name with path $path is of unknown Oxford Nanopore file type.")
    }

    /**
     * Helper method that creates a DataFolder instance from a map
     */
    private static DataFolder parseFolder(Map fileTree) {
        def name = fileTree.get("name") as String
        def path = fileTree.get("path") as String
        def children = parseChildren(fileTree.get("children") as List)

        for (String nanoPoreFolderType : nanoporeFolderTypes) {
            Method method = determineMethod(Class.forName(nanoPoreFolderType))
            Optional<DataFolder> folder = tryToCreateDataFolder(method, name, path, children)
            if (folder.isPresent()) {
                return folder.get()
            }
        }
        throw new IllegalArgumentException("Folder $name with path $path is of unknown Oxford Nanopore folder type.")
    }

    private static Optional<DataFolder> tryToCreateDataFolder(Method method,
                                                              String name,
                                                              String relativePath,
                                                              List children) {
        Optional<DataFolder> folder = Optional.empty()
        try {
            // Try typed folder
            def dataFolder = method.invoke(null, relativePath, children) as DataFolder
            folder = Optional.of(dataFolder)
        } catch (InvocationTargetException e) {
            // Do nothing
        } catch (IllegalArgumentException e) {
            try {
                // Try named folder
                def dataFolder = method.invoke(null, name, relativePath, children) as DataFolder
                folder = Optional.of(dataFolder)
            } catch (InvocationTargetException e2) {
                // Do nothing
            }
        }
        return folder
    }

    private static List parseChildren(List<Map> children) {
        def parsedChildren = []
        children.each { Map unknownChild ->
            try {
                def child = parseFile(unknownChild)
                parsedChildren.add(child)
            } catch (IllegalArgumentException e) {
                // We do not capture the second parse call, as we want to fail the parsing at this point.
                // This means that we ultimately found an child of unknown type, which should
                // break the parsing.
                def child = parseFolder(unknownChild)
                parsedChildren.add(child)
            }
        }
        return parsedChildren
    }

    private static Method determineMethod(Class c) {
        def method
        try {
            method = c.getDeclaredMethod("create", String.class, String.class, List.class)
        } catch (NoSuchMethodException e) {
            method = c.getDeclaredMethod("create", String.class, List.class)
        }
        return method
    }
}
