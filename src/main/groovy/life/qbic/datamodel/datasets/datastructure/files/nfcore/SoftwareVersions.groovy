package life.qbic.datamodel.datasets.datastructure.files.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents a nf-core SoftwareVersions file
 *
 * @since 2.6.0
 */
class SoftwareVersions extends DataFile {

    final private static String FILE_TYPE = "csv"

    final private static String NAME_SCHEMA = $/software_versions.*/$

    protected SoftwareVersions() {}

    protected SoftwareVersions(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static SoftwareVersions create(String name, String relativePath) {
        return new SoftwareVersions(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the nf-core software versions name schema!")
        }
    }

}
