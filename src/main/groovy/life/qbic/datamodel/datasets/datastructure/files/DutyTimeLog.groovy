package life.qbic.datamodel.datasets.datastructure.files

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore duty time log file
 *
 * @author: Sven Fillinger
 */
class DutyTimeLog extends DataFile {

    final private static String FILE_TYPE = "CSV"

    protected DriftCorrectionFile() { }

    protected DriftCorrectionFile(String name, String path) {
        super(name, path, FILE_TYPE)

    }

    DriftCorrectionFile create(String name, String path) {

    }
}
