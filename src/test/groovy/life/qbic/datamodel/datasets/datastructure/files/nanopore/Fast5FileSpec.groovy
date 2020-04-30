package life.qbic.datamodel.datasets.datastructure.files.nanopore

import spock.lang.Specification

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class Fast5FileSpec extends Specification {

    def "shall create a Fast5File instance"()  {
        given:
        final name = "test_file.fast5"
        final relativePath = "root/test_file.fast5"

        when:
        def dataObject = Fast5File.create(name, relativePath)

        then:
        assert dataObject instanceof Fast5File
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "test_file.fast4"
        final relativePath = "root/test_file.fast4"

        when:
        def dataObject = Fast5File.create(name, relativePath)

        then:
        thrown(IllegalArgumentException)
    }

}
