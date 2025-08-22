package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name is always bam_pass.
 *
 * Its children field contains either a list of type List<BamFiles> or List<BamFolder>
 *
 */
class BamPassFolder extends DataFolder {

    final private static String NAME_SCHEMA = /bam_pass/

    protected BamPassFolder() {}

    protected BamPassFolder(String name, String relativePath, List<?> children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a BamPassFolder object
     *
     * @param name The folder name
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a BamPassFolder object
     */
    static BamPassFolder create(String name, String relativePath, List<?> children) {
        new BamPassFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore BamPass directory schema!")
        }
    }
}
