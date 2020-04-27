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

    protected FastQFailFolder() {}

    protected FastQFailFolder(String relativePath, List<?> children) {
        super(NAME, relativePath, children)
    }

    static FastQFailFolder create(String relativePath, List<?> children) {
        new FastQFailFolder(relativePath, children)
    }

}
