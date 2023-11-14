package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.files.nanopore.Fast5File
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name is always fast5_skip.
 *
 * Its children field contains a list of type List<Fast5Files>
 *
 */
class Fast5SkipFolder extends DataFolder {

    final private static String NAME_SCHEMA = /fast5_skip/

    protected Fast5SkipFolder() {}

    protected Fast5SkipFolder(String name, String relativePath, List<Fast5File> children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a Fast5SkipFolder object
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a Fast5SkipFolder object
     */
    static Fast5SkipFolder create(String name, String relativePath, List<Fast5File> children) {
        return new Fast5SkipFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore Fast5Skip directory schema!")
        }
    }
}
