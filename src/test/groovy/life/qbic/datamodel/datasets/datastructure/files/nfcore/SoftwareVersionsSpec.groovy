package life.qbic.datamodel.datasets.datastructure.files.nfcore

import spock.lang.Specification

/**
 * Test for the SoftwareVersions class
 *
 * @since 2.5.0
 */
class SoftwareVersionsSpec extends Specification {

    def "shall create a SoftwareVersions instance"() {
        given:
        final name = "software_versions_testfile.csv"
        final path = "root/software_versions_testfile.csv"

        when:
        def dataObject = SoftwareVersions.create(name, path)

        then:
        assert dataObject instanceof SoftwareVersions
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "software_versions.log"
        final path = "root/software_versions.log"

        when:
        def dataObject = SoftwareVersions.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }

}
