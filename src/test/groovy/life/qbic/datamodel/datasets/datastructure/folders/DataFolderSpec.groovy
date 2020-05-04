package life.qbic.datamodel.datasets.datastructure.folders

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class DataFolderSpec extends Specification {
    
    def "create data folder"() {
        given:
        final def name = "TestDataFolder"
        final def relativePath = "root/TestDataFolder"
        final def children = []
        final def datafile = DataFile.create("test.txt", "root/test.txt", "txt")
        children.add(datafile)

        when:
        final def dataFolder = DataFolder.create(name, relativePath, children)

        then:
        assert dataFolder.getTheChildren().get(0) instanceof DataFile
    }

    def "ensure children list is immutable"() {
        given:
        final def name = "TestDataFolder"
        final def relativePath = "root/TestDataFolder"
        final def children = []
        final def datafile = DataFile.create("test.txt", "root/test.txt", "txt")
        children.add(datafile)

        when:
        final def dataFolder = DataFolder.create(name, relativePath, children)
        dataFolder.getTheChildren().clear()

        then:
        assert dataFolder.getTheChildren().size() == 1
    }

    def "ensure hashCode() and equals() work as intendend on DataFolders with the same content"() {
        given:
        final def name = "TestDataFolder"
        final def relativePath = "root/TestDataFolder"
        final def children = []
        final def datafile = DataFile.create("test.txt", "root/test.txt", "txt")
        children.add(datafile)

        when:
        final def dataFolder = DataFolder.create(name, relativePath, children)
        final def otherDataFolder = DataFolder.create(name, relativePath, children)

        then:
        assert dataFolder.hashCode() == otherDataFolder.hashCode()
        assert dataFolder == dataFolder
    }

}
