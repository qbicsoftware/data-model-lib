package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore pore scan data log file
 *
 */
class PoreScanDataLog extends DataFile {

    final private static String FILE_TYPE = "csv"

    final private static String NAME_SCHEMA = $/pore_scan_data_.*/$

    protected PoreScanDataLog() {}

    protected PoreScanDataLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static PoreScanDataLog create(String name, String relativePath) {
        return new PoreScanDataLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore pore scan data log name schema!")
        }
    }

}
