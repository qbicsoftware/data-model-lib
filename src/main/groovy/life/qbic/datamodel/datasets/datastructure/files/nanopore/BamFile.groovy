package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore bam file
 *
 */
class BamFile extends DataFile {

    final private static String FILE_TYPE = "bam"

    final private static String NAME_SCHEMA = /.*\.bam$/

    protected BamFile(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static BamFile create(String name, String relativePath) {
        return new BamFile(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore summary schema!")
        }
    }

}
