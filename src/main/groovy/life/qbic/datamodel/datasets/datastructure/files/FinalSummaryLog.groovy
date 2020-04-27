package life.qbic.datamodel.datasets.datastructure.files

/**
 A specialisation of a DataFile, represents an Oxford Nanopore duty time log file
 *
 * @author: Sven Fillinger
 */
class FinalSummaryLog extends DataFile {

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/final_summary_.*/$

    protected FinalSummaryLog() { }

    protected FinalSummaryLog(String name, String path) {
        super(name, path, FILE_TYPE)
        validateName()
    }

    static FinalSummaryLog create(String name, String path) {
        return FinalSummaryLog(name, path)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore summary schema!")
        }
    }

}
