package life.qbic.datamodel.datasets.datastructure.folders

/**
 * A special case of a DataFolder.
 *
 * Its name is always 'fastq_fail'.
 * Its children list is of type List<FastQFolder> or of List<FastQFile>
 *
 * @author: Sven Fillinger
 */
class FastQPassFolder extends DataFolder {

    final private static String NAME = "fastq_fail"

    protected FastQPassFolder() {}

    protected FastQPassFolder(String path, List<?> children) {
        super(NAME, path, children)
    }

    static FastQPassFolder create(String path, List<?> children) {
        new FastQPassFolder(path, children)
    }

}
