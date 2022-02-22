package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents an Oxford Nanopore barcode alignment log file
 *
 */
class BarcodeAlignmentLog extends DataFile {

    final private static String FILE_TYPE = "tsv"

    final private static String NAME_SCHEMA = $/barcode_alignment_.*/$

    protected BarcodeAlignmentLog() {}

    protected BarcodeAlignmentLog(String name, String relativePath) {
        super(name, relativePath, FILE_TYPE)
        validateName()
    }

    static BarcodeAlignmentLog create(String name, String relativePath) {
        return new BarcodeAlignmentLog(name, relativePath)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore barcode alignment log name schema!")
        }
    }

}
