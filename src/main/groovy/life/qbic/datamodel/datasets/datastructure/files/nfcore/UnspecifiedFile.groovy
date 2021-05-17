package life.qbic.datamodel.datasets.datastructure.files.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * A specialisation of a DataFile, represents a non-specified/variable output file in the nf-core Pipeline
 *
 * @since 2.7.0
 */
class UnspecifiedFile extends DataFile {

    protected UnspecifiedFile() {}

    protected UnspecifiedFile(String name, String relativePath, String fileType) {
        super(name, relativePath, fileType)
    }

    /**
     * Creates the Unspecified File object based on the provided fileName and its relative path
     * @param name The file name of the unspecified file
     * @param relativePath The relative path to the file in a file system
     * @param fileType The file type of the unspecified file
     * @return the UnspecifiedFile Object
     * @since 2.7.0
     */
    static UnspecifiedFile create(String name, String relativePath, String fileType) {
        return new UnspecifiedFile(name, relativePath, fileType)
    }

}
