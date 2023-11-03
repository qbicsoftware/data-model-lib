package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.files.nanopore.Pod5File
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name is always pod5_skip.
 *
 * Its children field contains a list of type List<Pod5Files>
 *
 */
class Pod5SkipFolder extends DataFolder {

    final private static String NAME_SCHEMA = /pod5_skip/

    protected Pod5SkipFolder() {}

    protected Pod5SkipFolder(String name, String relativePath, List<Pod5File> children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a Pod5SkipFolder object
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a Pod5SkipFolder object
     */
    static Pod5SkipFolder create(String name, String relativePath, List<Pod5File> children) {
        return new Pod5SkipFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore Pod5Skip directory schema!")
        }
    }
}
