package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 *  A specialisation of a DataFile, represents an Oxford Nanopore sample sheet log file
 *
 * @author: Andreas Friedrich
 */
class SampleSheetLog extends DataFile {

    final private static String FILE_TYPE = "csv"

    final private static String NAME_SCHEMA = $/sample_sheet_.*/$

    protected SampleSheetLog() {}

    protected SampleSheetLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static SampleSheetLog create(String name, String relativePath) {
        return new SampleSheetLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore sample sheet log name schema!")
        }
    }

}
