package life.qbic.datamodel.dtos.projectmanagement

import spock.lang.Specification

/**
 * Tests for the {@link ProjectIdentifier}.
 *
 * @since 2.10.0
 */
class ProjectIdentifierSpec extends Specification{

    def "Compare to equal ids"() {
        given:
        ProjectIdentifier idA = new ProjectIdentifier(new ProjectSpace("TEST"), new ProjectCode("QTEST"))
        ProjectIdentifier idB = new ProjectIdentifier(new ProjectSpace("TEST"), new ProjectCode("QTEST"))

        when:
        boolean comparison = idA.equals(idB)

        then:
        assert comparison
    }

    def "Compare to unequal ids"() {
        given:
        ProjectIdentifier idA = new ProjectIdentifier(new ProjectSpace(projectSpaceA), new ProjectCode(projectCodeA))
        ProjectIdentifier idB = new ProjectIdentifier(new ProjectSpace(projectSpaceB), new ProjectCode(projectCodeB))

        when:
        boolean comparison = idA.equals(idB)

        then:
        assert !comparison

        where:
        projectSpaceA | projectSpaceB | projectCodeA | projectCodeB
        "TEST" | "TEST" | "QTEST" | "QREMU"
        "TEST" | "REMU" | "QTEST" | "QREMU"
        "TEST" | "REMU" | "QTEST" | "QTEST"

    }

}
