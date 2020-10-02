package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.files.nanopore.FastQFile

/**
 * A class that is a special case of a BarcodedFolder.
 *
 * Its children contains elements of Fast5File.class objects
 *
 * @author: Sven Fillinger
 */
class FastQFolder extends BarcodedFolder {

    protected FastQFolder() {}

    protected FastQFolder(String name, String relativePath, List<FastQFile> children) {
        super(name, relativePath, children)
    }

    /**
     * Creates a new instance of a FastQFolder object
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a FastQFolder object
     */
    static FastQFolder create(String name, String relativePath, List<FastQFile> children) {
        return new FastQFolder(name, relativePath, children)
    }

}
