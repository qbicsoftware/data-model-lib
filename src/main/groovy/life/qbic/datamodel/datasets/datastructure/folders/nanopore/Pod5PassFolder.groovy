package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name is always pod5_pass.
 *
 * Its children field contains either a list of type List<Pod5Files> or List<Pod5Folder>
 *
 */
class Pod5PassFolder extends DataFolder {

    final private static String NAME_SCHEMA = /pod5_pass/

    protected Pod5PassFolder() {}

    protected Pod5PassFolder(String name, String relativePath, List<?> children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a Pod5PassFolder object
     *
     * @param name The folder name
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a Pod5PassFolder object
     */
    static Pod5PassFolder create(String name, String relativePath, List<?> children) {
        new Pod5PassFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore Pod5Pass directory schema!")
        }
    }
}
