package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.files.nanopore.Fast5File

/**
 * A class that is a special case of a BarcodedFolder.
 *
 * Its children contains elements of Fast5File.class objects
 *
 * @author: Sven Fillinger
 */
class Fast5Folder extends BarcodedFolder {

    protected Fast5Folder() {}

    protected Fast5Folder(String name, String relativePath, List<Fast5File> children) {
        super(name, relativePath, children)
    }

    /**
     * Creates a new instance of a Fast5Folder object
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a Fast5Folder object
     */
    static Fast5Folder create(String name, String relativePath, List<Fast5File> children) {
        return new Fast5Folder(name, relativePath, children)
    }
}
