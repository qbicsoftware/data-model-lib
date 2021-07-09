package life.qbic.datamodel.datasets.datastructure.files.maxquant

import spock.lang.Specification

/**
 * Test for RunParameters files
 *
 * @since 2.10.0
 *
*/
class RunParametersSpec extends Specification{

    def "shall create a RunParameters instance"() {
        given:
        final name = "mqpar.xml"
        final path = "root/mqpar.xml"

        when:
        def dataObject = RunParameters.create(name, path)

        then:
        assert dataObject instanceof RunParameters
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "mqpar.log"
        final path = "root/mqpar.log"

        when:
        def dataObject = RunParameters.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }
}