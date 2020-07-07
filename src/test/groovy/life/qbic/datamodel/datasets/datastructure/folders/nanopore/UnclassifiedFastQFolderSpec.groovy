package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.files.nanopore.FastQFile
import spock.lang.Specification

/**
 * Tests for the UnclassifiedFastQFolder Object
 *
 * @author: Sven Fillinger
 */
class UnclassifiedFastQFolderSpec extends Specification {

    def "create measurement folder"() {
        given:
        final def name = "fastq_unclassified"
        final def relativePath = "root/fastq_unclassified"
        final def children = []
        final def datafile = FastQFile.create("test.fastq", "root/test.fastq")
        children.add(datafile)

        when:
        final def dataFolder = UnclassifiedFastQFolder.create(name, relativePath, children)

        then:
        assert dataFolder.getChildren().get(0) instanceof DataFile

    }

    def "naming schema violation should raise an IllegalArgumentException"() {
        given:
        final def name = "fastq_unsatisfied"
        final def relativePath = "root/fastq_unclassified"
        final def children = []
        final def datafile = FastQFile.create("test.fastq", "root/test.fastq")
        children.add(datafile)

        when:
        final def dataFolder = MeasurementFolder.create(name, relativePath, children)

        then:
        thrown(IllegalArgumentException)

    }
}
