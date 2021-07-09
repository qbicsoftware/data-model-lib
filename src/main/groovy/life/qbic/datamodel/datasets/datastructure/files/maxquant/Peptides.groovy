package life.qbic.datamodel.datasets.datastructure.files.maxquant

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an MaxQuant Peptides file
 *
 * @since 2.10.0
 *
 */
class Peptides extends DataFile{

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/peptides.*/$

    protected Peptides(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static Peptides create(String name, String relativePath) {
        return new Peptides(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the MaxQuant Peptides schema!")
        }
    }
}
