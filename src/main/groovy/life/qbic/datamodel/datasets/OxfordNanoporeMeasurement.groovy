package life.qbic.datamodel.datasets

import groovyjarjarcommonscli.MissingArgumentException
import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.datasets.datastructure.folders.nanopore.*
import org.everit.json.schema.ValidationException

import java.util.regex.Matcher
import java.util.regex.Pattern

import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener

/**
 * A dataset that represents a Oxford Nanopore Measurement.
 *
 * @author: Sven Fillinger
 */
final class OxfordNanoporeMeasurement {

    private static final String LIBRARY_PREP_KIT_SCHEMA = "SQK-.*(?=:)"

    private static final enum METADATA_FIELD {
        ADAPTER,
        ASIC_TEMP,
        BASE_CALLER,
        BASE_CALLER_VERSION,
        DEVICE_TYPE,
        FLOWCELL_ID,
        FLOWCELL_POSITION,
        FLOWCELL_TYPE,
        LIBRARY_PREPARATION_KIT,
        MACHINE_HOST,
        START_DATE
    }

    private final Map<METADATA_FIELD, String> metadata

    private final Map<String, DataFolder> folders

    private final List<DataFile> logFilesCollection

    private final MeasurementFolder measurementFolder

    private boolean pooledSamplesMeasurement

    protected OxfordNanoporeMeasurement(String name, String path, List children, Map metadata) {
        this.logFilesCollection = new ArrayList<>()
        this.folders = new HashMap<>()
        this.metadata = new HashMap()

        this.measurementFolder = MeasurementFolder.create(name, path, children)

        validateMetaData(metadata)
        readMetaData(metadata)
        createContent()
        assessPooledStatus()
    }

    private List<DataFile> getLogFileCollection() {
        return logFilesCollection
    }

    static OxfordNanoporeMeasurement create(String name, String path, List children, Map metadata) {
        return new OxfordNanoporeMeasurement(name, path, children, metadata)
    }

    private static void validateMetaData(Map metadata) throws IllegalArgumentException {
        try {
            MetaData.validateMetadata(metadata)
        } catch (ValidationException e) {
            // Aggregate the causing exceptions
            def causes = e.getCausingExceptions().collect{ it.message  }.join("\n")
            throw new IllegalArgumentException("The Nanopore metadata could not be collected.\nReason:\n$causes",)
        }
    }

    private void assessPooledStatus() {
        this.pooledSamplesMeasurement = folders["fast5pass"] ? folders["fast5pass"].getChildren().get(0) instanceof Fast5Folder : false
        // There can be still pooled samples in the failed folder, worst case is all
        // samples failed, so we need to check there to
        if (! pooledSamplesMeasurement) {
            this.pooledSamplesMeasurement = folders["fast5fail"] ? folders["fast5fail"].getChildren().get(0) instanceof Fast5Folder : false
        }
    }

    private void readMetaData(Map<String, String> metadata) {
        this.metadata[METADATA_FIELD.ADAPTER] = metadata["adapter"]
        this.metadata[METADATA_FIELD.ASIC_TEMP] = metadata["asic_temp"]
        this.metadata[METADATA_FIELD.BASE_CALLER] = metadata["base_caller"]
        this.metadata[METADATA_FIELD.BASE_CALLER_VERSION] = metadata["base_caller_version"]
        this.metadata[METADATA_FIELD.DEVICE_TYPE] = metadata["device_type"]
        this.metadata[METADATA_FIELD.FLOWCELL_ID] = metadata["flow_cell_id"]
        this.metadata[METADATA_FIELD.FLOWCELL_POSITION] = metadata["flow_cell_position"]
        this.metadata[METADATA_FIELD.FLOWCELL_TYPE] = metadata["flow_cell_product_code"]
        this.metadata[METADATA_FIELD.LIBRARY_PREPARATION_KIT] = extractLibraryKit(metadata["protocol"] ?: "")
        this.metadata[METADATA_FIELD.MACHINE_HOST] = metadata["hostname"]
        this.metadata[METADATA_FIELD.START_DATE] = metadata["started"]
    }

    private static String extractLibraryKit(String text) {
        Set<String> result = []
        Pattern pattern = Pattern.compile(LIBRARY_PREP_KIT_SCHEMA, Pattern.CASE_INSENSITIVE)
        Matcher m = pattern.matcher(text)
        while (m.find()) {
            result.add(m.group())
        }
        if (result.isEmpty()) {
            throw new MissingArgumentException("Could not find information about the library preparation kit.")
        }
        return result[0]
    }

    private void createContent() {
        measurementFolder.getChildren().each { element ->
            switch (element) {
                case Fast5PassFolder:
                    folders["fast5pass"] = element as Fast5PassFolder
                    break
                case Fast5FailFolder:
                    folders["fast5fail"] = element as Fast5FailFolder
                    break
                case FastQPassFolder:
                    folders["fastqpass"] = element as FastQPassFolder
                    break
                case FastQFailFolder:
                    folders["fastqfail"] = element as FastQFailFolder
                    break
                case DataFile:
                    logFilesCollection.add(element as DataFile)
                    break
            }
        }
    }

    /**
     * This method aggregates all fast5 files and fastq files of an Oxford Nanopore
     * measurement by sample code. The DataFolder objects will not contain unclassified
     * read information.
     *
     * The resulting data-structure follows this map schema:
     *
     * "QBiC sample code":
     *      "fast5fail": DataFolder
     *      "fast5pass": DataFolder
     *      "fastqfail": DataFolder
     *      "fastqpass": DataFolder
     * "Other sample code":   // In case of pooled samples
     *      ...
     * @return nested Map with sample codes and data folders
     */
    Map<String, Map<String, DataFolder>> getRawDataPerSample(ExperimentFolder experiment) {
        if (pooledSamplesMeasurement) {
            return prepareRawDataFromPooledMeasurement()
        } else {
            return prepareRawData(experiment.sampleCode)
        }
    }

    /**
     * This method aggregates only *unclassified* fast5 files and fastq files of an Oxford Nanopore
     * measurement.
     *
     * The resulting data-structure follows this map schema:
     *
     *   "fast5fail": DataFolder
     *   "fast5pass": DataFolder
     *   "fastqfail": DataFolder
     *   "fastqpass": DataFolder
     *
     * @return Map with sample codes and data folders
     */
    Map<String, DataFolder> getUnclassifiedData() {
        return prepareUnclassifiedData()
    }

    /**
     * Provides access to the asic temperature.
     * @return
     */
    String getAsicTemp() {
        return metadata.get(METADATA_FIELD.ASIC_TEMP)
    }

    /**
     * Provides access to the device type.
     * @return
     */
    String getDeviceType() {
        return metadata.get(METADATA_FIELD.DEVICE_TYPE)
    }

    /**
     * Provides access to the flow cell id.
     * @return
     */
    String getFlowcellId() {
        return metadata.get(METADATA_FIELD.FLOWCELL_ID)
    }

    /**
     * Provides access to the flow cell position.
     * @return
     */
    String getFlowCellPosition() {
        return metadata.get(METADATA_FIELD.FLOWCELL_POSITION)
    }

    /**
     * Provides access to the flow cell type.
     * @return
     */
    String getFlowCellType() {
        return metadata.get(METADATA_FIELD.FLOWCELL_TYPE)
    }

    /**
     * Provides access to the base caller.
     * @return
     */
    String getBaseCaller() {
        return metadata.get(METADATA_FIELD.BASE_CALLER)
    }

    /**
     * Provides access to the base caller version.
     * @return
     */
    String getBaseCallerVersion() {
        return metadata.get(METADATA_FIELD.BASE_CALLER_VERSION)
    }

    /**
     * Provides access to the library kit used.
     * @return
     */
    String getLibraryPreparationKit() {
        return metadata.get(METADATA_FIELD.LIBRARY_PREPARATION_KIT)
    }

    /**
     * Provides access to the machine host name.
     * @return
     */
    String getMachineHost() {
        return metadata.get(METADATA_FIELD.MACHINE_HOST)
    }

    /**
     * Provides access to the experiment start date.
     * @return
     */
    String getStartDate() {
        return metadata.get(METADATA_FIELD.START_DATE)
    }

    private Map<String, DataFolder> prepareUnclassifiedData() {
        final def folders = [
                "fast5fail": (folders.get("fast5fail") as DataFolder).getChildren().find { it instanceof UnclassifiedFast5Folder } as DataFolder,
                "fast5pass": (folders.get("fast5pass") as DataFolder).getChildren().find { it instanceof UnclassifiedFast5Folder } as DataFolder,
                "fastqpass": (folders.get("fastqpass") as DataFolder).getChildren().find { it instanceof UnclassifiedFastQFolder } as DataFolder,
                "fastqfail": (folders.get("fastqfail") as DataFolder).getChildren().find { it instanceof UnclassifiedFastQFolder } as DataFolder,
        ]
        return folders
    }

    private Map<String, Map<String, DataFolder>> prepareRawDataFromPooledMeasurement() {
        final def result = new HashMap()
        final def pooledSampleCodes = folders
                .get("fast5fail")
                .getChildren()
                .collect { (it as BarcodedFolder).getSampleCode() }
        pooledSampleCodes.each { sampleId ->
            final def map = [
                    "fast5fail": (folders.get("fast5fail") as DataFolder).getChildren().find { (it as BarcodedFolder).getSampleCode() == sampleId },
                    "fast5pass": (folders.get("fast5pass") as DataFolder).getChildren().find { (it as BarcodedFolder).getSampleCode() == sampleId },
                    "fastqpass": (folders.get("fastqpass") as DataFolder).getChildren().find { (it as BarcodedFolder).getSampleCode() == sampleId },
                    "fastqfail": (folders.get("fastqfail") as DataFolder).getChildren().find { (it as BarcodedFolder).getSampleCode() == sampleId }
            ]
            result[sampleId] = map
        }
        return result
    }

    private Map<String, Map<String, DataFolder>> prepareRawData(String sampleId) {
        final def result = new HashMap()
        final def folders = [
                "fast5fail": (folders.get("fast5fail") as DataFolder),
                "fast5pass": (folders.get("fast5pass") as DataFolder),
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
        return logFilesCollection.collect()
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
        return this.measurementFolder.relativePath
    }

    /*
    Inner class that contains the logic for the metadata validation
     */
    private static class MetaData {

        private static final SCHEMA = "/schemas/ont-metadata.schema.json"

        static validateMetadata(Map metaData) throws ValidationException {
            // Load schema
            final def metaDataJson = new JSONObject(metaData)
            final def schemaStream = OxfordNanoporeMeasurement.getResourceAsStream(SCHEMA)
            final def rawSchema = new JSONObject(new JSONTokener(schemaStream))
            final def jsonSchema = SchemaLoader.load(rawSchema)
            // Validate against schema
            jsonSchema.validate(metaDataJson)
        }

    }


}
