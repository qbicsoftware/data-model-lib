package life.qbic.datamodel.datasets.datastructure.files.maxquant

import spock.lang.Specification

/**
 * Test for Evidence files
 *
 * @since 2.10.0
 *
*/
class EvidenceSpec extends Specification{

    def "shall create a Evidence instance"() {
        given:
        final name = "evidence.txt"
        final path = "root/evidence.txt"

        when:
        def dataObject = Evidence.create(name, path)

        then:
        assert dataObject instanceof Evidence
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "evidence.log"
        final path = "root/evidence.log"

        when:
        def dataObject = Evidence.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }
}