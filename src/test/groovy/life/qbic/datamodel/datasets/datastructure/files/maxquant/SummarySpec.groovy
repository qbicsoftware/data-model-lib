package life.qbic.datamodel.datasets.datastructure.files.maxquant

import spock.lang.Specification

/**
 * Test for Summary files
 *
 * @since 2.10.0
 *
*/
class SummarySpec extends Specification{

    def "shall create a Summary instance"() {
        given:
        final name = "summary_1234.pdf"
        final path = "root/summary_1234.pdf"

        when:
        def dataObject = Summary.create(name, path)

        then:
        assert dataObject instanceof Summary
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "summary_1234.log"
        final path = "root/summary_1234.log"

        when:
        def dataObject = Summary.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }
}