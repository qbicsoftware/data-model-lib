package life.qbic.datamodel.datasets.datastructure.files.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 A specialisation of a DataFile, represents a nf-core InputIds file
 *
 * @since 2.5.0
 */
class InputIds extends DataFile {

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/input_ids_.*/$

    protected InputIds() {}

    protected InputIds(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static InputIds create(String name, String relativePath) {
        return new InputIds(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the InputId schema!")
        }
    }

}
