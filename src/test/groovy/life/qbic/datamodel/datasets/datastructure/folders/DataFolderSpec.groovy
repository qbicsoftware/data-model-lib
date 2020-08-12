package life.qbic.datamodel.datasets.datastructure.folders

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.files.nanopore.Fast5File
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
        final def datafile = Fast5File.create("test.fast5", "root/test.fast5")
        children.add(datafile)

        when:
        final def dataFolder = new DataFolder(name, relativePath, children)

        then:
        assert dataFolder.getChildren().get(0) instanceof DataFile
    }

    def "ensure children list is immutable"() {
        given:
        final def name = "TestDataFolder"
        final def relativePath = "root/TestDataFolder"
        final def children = []
        final def datafile = Fast5File.create("test.fast5", "root/test.fast5")
        children.add(datafile)

        when:
        final def dataFolder = new DataFolder(name, relativePath, children)
        dataFolder.getChildren().clear()

        then:
        assert dataFolder.getChildren().size() == 1
    }

    def "ensure hashCode() and equals() work as intendend on DataFolders with the same content"() {
        given:
        final def name = "TestDataFolder"
        final def relativePath = "root/TestDataFolder"
        final def children = []
        final def datafile = Fast5File.create("test.fast5", "root/test.fast5")
        children.add(datafile)

        when:
        final def dataFolder = new DataFolder(name, relativePath, children)
        final def otherDataFolder = new DataFolder(name, relativePath, children)

        then:
        assert dataFolder.hashCode() == otherDataFolder.hashCode()
        assert dataFolder == dataFolder
    }

}
