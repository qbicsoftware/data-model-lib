package life.qbic.datamodel.datasets.datastructure.files.general

import spock.lang.Specification

/**
 * Test for the InputIDs class
 *
 * @since 2.6.0
 */
class SampleIdsSpec extends Specification {

    def "shall create a sampleId instance"() {
        given:
        final name = "sample_ids.txt"
        final relativePath = "root/sample_ids.txt"

        when:
        def dataObject = SampleIds.create(name, relativePath)

        then:
        assert dataObject instanceof SampleIds
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "sample_itts.txt"
        final relativePath = "root/sample_itts.txt"

        when:
        def dataObject = SampleIds.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }


}
