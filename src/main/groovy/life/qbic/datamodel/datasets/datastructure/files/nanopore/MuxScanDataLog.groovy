package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore Mux scan data log file
 *
 * @author: Sven Fillinger
 */
class MuxScanDataLog extends DataFile {

    final private static String FILE_TYPE = "csv"

    final private static String NAME_SCHEMA = $/mux_scan_data.*/$

    protected MuxScanDataLog() { }

    protected MuxScanDataLog(String name, String path) {
        super(name, path, FILE_TYPE)
        validateName()
    }

    static MuxScanDataLog create(String name, String path) {
        return MuxScanDataLog(name, path)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore drift mux scan name schema!")
        }
    }

}
