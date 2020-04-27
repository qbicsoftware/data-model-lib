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

    final private static String NAME_SCHEMA = $/\d{4}(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])_([01][0-9]|2[0-3])([0-5][0-9]).*/$

    protected MeasurementFolder(){}

    protected MeasurementFolder(String name, String path, List<?> children) {
        super(name, path, children)
        validateName()
    }

    static MeasurementFolder create(String name, String path, List<?> children) {
        new MeasurementFolder(name, path, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore Measurement schema!")
        }
    }
}
