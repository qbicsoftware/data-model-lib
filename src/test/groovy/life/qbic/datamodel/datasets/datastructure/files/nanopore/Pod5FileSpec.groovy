package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 */
class Pod5FileSpec extends Specification {

    def "shall create a Pod5 instance"() {
        given:
        final name = "test_file.pod5"
        final relativePath = "root/test_file.pod5"

        when:
        def dataObject = Pod5File.create(name, relativePath)

        then:
        assert dataObject instanceof Pod5File
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "test_file.pad4"
        final relativePath = "root/test_file.pad4"

        when:
        def dataObject = Pod5File.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }

}
