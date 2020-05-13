package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder.
 *
 * Holds information about a Oxford Nanopore NGS measurement.
 *
 * @author: Sven Fillinger
 */
class MeasurementFolder extends DataFolder {

    /**
     * The name schema of a Oxford Nanopore measurement (run).
     *
     * Example:
     * 20200219_1107_1-E3-H3_PAE26974_454b8dc6
     */
    final private static String NAME_SCHEMA = $/\d{4}(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])_([01][0-9]|2[0-3])([0-5][0-9]).*/$

    protected MeasurementFolder() {}

    protected MeasurementFolder(String name, String relativePath, List children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a MeasurementFolder object
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a MeasurementFolder object
     */
    static MeasurementFolder create(String name, String relativePath, List children) {
        new MeasurementFolder(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore Measurement schema!")
        }
    }
}
