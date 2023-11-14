package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore pod5 file
 *
 */
class Pod5File extends DataFile {

    final private static String FILE_TYPE = "pod5"

    final private static String NAME_SCHEMA = /.*\.pod5$/

    protected Pod5File(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static Pod5File create(String name, String relativePath) {
        return new Pod5File(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore summary schema!")
        }
    }

}
