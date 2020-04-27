package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 *  A specialisation of a DataFile, represents an Oxford Nanopore sequencing summary log file
 *
 * @author: Sven Fillinger
 */
class SequencingSummaryLog extends DataFile {

    final private static String FILE_TYPE = "txt"

    final private static String NAME_SCHEMA = $/sequencing_summary_.*/$

    protected SequencingSummaryLog() { }

    protected SequencingSummaryLog(String name, String path) {
        super(name, path, FILE_TYPE)
        validateName()
    }

    static SequencingSummaryLog create(String name, String path) {
        return new SequencingSummaryLog(name, path)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore sequencing summary log name schema!")
        }
    }

}
