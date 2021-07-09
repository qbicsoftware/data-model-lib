package life.qbic.datamodel.datasets.datastructure.files.maxquant

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an MaxQuant Parameters file
 *
 * @since 2.10.0
 *
 */
class Parameters extends DataFile{
    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/parameters.*/$

    protected Parameters(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static Parameters create(String name, String relativePath) {
        return new Parameters(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the MaxQuant Parameters schema!")
        }
    }
}
