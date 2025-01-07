package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 */
class BamFileSpec extends Specification {

    def "shall create a BamFile instance"() {
        given:
        final name = "test_file.bam"
        final relativePath = "root/test_file.bam"

        when:
        def dataObject = BamFile.create(name, relativePath)

        then:
        assert dataObject instanceof BamFile
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "test_file.bum"
        final relativePath = "root/test_file.bum"

        when:
        def dataObject = BamFile.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }

}
