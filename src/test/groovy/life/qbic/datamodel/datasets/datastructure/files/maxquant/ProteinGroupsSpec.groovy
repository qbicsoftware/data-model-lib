package life.qbic.datamodel.datasets.datastructure.files.maxquant

import spock.lang.Specification

/**
 * Tests for ProteinGroups files
 *
 * @since 2.10.0
 *
*/
class ProteinGroupsSpec extends Specification{

    def "shall create a ProteinGroups instance"() {
        given:
        final name = "proteinGroups.txt"
        final path = "root/proteinGroups.txt"

        when:
        def dataObject = ProteinGroups.create(name, path)

        then:
        assert dataObject instanceof ProteinGroups
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "proteinGroups.log"
        final path = "root/proteinGroups.log"

        when:
        def dataObject = ProteinGroups.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }
}