package life.qbic.datamodel.dtos.projectmanagement

import spock.lang.Specification

/**
 * Tests the formatting of the project space
 *
 * @since 2.3.0
 */
class ProjectSpaceSpec extends Specification {

    def "A string including inner white space will be replaced with underscore chars"() {
        given:
        String projectSpaceName = " my new space   "

        when:
        ProjectSpace space = new ProjectSpace(projectSpaceName)

        then:
        space.name.equals("MY_NEW_SPACE")
    }

    def "A String violating the space name format standard shall throw an IllegalArgumentException" () {
        given:
        String invalidCode = "Plausibilitätsüberprüfungs_Space"

        when:
        new ProjectSpace(invalidCode)

        then:
        thrown(IllegalArgumentException)

    }

    def "Dashes are replaced by underscores"() {
        given:
        String projectSpaceName = "my-new-space"

        when:
        ProjectSpace space = new ProjectSpace(projectSpaceName)

        then:
        space.name.equals("MY_NEW_SPACE")
    }
}
