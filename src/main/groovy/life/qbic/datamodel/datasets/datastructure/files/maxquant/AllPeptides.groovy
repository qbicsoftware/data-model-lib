package life.qbic.datamodel.datasets.datastructure.files.maxquant

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an MaxQuant AllPeptides file
 *
 * @since 2.10.0
 *
*/
class AllPeptides extends DataFile{
    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/allPeptides.*/$

    protected AllPeptides(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    /**
     * Creates the AllPeptides object based on a file name and a relative path of it
     * @param name The file name of the all peptides file
     * @param relativePath The relative path to the file in a file system
     * @return the AllPeptides object, which also validates if the filename is valid
     * @since 2.10.0
     */
    static AllPeptides create(String name, String relativePath) {
        return new AllPeptides(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the MaxQuant AllPeptides schema!")
        }
    }
}
