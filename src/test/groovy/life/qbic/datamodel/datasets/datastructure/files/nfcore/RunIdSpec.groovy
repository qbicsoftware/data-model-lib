package life.qbic.datamodel.datasets.datastructure.files.nfcore

import spock.lang.Specification

/**
 * Test for the runId class
 *
 * @since 2.5.0
 */
class RunIdSpec extends Specification {

    def "shall create a runId instance"() {
        given:
        final name = "run_id_test.txt"
        final relativePath = "root/run_id_test.txt"

        when:
        def dataObject = RunId.create(name, relativePath)

        then:
        assert dataObject instanceof RunId
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "run_id.txt"
        final relativePath = "root/run_id.txt"

        when:
        def dataObject = RunId.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }


}
