package life.qbic.datamodel.datasets.datastructure.files

/**
 * A specialisation of a DataFile, represents an NGS fastq file
 *
 * @author: Sven Fillinger
 */
class FastQFile extends DataFile{

    final private static String FILE_TYPE = "fastq.gz"

    protected FastQFile(String name, String path, String fileType) {
        super(name, path, fileType)
    }

    static FastQFile create(String name, String path) {
        new FastQFile(name, path, FILE_TYPE)
    }
}
