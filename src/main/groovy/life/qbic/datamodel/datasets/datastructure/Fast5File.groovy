package life.qbic.datamodel.datasets.datastructure


/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class Fast5File extends DataFile{

    private static final String FILE_TYPE = "fast5"

    protected Fast5File(String name, String path, String fileType) {
       create(name, path, fileType)
    }

    static Fast5File create(String name, String path) {
        new Fast5File(name, path, FILE_TYPE)
    }

}
