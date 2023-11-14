package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.files.nanopore.GuppyBasecallLog
import spock.lang.Specification

/**
 * <add class description here>
 */
class BasecallingFolderSpec extends Specification {

    def "create basecalling folder"() {
        given:
        final def name = "basecalling"
        final def relativePath = "root/basecalling"
        final def children = []
        final def datafile = GuppyBasecallLog.create("guppy_basecall_client_log-.log", "root/basecalling/guppy_basecall_client_log-.log")
        children.add(datafile)

        when:
        final def dataFolder = BasecallingFolder.create(name, relativePath, children)

        then:
        assert dataFolder.getChildren().get(0) instanceof DataFile

    }

    def "naming schema violation should raise an IllegalArgumentException"() {
        given:
        final def name = "basedcall"
        final def relativePath = "root/basedcall"
        final def children = []
        final def datafile = GuppyBasecallLog.create("guppy_basecall_client_log-.log", "root/basedcall/guppy_basecall_client_log-.log")
        children.add(datafile)

        when:
        final def dataFolder = BasecallingFolder.create(name, relativePath, children)

        then:
        thrown(IllegalArgumentException)

    }
}
