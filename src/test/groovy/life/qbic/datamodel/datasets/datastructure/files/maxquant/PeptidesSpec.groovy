package life.qbic.datamodel.datasets.datastructure.files.maxquant

import spock.lang.Specification

/**
 * Test for Peptides files
 *
 * @since 2.10.0
 *
*/
class PeptidesSpec extends Specification{

    def "shall create a Peptides instance"() {
        given:
        final name = "peptides.txt"
        final path = "root/peptides.txt"

        when:
        def dataObject = Peptides.create(name, path)

        then:
        assert dataObject instanceof Peptides
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "peptides.log"
        final path = "root/peptides.log"

        when:
        def dataObject = Peptides.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }
}