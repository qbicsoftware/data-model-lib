package life.qbic.datamodel.dtos.projectmanagement

import spock.lang.Specification

/**
 * Tests the project code vaidation
 *
 * @since 2.3.0
 */
class ProjectCodeSpec extends Specification {

    def "A String violating the project code format standard shall throw an IllegalArgumentException" () {
        given:
        String invalidCode = " M-ABCD  "

        when:
        new ProjectCode(invalidCode)

        then:
        thrown(IllegalArgumentException)

    }

    def "A String sticking to the project code format standard shall create a ProjectCode object instance successfully"() {
        given:
        String validCode = "  QABCD  "

        when:
        ProjectCode projectCode = new ProjectCode(validCode)

        then:
        noExceptionThrown()
        assert projectCode.code.equals("QABCD")
    }
}
