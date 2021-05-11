package life.qbic.datamodel.datasets.datastructure.files.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents a nf-core Pipeline report file
 *
 * @since 2.6.0
 */
class PipelineReport extends DataFile {

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/pipeline_report.*/$

    protected PipelineReport() {}

    protected PipelineReport(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    /**
     * Creates the PipelineReport object based on a report name and a relative path of it
     * @param name The file name of the pipeline report
     * @param relativePath The relative path to the file in a file system
     * @return the PipelineReport object, which also validates if the the filename is valid
     */
    static PipelineReport create(String name, String relativePath) {
        return new PipelineReport(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the nf-core pipeline report schema!")
        }
    }

}
