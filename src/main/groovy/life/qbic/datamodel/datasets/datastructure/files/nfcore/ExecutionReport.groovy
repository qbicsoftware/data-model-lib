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

    /**
     * Creates the ExecutionReport object based on a report name and a relative path of it
     * @param name The file name of the execution report
     * @param relativePath The relative path to the file in a file system
     * @return the ExecutionReport object, which also validates if the filename is valid
     * @since 2.6.0
     */
    static ExecutionReport create(String name, String relativePath) {
        return new ExecutionReport(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the nf-core pipeline execution report schema!")
        }
    }

}
