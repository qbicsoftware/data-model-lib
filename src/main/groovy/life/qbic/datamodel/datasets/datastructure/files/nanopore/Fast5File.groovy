package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore fast5 file
 *
 * @author: Sven Fillinger
 */
class Fast5File extends DataFile {

    final private static String FILE_TYPE = "fast5"

    final private static String NAME_SCHEMA = /.*\.fast5$/

    protected Fast5File(String name, String relativePath, String fileType) {
        super(name, relativePath, fileType)
        validateName()
    }

    static Fast5File create(String name, String relativePath) {
        return new Fast5File(name, relativePath, FILE_TYPE)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore summary schema!")
        }
    }

}
