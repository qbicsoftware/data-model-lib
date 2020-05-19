package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class Fast5PassFolder extends DataFolder {

    final private static String NAME = "fast5_pass"

    final private static String NAME_SCHEMA = /fast5_pass/

    protected Fast5PassFolder() {}

    protected Fast5PassFolder(String relativePath, List<?> children) {
        super(NAME, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a Fast5PassFolder object
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a Fast5PassFolder object
     */
    static Fast5PassFolder create(String relativePath, List<?> children) {
        new Fast5PassFolder(relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore Fast5Pass directory schema!")
        }
    }
}
