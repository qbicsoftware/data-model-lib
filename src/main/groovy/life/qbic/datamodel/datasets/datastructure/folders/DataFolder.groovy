package life.qbic.datamodel.datasets.datastructure.folders

import groovy.transform.ToString

@ToString(includeNames=true)
class DataFolder {

    private final String name

    private final String relativePath

    private final List<?> children

    protected DataFolder() {}

    protected DataFolder(String name, String relativePath, List children) {
        this.name = name
        this.relativePath = relativePath
        this.children = new ArrayList<>()
        // Make a defensive copy of the mutable List object
        children.each { element ->
            try {
                this.children.add(element.clone())
            } catch (CloneNotSupportedException) {
                this.children.add(element)
            }
        }
    }

    static DataFolder create(String name, String relativePath, List<?> children) {
        new DataFolder(name, relativePath, children)
    }

    /**
     * Returns the relative path of the folder
     * @return
     */
    String getRelativePath() {
        return relativePath
    }

    @Override
    int hashCode() {
        int result = name.hashCode()
        result = 31 * result + relativePath.hashCode()
        children.each {
            result = 31 * result + it.hashCode()
        }
        return result
    }

    @Override
    boolean equals(Object o) {
        if (o == this) {
            return true
        }
        if (!(o instanceof DataFolder)) {
            return false
        }
        DataFolder folder = (DataFolder) o
        return folder.name == name &&
                folder.relativePath == relativePath &&
                folder.children == children
    }

}
