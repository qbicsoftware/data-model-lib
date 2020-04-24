package life.qbic.datamodel.datasets.datastructure

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class FastqFile extends DataFile{

    final private static String FILE_TYPE = "fastq.gz"

    protected FastqFile(String name, String path, String fileType) {
        super(name, path, fileType)
    }

    static FastqFile create(String name, String path) {
        new FastqFile(name, path, FILE_TYPE)
    }
}
