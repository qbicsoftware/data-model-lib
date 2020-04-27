package life.qbic.datamodel.datasets.datastructure.files

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore Drift Correction file
 *
 * @author: Sven Fillinger
 */
class DriftCorrectionLog extends DataFile {

    final private static String FILE_TYPE = "CSV"

    final private static String NAME_SCHEMA = $/drift_correction_.*/$

    protected DriftCorrectionLog() { }

    protected DriftCorrectionLog(String name, String path) {
        super(name, path, FILE_TYPE)
        validateName()
    }

    static DriftCorrectionLog create(String name, String path) {
        new DriftCorrectionLog(name, path)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore drift correction schema!")
        }
    }

}
