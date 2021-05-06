package life.qbic.datamodel.datasets.datastructure.files.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 A specialisation of a DataFile, represents a nf-core RunId file
 *
 * @since 2.5.0
 */
class RunId extends DataFile {

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/run_id_.*/$

    protected RunId() {}

    protected RunId(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static RunId create(String name, String relativePath) {
        return new RunId(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the runId schema!")
        }
    }

}
