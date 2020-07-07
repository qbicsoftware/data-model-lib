package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name contains always fast5_fail.
 *
 * Its children field contains either a list of type List<Fast5Files> or List<Fast5Folder>
 *
 * @author: Sven Fillinger
 */
class Fast5FailFolder extends DataFolder {

    final private static String NAME_SCHEMA = /fast5_fail/

    protected Fast5FailFolder() {}

    protected Fast5FailFolder(String name, String relativePath, List children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a Fast5FailFolder object
     *
     * @param name The folder name
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a Fast5FailFolder object
     */
    static Fast5FailFolder create(String name, String relativePath, List children) {
        new Fast5FailFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore FastQPass directory schema!")
        }
    }
}
