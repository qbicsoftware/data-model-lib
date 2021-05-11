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

    static SampleIds create(String name, String relativePath) {
        return new SampleIds(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the sampleIds schema!")
        }
    }

}
