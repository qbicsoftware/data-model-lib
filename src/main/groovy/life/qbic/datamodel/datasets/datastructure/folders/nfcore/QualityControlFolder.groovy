package life.qbic.datamodel.datasets.datastructure.folders.nfcore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name is always multiqc.
 *
 * Its children field contains a list of type List<DataFile> or List<DataFolder>.
 *
 * @since 2.5.0
 */
class QualityControlFolder extends DataFolder {

    final private static String NAME_SCHEMA = /multiqc/

    protected QualityControlFolder() {}

    protected QualityControlFolder(String name, String relativePath, List<?> children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a QualityControlFolder object
     *
     * @param name The folder name
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a QualityControlFolder object
     */
    static QualityControlFolder create(String name, String relativePath, List<?> children) {
        new QualityControlFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the nf-core quality control directory schema!")
        }
    }
}
