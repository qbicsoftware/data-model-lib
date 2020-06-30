package life.qbic.datamodel.datasets.datastructure.folders

import groovy.transform.ToString

@ToString(includeNames = true)
class DataFolder {

    private final String name

    private final String relativePath

    private final List children

    protected DataFolder() {}

    protected DataFolder(String name, String relativePath, List childrenList) {
        if (!(relativePath.contains(name))) {
            throw new IllegalArgumentException("Name must be contained in the relative path.")
        }
        this.name = Objects.requireNonNull(name, "Name must not be null")
        this.relativePath = Objects.requireNonNull(relativePath, "You shall not path! Path must not be null")
        Objects.requireNonNull(childrenList, "Children list must not be null")
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
        return this.children.collect{it}
    }

    List getChildren() {
        throw new IllegalAccessException("Please use the method getTheChildren().")
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
        if (o.is(this)) {
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
