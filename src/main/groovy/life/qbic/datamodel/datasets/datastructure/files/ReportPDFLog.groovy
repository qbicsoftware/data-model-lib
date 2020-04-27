package life.qbic.datamodel.datasets.datastructure.files

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class ReportPDFLog extends DataFile {

    final private static String FILE_TYPE = "pdf"

    final private static String NAME_SCHEMA = $/report.*/$

    protected ReportPDFLog() { }

    protected ReportPDFLog(String name, String path) {
        super(name, path, FILE_TYPE)
        validateName()
    }

    static ReportPDFLog create(String name, String path) {
        return ReportPDFLog(name, path)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore report name schema!")
        }
    }
}
