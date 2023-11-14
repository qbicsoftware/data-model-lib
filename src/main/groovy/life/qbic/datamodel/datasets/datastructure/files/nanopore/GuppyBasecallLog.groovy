package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore guppy basecalling client log file
 */
class GuppyBasecallLog extends DataFile {

    final private static String FILE_TYPE = "log"

    final private static String NAME_SCHEMA = $/guppy_basecall_client_log-.*/$

    protected GuppyBasecallLog() {}

    protected GuppyBasecallLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static GuppyBasecallLog create(String name, String relativePath) {
        return new GuppyBasecallLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore guppy basecall client log schema!")
        }
    }
}
