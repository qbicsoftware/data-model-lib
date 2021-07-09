package life.qbic.datamodel.datasets.datastructure.files.maxquant

import spock.lang.Specification

/**
 * Tests for AllPeptides files
 *
 * @since 2.10.0
 *
*/
class AllPeptidesSpec extends Specification{

    def "shall create a AllPeptides instance"() {
        given:
        final name = "allPeptides.txt"
        final path = "root/allPeptides.txt"

        when:
        def dataObject = AllPeptides.create(name, path)

        then:
        assert dataObject instanceof AllPeptides
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "allPeptides.log"
        final path = "root/allPeptides.log"

        when:
        def dataObject = AllPeptides.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }
}