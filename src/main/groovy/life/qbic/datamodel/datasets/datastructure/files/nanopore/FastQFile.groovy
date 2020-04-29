package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class FastQFile extends DataFile {

    final private static String FILE_TYPE = "fast5"

    final private static String NAME_SCHEMA = /.*\.fastq$|.*\.fastq\.gz$/

    protected FastQFile(String name, String relativePath, String fileType) {
        super(name, relativePath, fileType)
        validateName()
    }

    static FastQFile create(String name, String relativePath) {
        return new FastQFile(name, relativePath, FILE_TYPE)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore summary schema!")
        }
    }
}
