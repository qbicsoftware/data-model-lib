package life.qbic.datamodel.datasets.datastructure.files

import groovy.transform.CompileStatic
import groovy.transform.ToString

/**
 * A DataFile object represents a file
 * with a name, a path and a fileType
 *
 * @author: Sven Fillinger
 */
@ToString(includeNames=true) // includes property names
@CompileStatic
class DataFile {

    /**
     * The file name
     */
    final private String name

    /**
     * The relative file path
     */
    final private String relativePath

    /**
     * The file type
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
     * @return DataFile Creates a new DataFile instance
     */
    static DataFile create(String name, String relativePath, String fileType) {
        if ( !(relativePath.contains(name)))  {
            throw new IllegalArgumentException("Name must be contained in the relative path.")
        }
        new DataFile(name, relativePath, fileType)
    }

    final String getRelativePath() {
        return relativePath
    }

    final String getName() {
        return name
    }

    final String getFileType() {
        return fileType
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
        return datafile.name == name \
                && datafile.getRelativePath() == relativePath \
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
