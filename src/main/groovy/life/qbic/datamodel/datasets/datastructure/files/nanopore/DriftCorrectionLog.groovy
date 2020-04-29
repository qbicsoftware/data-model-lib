package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore Drift Correction file
 *
 * @author: Sven Fillinger
 */
class DriftCorrectionLog extends DataFile {

    final private static String FILE_TYPE = "csv"

    final private static String NAME_SCHEMA = $/drift_correction_.*/$

    protected DriftCorrectionLog() { }

    protected DriftCorrectionLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static DriftCorrectionLog create(String name, String relativePath) {
        return new DriftCorrectionLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore drift correction schema!")
        }
    }
}
