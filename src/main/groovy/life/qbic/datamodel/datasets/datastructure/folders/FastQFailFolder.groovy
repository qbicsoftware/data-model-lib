package life.qbic.datamodel.datasets.datastructure.folders

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

    protected FastQFailFolder(String path, List<?> children) {
        super(NAME, path, children)
    }

    static FastQFailFolder create(String path, List<?> children) {
        new FastQFailFolder(path, children)
    }

}
