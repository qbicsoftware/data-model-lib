package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class MeasurementFolderSpec extends Specification {

    def "create measurement folder"() {
        given:
        final def name = "20200219_1107_1-E3-H3_PAE26974_454b8dc6_TestDataFolder"
        final def relativePath = "root/20200219_1107_1-E3-H3_PAE26974_454b8dc6_TestDataFolder"
        final def children = []
        final def datafile = DataFile.create("test.txt", "root/test.txt", "txt")
        children.add(datafile)

        when:
        final def dataFolder = MeasurementFolder.create(name, relativePath, children)

        then:
        assert dataFolder.getTheChildren().get(0) instanceof DataFile

    }

    def "naming schema violation should raise an IllegalArgumentException"() {
        given:
        final def name = "0219_1107_1-E3-H3_PAE26974_454b8dc6_TestDataFolder"
        final def relativePath = "root/0219_1107_1-E3-H3_PAE26974_454b8dc6_TestDataFolder"
        final def children = []
        final def datafile = DataFile.create("test.txt", "root/test.txt", "txt")
        children.add(datafile)

        when:
        final def dataFolder = MeasurementFolder.create(name, relativePath, children)

        then:
        thrown(IllegalArgumentException)

    }
}
