package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class FastQFile extends DataFile {

    final private static String FILE_TYPE = "fastq"

    final private static String NAME_SCHEMA = /.*\.fastq$/

    protected FastQFile(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static FastQFile create(String name, String relativePath) {
        return new FastQFile(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore summary schema!")
        }
    }
}
