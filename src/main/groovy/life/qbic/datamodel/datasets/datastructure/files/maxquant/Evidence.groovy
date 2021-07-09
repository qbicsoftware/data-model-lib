package life.qbic.datamodel.datasets.datastructure.files.maxquant

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an MaxQuant Evidence file
 *
 * @since 2.10.0
 *
 */
class Evidence extends DataFile{
    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/evidence.*/$

    protected Evidence(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    /**
     * Creates the Evidence object based on a file name and a relative path of it
     * @param name The file name of the Evidence file
     * @param relativePath The relative path to the file in a file system
     * @return the Evidence object, which also validates if the filename is valid
     * @since 2.10.0
     */
    static Evidence create(String name, String relativePath) {
        return new Evidence(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the MaxQuant summary schema!")
        }
    }
}