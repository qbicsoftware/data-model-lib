package life.qbic.datamodel.datasets.datastructure.files

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore fast5 file
 *
 * @author: Sven Fillinger
 */
class Fast5File extends DataFile{

    final private static String FILE_TYPE = "fast5"

    protected Fast5File(String name, String path, String fileType) {
       super(name, path, fileType)
    }

    static Fast5File create(String name, String path) {
        new Fast5File(name, path, FILE_TYPE)
    }

}
