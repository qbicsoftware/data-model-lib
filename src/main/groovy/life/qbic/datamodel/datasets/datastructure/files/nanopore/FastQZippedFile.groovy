package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class FastQZippedFile extends DataFile {

    final private static String FILE_TYPE = "fastq.gz"

    final private static String NAME_SCHEMA = /.*\.fastq.gz$/

    protected FastQZippedFile(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static FastQZippedFile create(String name, String relativePath) {
        return new FastQZippedFile(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the FastQZipped schema!")
        }
    }

}
