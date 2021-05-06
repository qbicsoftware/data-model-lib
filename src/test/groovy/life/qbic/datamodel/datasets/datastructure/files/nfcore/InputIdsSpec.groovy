package life.qbic.datamodel.datasets.datastructure.files.nfcore

import spock.lang.Specification

/**
 * Test for the InputIDs class
 *
 * @since 2.5.0
 */
class InputIdsSpec extends Specification {

    def "shall create a InputIds instance"() {
        given:
        final name = "input_ids_test.txt"
        final relativePath = "root/input_ids_test.txt"

        when:
        def dataObject = InputIds.create(name, relativePath)

        then:
        assert dataObject instanceof InputIds
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "input_ids.txt"
        final relativePath = "root/input_ids.txt"

        when:
        def dataObject = InputIds.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }


}
