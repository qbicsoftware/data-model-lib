package life.qbic.datamodel.datasets.datastructure.files.nfcore

import spock.lang.Specification

/**
 * Test for the UnspecifiedFile class
 *
 * @since 2.7.0
 */
class UnspecifiedFileSpec extends Specification {

    def "shall create an UnspecifiedFile instance"() {
        given:
        final name = "DummyFile"
        final relativePath = "root/DummyFile"

        when:
        def dataObject = UnspecifiedFile.create(name, relativePath, "txt")

        then:
        assert dataObject instanceof UnspecifiedFile
        assert dataObject.relativePath == relativePath
        assert dataObject.name == name
    }

}
