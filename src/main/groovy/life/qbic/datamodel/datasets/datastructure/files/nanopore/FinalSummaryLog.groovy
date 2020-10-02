package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 A specialisation of a DataFile, represents an Oxford Nanopore duty time log file
 *
 * @author: Sven Fillinger
 */
class FinalSummaryLog extends DataFile {

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/final_summary_.*/$

    protected FinalSummaryLog() {}

    protected FinalSummaryLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static FinalSummaryLog create(String name, String relativePath) {
        return new FinalSummaryLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore summary schema!")
        }
    }

}
