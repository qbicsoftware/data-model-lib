package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 *  A specialisation of a DataFile, represents an Oxford Nanopore report PDF log file
 *
 * @author: Sven Fillinger
 */
class ReportHTMLLog extends DataFile {

    final private static String FILE_TYPE = "html"

    final private static String NAME_SCHEMA = $/report_.*/$

    protected ReportHTMLLog() {}

    protected ReportHTMLLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static ReportHTMLLog create(String name, String relativePath) {
        return new ReportHTMLLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore report name schema!")
        }
    }
}
