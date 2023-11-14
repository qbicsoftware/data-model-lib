package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name is always pod5_fail.
 *
 * Its children field contains either a list of type List<Pod5Files> or List<Pod5Folder>
 *
 */
class Pod5FailFolder extends DataFolder {

    final private static String NAME_SCHEMA = /pod5_fail/

    protected Pod5FailFolder() {}

    protected Pod5FailFolder(String name, String relativePath, List children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a Pod5FailFolder object
     *
     * @param name The folder name
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a Pod5FailFolder object
     */
    static Pod5FailFolder create(String name, String relativePath, List children) {
        new Pod5FailFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore Pod5Fail directory schema!")
        }
    }
}
