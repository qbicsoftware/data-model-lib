package life.qbic.datamodel.datasets.datastructure.files

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class SequencingSummaryLog extends DataFile {

    final private static String FILE_TYPE = "pdf"

    final private static String NAME_SCHEMA = $/report.*/$

    protected SequencingSummaryLog() { }

    protected SequencingSummaryLog(String name, String path) {
        super(name, path, FILE_TYPE)
        validateName()
    }

    static SequencingSummaryLog create(String name, String path) {
        return SequencingSummaryLog(name, path)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore report name schema!")
        }
    }

}
