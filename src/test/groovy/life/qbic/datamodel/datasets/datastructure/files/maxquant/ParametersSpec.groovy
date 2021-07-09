package life.qbic.datamodel.datasets.datastructure.files.maxquant

import spock.lang.Specification

/**
 * Test for Parameters file
 *
 * @since 2.10.0
 *
*/
class ParametersSpec extends Specification{

    def "shall create a Parameters instance"() {
        given:
        final name = "parameters.txt"
        final path = "root/parameters.txt"

        when:
        def dataObject = Parameters.create(name, path)

        then:
        assert dataObject instanceof Parameters
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "parameters.log"
        final path = "root/parameters.log"

        when:
        def dataObject = Parameters.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }
}