package life.qbic.datamodel.datasets.datastructure.files

import groovy.transform.ToString

/**
 * A DataFile object represents a file
 * with a name, a path and a fileType
 *
 * @author: Sven Fillinger
 */
@ToString(includeNames=true) // includes property names
class DataFile {

    /**
     * The file name
     */
    final private String name

    /**
     * The file path
     */
    final private String relativePath

    /**
     * The file path
     */
    final private String fileType

    protected DataFile() {}

    protected DataFile(String name, String relativePath, String fileType){
        this.name = name
        this.relativePath = relativePath
        this.fileType = fileType
    }

    /**
     * Static factory method to create DataFile objects.
     * @param name The file name
     * @param relativePath The file path
     * @param fileType The file type
     * @return A new DataFile object
     */
    static DataFile create(String name, String relativePath, String fileType) {
        new DataFile(name, relativePath, fileType)
    }

    String getRelativePath() {
        return relativePath
    }

    @Override
    boolean equals(Object o){
        if (o == this){
            return true
        }
        if (!(o instanceof DataFile)) {
            return false
        }
        DataFile datafile = (DataFile) o
        return datafile.name == name
                && datafile.getRelativePath() == relativePath
                && datafile.fileType
    }

    @Override
    int hashCode() {
        int result = name.hashCode()
        result = 31 * result + relativePath.hashCode()
        result = 31 * result + fileType.hashCode()
        return result
    }
}
