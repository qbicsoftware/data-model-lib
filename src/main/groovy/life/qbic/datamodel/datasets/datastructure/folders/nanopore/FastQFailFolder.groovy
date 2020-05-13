package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder.
 *
 * Its name is always 'fastq_fail'.
 * Its children list is of type List<FastQFolder> or of List<FastQFile>
 *
 * @author: Sven Fillinger
 */
class FastQFailFolder extends DataFolder {

    final private static String NAME = "fastq_fail"

    final private static String NAME_SCHEMA = /fastq_fail/

    protected FastQFailFolder() {}

    protected FastQFailFolder(String relativePath, List<?> children) {
        super(NAME, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a FastQFailFolder object
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a FastQFailFolder object
     */
    static FastQFailFolder create(String relativePath, List<?> children) {
        new FastQFailFolder(relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore FastQFail directory schema!")
        }
    }


}
