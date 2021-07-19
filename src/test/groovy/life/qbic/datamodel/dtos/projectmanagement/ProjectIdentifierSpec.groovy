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
        ProjectIdentifier idA = new ProjectIdentifier(new ProjectSpace("TEST"), new ProjectCode("QTEST"))
        ProjectIdentifier idB = new ProjectIdentifier(new ProjectSpace("REMO"), new ProjectCode("QTEST"))

        when:
        boolean comparison = idA.equals(idB)

        then:
        assert !comparison
    }

}
