package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 *  A specialisation of a DataFile, represents an Oxford Nanopore report JSON log file
 *
 */
class ReportJSONLog extends DataFile {

    final private static String FILE_TYPE = "json"

    final private static String NAME_SCHEMA = $/report_.*/$

    protected ReportJSONLog() {}

    protected ReportJSONLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static ReportJSONLog create(String name, String relativePath) {
        return new ReportJSONLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore report name schema!")
        }
    }
}
