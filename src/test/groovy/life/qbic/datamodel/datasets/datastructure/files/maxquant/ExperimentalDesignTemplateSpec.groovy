package life.qbic.datamodel.datasets.datastructure.files.maxquant

import spock.lang.Specification

/**
 * Tests for ExperimentalDesignTemplate files
 *
 * @since 2.10.0
 *
*/
class ExperimentalDesignTemplateSpec extends Specification{

    def "shall create a ExperimentalDesignTemplate instance"() {
        given:
        final name = "experimentalDesignTemplate.txt"
        final path = "root/experimentalDesignTemplate.txt"

        when:
        def dataObject = ExperimentalDesignTemplate.create(name, path)

        then:
        assert dataObject instanceof ExperimentalDesignTemplate
        assert dataObject.relativePath == path
        assert dataObject.name == name
    }

    def "name not matching schema shall throw IllegalArgumentException"() {
        given:
        final name = "experimentalDesignTemplate.log"
        final path = "root/experimentalDesignTemplate.log"

        when:
        def dataObject = ExperimentalDesignTemplate.create(name, path)

        then:
        thrown(IllegalArgumentException)
    }
}