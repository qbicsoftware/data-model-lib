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

    /**
     * Tests for Joshua Bloch's Item 8 in Effective Java, how to override equals() properly.
     * https://biratkirat.medium.com/learning-effective-java-item-8-d05f3847213d
     */
    def "Test equals method fulfills full method contract"() {
        when:
        ProjectIdentifier idX = new ProjectIdentifier(new ProjectSpace(projectSpace), new ProjectCode(projectCode))
        ProjectIdentifier idY = new ProjectIdentifier(new ProjectSpace(projectSpace), new ProjectCode(projectCode))
        ProjectIdentifier idZ = new ProjectIdentifier(new ProjectSpace(projectSpace), new ProjectCode(projectCode))

        then:
        idX.equals(idX) == true // Reflexive
        (idX.equals(idY) == true) && (idY.equals(idX) == true) // Symmetric
        (idX.equals(idY) == true) && (idY.equals(idZ) == true) && (idX.equals(idZ) == true) // Transitive
        (idX.equals(idX) == true) && (idX.equals(idX) == true) // Consistent
        idX.equals(null) == false // Non-nullity

        where:
        projectSpace | projectCode
        "TEST" | "QTEST"
    }

}
