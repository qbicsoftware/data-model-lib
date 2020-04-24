package life.qbic.datamodel.datasets.datastructure

import groovy.transform.ToString

@ToString(includeNames=true)
class DataFolder {

    private final String name

    private final String path

    private final List<?> children

    protected DataFolder() {}

    protected DataFolder(String name, String path, List children) {
        this.name = name
        this.path = path
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

    static DataFolder create(String name, String path, List children) {
        new DataFolder(name, path, children)
    }

    @Override
    int hashCode() {
        int result = name.hashCode()
        result = 31 * result + path.hashCode()
        children.each {
            result = 31 * result + it.hashCode()
        }
        return result
    }

    @Override
    boolean equals(Object o) {

    }

}
