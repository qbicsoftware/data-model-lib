package life.qbic.datamodel.datasets

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.files.nanopore.OptionalFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.OptionalFolder
import life.qbic.datamodel.identifiers.SampleCodeFunctions

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Class that holds information about an Oxford Nanopore Experiment.
 *
 * @author: Sven Fillinger
 */
final class OxfordNanoporeExperiment implements ExperimentFolder {

  private final List<OxfordNanoporeMeasurement> measurements

  private final String sampleId

  private OxfordNanoporeExperiment(String sampleId, List<OxfordNanoporeMeasurement> measurements) {
    this.measurements = Objects.requireNonNull(measurements, "measurements must not be null")
    this.sampleId = Objects.requireNonNull(sampleId, "sampleId must not be null")
  }

  /**
   * Static factory method that creates a new instance from a Oxford Nanopore sequencer output.
   *
   * @param Map nanoPoreSequencerOutput
   * @return OxfordNanoporeExperiment A new instance of a nanopore experiment.
   */
  static OxfordNanoporeExperiment create(Map nanoPoreSequencerOutput) {
    final String sampleId = parseQbicIdFromRootFolder(nanoPoreSequencerOutput)
    final List<OxfordNanoporeMeasurement> measurements = parseMeasurements(nanoPoreSequencerOutput)
    return new OxfordNanoporeExperiment(sampleId, measurements)
  }

  /**
   * Provides a list of measurements contained within the experiment folder.
   * @return
   */
  List<OxfordNanoporeMeasurement> getMeasurements() {
    return this.measurements
  }

  @Override
  String getSampleCode() {
    return this.sampleId
  }

  /**
   * Helper method that parses the QBiC identifier from the root folder name*/
  private static String parseQbicIdFromRootFolder(Map nanoPoreSequencerOutput) {
    def name = Objects.requireNonNull(nanoPoreSequencerOutput.get("name"), "The root folder must contain a name property.")
    final def ids = SampleCodeFunctions.findAllQbicSampleCodes(name as String)
    if (ids.isEmpty()) {
      throw new IllegalArgumentException("No QBiC sample identifier found!")
    }
    if (ids.size() > 1) {
      throw new IllegalArgumentException("Name contained more than one valid sample id!")
    }
    return ids.get(0)
  }

  /**
   * Helper method that creates the measurements from the sequencer output*/
  private static List<OxfordNanoporeMeasurement> parseMeasurements(Map nanoPoreSequencerOutput) {
    final def measurements = []
    Objects.requireNonNull(nanoPoreSequencerOutput.get("children"), "The root folder must contain at least one measurement folder.")
    nanoPoreSequencerOutput.get("children").each { Map measurementItem ->
      def name = measurementItem.get("name") as String
      def relativePath = measurementItem.get("path") as String
      def children = parseMeasurementItems(measurementItem.get("children") as List)
      def metadata = measurementItem.get("metadata") as Map
      measurements.add(new OxfordNanoporeMeasurement(name, relativePath, children, metadata))
    }
    return measurements
  }

  /*
   * Helper method that creates a list of mixed DataFolders and DataFiles instances
   */

  private static List<?> parseMeasurementItems(List<Map> items) {
    final def children = []
    items.each { item ->
      {
        if (!item.isEmpty()) {
          if (isFile(item)) {
            // Lets try to parse it as a subclass of a DataFile
            DataFile putativeFile = parseFile(item)
            children.add(putativeFile)
          }
          if (isFolder(item)) {
            // Lets try to parse it as a subclass of a DataFile
            DataFolder putativeFolder = parseFolder(item)
            children.add(putativeFolder)
          }
        }
      }
    }
    return children
  }

  /*
   * Helper method that creates a DataFile instance from a map
   */

  private static DataFile parseFile(Map fileTree) throws IllegalArgumentException {
    String name = fileTree.get("name")
    String path = fileTree.get("path")
    for (String nanoPoreFileType : NanoporeFileTypes.values()) {
      Class<?> c = Class.forName(nanoPoreFileType)
      Method method = c.getDeclaredMethod("create", String.class, String.class)
      try {
        DataFile dataFile = method.invoke(null, name, path) as DataFile
        return dataFile
      } catch (InvocationTargetException e) {
        // Do nothing as we need to try out all specialisations that extend the
        // DataFile class
      }
    }
    try {
      String fileSuffix = fileTree.get("file_type")
      // Since the file structure is highly variable we want to allow for unknown files to be included in the experiment
      OptionalFile optionalFile = OptionalFile.create(name, path, fileSuffix)
      return optionalFile
    } catch (Exception ignored) {
      throw new IllegalArgumentException("File $name with path $path is not a valid Data File")
    }
  }

  /*
   * Helper method that creates a DataFolder instance from a map
   */

  private static DataFolder parseFolder(Map fileTree) throws IllegalArgumentException {
    String name = fileTree.get("name") as String
    String path = fileTree.get("path") as String
    def children = parseChildren(fileTree.get("children") as List)

    for (String nanoPoreFolderType : NanoporeFolderTypes.values()) {
      Method method = determineMethod(Class.forName(nanoPoreFolderType))
      Optional<DataFolder> folder = tryToCreateDataFolder(method, name, path, children)
      if (folder.isPresent()) {
        return folder.get()
      }
    }
    // Since the file structure is highly variable we want to allow for unknown folders to be included in the experiment
    try {
      OptionalFolder optionalFolder = OptionalFolder.create(name, path, children)
      return optionalFolder
    } catch (Exception ignored) {
      throw new IllegalArgumentException("Folder $name with path $path is not a valid Data Folder")
    }
  }

  /*
   * Helper method that tries to create a DataFolder instance
   * based on the DataFolder's different static factory create methods.
   * As we do not know, whether a folder element is another typed folder
   * such as FastQPassFolder or a named folder such as Fast5Folder, we have to
   * try and fail.
   */

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

  /*
   * Helper method that parses the children of a folder.
   */

  private static List parseChildren(List<Map> children) {
    def parsedChildren = []
    children.forEach({ Map unknownChild ->
      if (!unknownChild.isEmpty()) {
        if (isFile(unknownChild)) {
          def child = parseFile(unknownChild)
          parsedChildren.add(child)
        }
        if (isFolder(unknownChild)) {
          def child = parseFolder(unknownChild)
          parsedChildren.add(child)
        }
      }
    })
    return parsedChildren
  }

  /*
  Determines the correct static create method for a data folder.
   */

  private static Method determineMethod(Class c) {
    def method
    try {
      // named folder (i.e. Fast5Folder)
      method = c.getDeclaredMethod("create", String.class, String.class, List.class)
    } catch (NoSuchMethodException e) {
      // typed folder (i.e. FastQPassFolder)
      method = c.getDeclaredMethod("create", String.class, List.class)
    }
    return method
  }

  private static boolean isFile(Map parsedChild) {
    //Unique key in fileTreeMap identifying a child as a file
    final String file_key = "file_type"
    return parsedChild.containsKey(file_key)
  }

  private static boolean isFolder(Map parsedChild) {
    //Unique key in fileTreeMap identifyng a child as a folder
    final String folder_key = "children"
    return parsedChild.containsKey(folder_key)
  }

  private enum NanoporeFileTypes {

    DRIFT_CORRECTION_LOG(FQDN_FILES + ".DriftCorrectionLog"),
    DUTY_TIME_LOG(FQDN_FILES + ".DutyTimeLog"),
    FAST5_FILE(FQDN_FILES + ".Fast5File"),
    FASTQ_FILE(FQDN_FILES + ".FastQFile"),
    FASTQ_ZIPPED_FILE(FQDN_FILES + ".FastQZippedFile"),
    BAM_FILE(FQDN_FILES + ".BamFile"),
    POD5_FILE(FQDN_FILES + ".Pod5File"),
    FINAL_SUMMARY_LOG(FQDN_FILES + ".FinalSummaryLog"),
    MUX_SCAN_DATA_LOG(FQDN_FILES + ".MuxScanDataLog"),
    REPORT_MD_LOG(FQDN_FILES + ".ReportMdLog"),
    REPORT_PDF_LOG(FQDN_FILES + ".ReportPDFLog"),
    REPORT_HTML_LOG(FQDN_FILES + ".ReportHTMLLog"),
    REPORT_JSON_LOG(FQDN_FILES + ".ReportJSONLog"),
    SEQUENCING_SUMMARY_LOG(FQDN_FILES + ".SequencingSummaryLog"),
    THROUGHPUT_LOG(FQDN_FILES + ".ThroughputLog"),
    BARCODE_ALIGNMENT_LOG(FQDN_FILES + ".BarcodeAlignmentLog"),
    PORE_ACTIVITY_LOG(FQDN_FILES + ".PoreActivityLog"),
    SAMPLE_SHEET_LOG(FQDN_FILES + ".SampleSheetLog"),
    PORE_SCAN_DATA_LOG(FQDN_FILES + ".PoreScanDataLog"),
    SEQUENCING_TELEMETRY_LOG(FQDN_FILES + ".SequencingTelemetryLog"),
    GUPPY_BASECALL_LOG(FQDN_FILES + ".GuppyBasecallLog")

    /**
     Holds the String value of the enum
     */
    private final String value

    // Fully qualified domain name of the nanopore file structure package
    private static final String FQDN_FILES = "life.qbic.datamodel.datasets.datastructure.files.nanopore"

    /**
     * Private constructor to create different NanoporeFileTypes enum items
     * @param value
     */
    private NanoporeFileTypes(String value) {
      this.value = value
    }

    /**
     * Returns to the enum item value
     * @return
     */
    String getValue() {
      return value
    }

    /**
     * Returns a String representation of the enum item
     * @return
     */
    @Override
    String toString() {
      return this.getValue()
    }
  }

  private enum NanoporeFolderTypes {

    FAST5_FOLDER(FQDN_FOLDERS + ".Fast5Folder"),
    FASTQ_FOLDER(FQDN_FOLDERS + ".FastQFolder"),
    FAST5_PASS_FOLDER(FQDN_FOLDERS + ".Fast5PassFolder"),
    FAST5_FAIL_FOLDER(FQDN_FOLDERS + ".Fast5FailFolder"),
    FAST5_SKIP_FOLDER(FQDN_FOLDERS + ".Fast5SkipFolder"),
    FASTQ_PASS_FOLDER(FQDN_FOLDERS + ".FastQPassFolder"),
    FASTQ_FAIL_FOLDER(FQDN_FOLDERS + ".FastQFailFolder"),
    UNCLASSIFIED_FAST5_FOLDER(FQDN_FOLDERS + ".UnclassifiedFast5Folder"),
    UNCLASSIFIED_FASTQ_FOLDER(FQDN_FOLDERS + ".UnclassifiedFastQFolder"),
    POD5_PASS_FOLDER(FQDN_FOLDERS + ".Pod5PassFolder"),
    POD5_FAIL_FOLDER(FQDN_FOLDERS + ".Pod5FailFolder"),
    POD5_SKIP_FOLDER(FQDN_FOLDERS + ".Pod5SkipFolder"),
    BAM_PASS_FOLDER(FQDN_FOLDERS + ".BamPassFolder"),
    BAM_FAIL_FOLDER(FQDN_FOLDERS + ".BamFailFolder"),
    OTHER_REPORTS_FOLDER(FQDN_FOLDERS + ".OtherReportsFolder"),
    BASECALLING_FOLDER(FQDN_FOLDERS + ".BasecallingFolder"),

    // Fully qualified domain name of the nanopore folder structure package
    private static final String FQDN_FOLDERS = "life.qbic.datamodel.datasets.datastructure.folders.nanopore"

    /**
     Holds the String value of the enum
     */
    private final String value

    /**
     * Private constructor to create different NanoporeFolderTypes enum items
     * @param value
     */
    private NanoporeFolderTypes(String value) {
      this.value = value
    }

    /**
     * Returns to the enum item value
     * @return
     */
    String getValue() {
      return value
    }

    /**
     * Returns a String representation of the enum item
     * @return
     */
    @Override
    String toString() {
      return this.getValue()
    }
  }
}
