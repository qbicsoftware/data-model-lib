package life.qbic.datamodel.datasets.datastructure.folders

import groovy.transform.ToString

@ToString(includeNames=true)
class DataFolder {

    private final String name

    private final String relativePath

    private final List children

    protected DataFolder() {}

    protected DataFolder(String name, String relativePath, List childrenList) {
        this.name = name
        this.relativePath = relativePath
        this.children = new ArrayList<>()
        // Make a defensive copy of the mutable List object
        for (Object element : childrenList) {
            try {
                children.add(element.clone())
            } catch (CloneNotSupportedException) {
                children.add(element)
            }
        }
    }

    protected static DataFolder create(String name, String relativePath, List children) {
        if (!(relativePath.contains(name)))  {
            throw new IllegalArgumentException("Name must be contained in the relative path.")
        }
        new DataFolder(name, relativePath, children)
    }

    /**
     * Returns the relative path of the folder
     * @return
     */
    String getRelativePath() {
        return relativePath
    }

    /**
     * Returns the name of the folder
     * @return
     */
    String getName() {
        return name
    }

    /**
     * Returns the children of the folder.
     * @return
     */
    List getTheChildren() {
        List copiedList = []
        children.each { element ->
            copiedList.add(element)
        }
        return copiedList
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
