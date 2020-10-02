package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore report markdown data log file
 *
 * @author: Sven Fillinger
 */
class ReportMdLog extends DataFile {

    final private static String FILE_TYPE = "md"

    final private static String NAME_SCHEMA = $/report_.*/$

    protected ReportMdLog() {}

    protected ReportMdLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static ReportMdLog create(String name, String relativePath) {
        return new ReportMdLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore report schema!")
        }
    }
}
