package life.qbic.datamodel.datasets.datastructure.files.maxquant

import life.qbic.datamodel.datasets.datastructure.files.DataFile


/**
 * A specialisation of a DataFile, represents an MaxQuant Summary file
 *
 * @since 2.10.0
 *
 */
class Summary extends DataFile{

    final private static String FILE_TYPE = "pdf"

    final private static String NAME_SCHEMA = $/summary_[0-9]{4}.*/$

    protected Summary(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static Summary create(String name, String relativePath) {
        return new Summary(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the MaxQuant summary schema!")
        }
    }
}