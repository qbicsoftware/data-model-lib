package life.qbic.datamodel.datasets.datastructure.files.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents a nf-core SoftwareVersions file
 *
 * @since 2.6.0
 */
class SoftwareVersions extends DataFile {

    final private static String FILE_TYPE = "yml"

    final private static String NAME_SCHEMA = $/software_versions.*/$

    protected SoftwareVersions() {}

    protected SoftwareVersions(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    /**
     * Creates the SoftwareVersions object based on a file name and a relative path of it
     * @param name The file name of the SoftwareVersions
     * @param relativePath The relative path to the file in a file system
     * @return the SoftwareVersions object, which also validates if the filename is valid
     * @since 2.6.0
     */
    static SoftwareVersions create(String name, String relativePath) {
        return new SoftwareVersions(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the nf-core software versions name schema!")
        }
    }

}
