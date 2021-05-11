package life.qbic.datamodel.datasets.datastructure.files.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents a nf-core Pipeline execution report file
 *
 * @since 2.6.0
 */
class ExecutionReport extends DataFile {

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/execution_report.*/$

    protected ExecutionReport() {}

    protected ExecutionReport(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static ExecutionReport create(String name, String relativePath) {
        return new ExecutionReport(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the nf-core pipeline execution report schema!")
        }
    }

}
