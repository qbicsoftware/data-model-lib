package life.qbic.datamodel.datasets.datastructure

/**
 * A class that is a special case of a BarcodedFolder.
 *
 * Its children contains elements of Fast5File.class objects
 *
 * @author: Sven Fillinger
 */
class Fast5Folder extends BarcodedFolder {

    protected Fast5Folder() {}

    protected Fast5Folder(String name, String path, List<Fast5File> children) {
        super(name, path, children)
    }

    static Fast5Folder create(String name, String path, List<Fast5File> children) {
        new Fast5Folder(name, path, children)
    }

}
