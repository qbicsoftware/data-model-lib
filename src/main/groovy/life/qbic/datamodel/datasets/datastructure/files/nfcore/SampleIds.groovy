package life.qbic.datamodel.datasets.datastructure.files.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents a nf-core InputIds file
 *
 * @since 2.6.0
 */
class SampleIds extends DataFile {

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/sample_ids.*/$

    protected SampleIds() {}

    protected SampleIds(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    /**
     * Creates the SampleIds object based on a report name and a relative path of it
     * @param name The file name of the SampleIds
     * @param relativePath The relative path to the file in a file system
     * @return the SampleIds object, which also validates if the the filename is valid
     */
    static SampleIds create(String name, String relativePath) {
        return new SampleIds(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the sampleIds schema!")
        }
    }

}
