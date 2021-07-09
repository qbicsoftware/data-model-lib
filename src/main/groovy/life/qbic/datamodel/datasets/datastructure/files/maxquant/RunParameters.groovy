package life.qbic.datamodel.datasets.datastructure.files.maxquant

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an MaxQuant Run Parameters file
 *
 * @since 2.10.0
 *
 */
class RunParameters extends DataFile{
    final private static String FILE_TYPE = "xml"

    final private static String NAME_SCHEMA = $/mqpar.*/$

    protected RunParameters(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static RunParameters create(String name, String relativePath) {
        return new RunParameters(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the MaxQuant runParameters schema!")
        }
    }
}
