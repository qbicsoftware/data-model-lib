package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder.
 *
 * Holds information about a Oxford Nanopore NGS measurement.
 *
 */
class OtherReportsFolder extends DataFolder {

    /**
     * The name schema of a Oxford Nanopore "other reports" folder.
     */
    final private static String NAME_SCHEMA = $/other_reports/$

    protected OtherReportsFolder() {}

    protected OtherReportsFolder(String name, String relativePath, List children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a OtherReportsFolder object
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of unknown type of the folder
     * @return A new instance of a OtherReportsFolder object
     */
    static OtherReportsFolder create(String name, String relativePath, List<?> children) {
        new OtherReportsFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore other_reports folder schema!")
        }
    }
}
