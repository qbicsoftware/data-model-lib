package life.qbic.datamodel.datasets.datastructure.folders.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.files.nfcore.ExecutionReport
import life.qbic.datamodel.datasets.datastructure.files.nfcore.SoftwareVersions
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name is always pipeline_info.
 *
 * Its children field contains a list of type List<DataFile>
 *
 * @since 2.6.0
 */
class PipelineInformationFolder extends DataFolder {

    private final static String NAME_SCHEMA = /pipeline_info/

    SoftwareVersions softwareVersions

    ExecutionReport executionReport

    protected PipelineInformationFolder() {}

    protected PipelineInformationFolder(String name, String relativePath, List<DataFile> children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a PipelineInformationFolder object
     *
     * @param name The folder name
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a PipelineInformationFolder object
     * @since 2.6.0
     */
    static PipelineInformationFolder create(String name, String relativePath, List<DataFile> children) {
        new PipelineInformationFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the nf-core PipelineInformation directory schema!")
        }
    }

    /**
     * Provides access to the information stored in the process folders
     * @return the software versions stored in the process folder
     * @since 2.6.0
     */
    SoftwareVersions getSoftwareVersions() {
        return softwareVersions
    }

    /**
     * Provides access to the information stored in the sampleIds file
     * @return the execution report
     * @since 2.6.0
     */
    ExecutionReport getExecutionReport() {
        return executionReport
    }
}
