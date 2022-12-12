package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 *  A specialisation of a DataFile, represents an Oxford Nanopore sequencing telemetry log file
 *
 */
class SequencingTelemetryLog extends DataFile {

    final private static String FILE_TYPE = "js"

    final private static String NAME_SCHEMA = $/sequencing_telemetry_.*/$

    protected SequencingTelemetryLog() {}

    protected SequencingTelemetryLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static SequencingTelemetryLog create(String name, String relativePath) {
        return new SequencingTelemetryLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore sequencing telemetry log name schema!")
        }
    }

}
