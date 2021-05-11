package life.qbic.datamodel.datasets.datastructure.files.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents a nf-core RunId file
 *
 * @since 2.6.0
 */
class RunId extends DataFile {

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/run_id.*/$

    protected RunId() {}

    protected RunId(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    /**
     * Creates the RunId object based on a RunId name and a relative path of it
     * @param name The file name of the RunId
     * @param relativePath The relative path to the file in a file system
     * @return the RunId object, which also validates if the filename is valid
     * @since 2.6.0
     */
    static RunId create(String name, String relativePath) {
        return new RunId(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the runId schema!")
        }
    }

}
