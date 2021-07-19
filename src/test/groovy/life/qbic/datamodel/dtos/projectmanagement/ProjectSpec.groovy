package life.qbic.datamodel.dtos.projectmanagement

import spock.lang.Shared
import spock.lang.Specification

/**
 * Tests for the {@link Project} class.
 *
 * @since 2.10.0
 */
class ProjectSpec extends Specification {

    @Shared
    ProjectIdentifier idA

    @Shared
    ProjectIdentifier idB

    def setup() {
        idA = new ProjectIdentifier(new ProjectSpace("TEST"), new ProjectCode("QTEST"))
        idB = new ProjectIdentifier(new ProjectSpace("REMO"), new ProjectCode("QTEST"))
    }

    def "Compare equal projects shall evaluate to true"() {
        given:
        Project projectA = new Project.Builder(idA, "test").build()
        Project projectB = new Project.Builder(idA, "test").build()

        when:
        boolean comparison = projectA.equals(projectB)

        then:
        assert comparison

    }

    def "Compare unequal projects shall evaluate to false"() {
        given:
        Project projectA = new Project.Builder(id1, descriptionA).build()
        Project projectB = new Project.Builder(id2, descriptionB).build()

        when:
        boolean comparison = projectA.equals(projectB)

        then:
        assert !comparison

        where:
        descriptionA | descriptionB | id1 | id2
        "Test"       | "Other"      | idA | idA
        "Test"       | "Test"       | idA | idB
        "Test"       | "Other"      | idA | idB
    }

}
