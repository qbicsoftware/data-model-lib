package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore throughput log file
 *
 * @author: Sven Fillinger
 */
class ThroughputLog extends DataFile {

    final private static String FILE_TYPE = "csv"

    final private static String NAME_SCHEMA = $/throughput_.*/$

    protected ThroughputLog() { }

    protected ThroughputLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static ThroughputLog create(String name, String relativePath) {
        return new ThroughputLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore throughput log name schema!")
        }
    }

}
