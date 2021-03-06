package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Simple tests for the customer dto class
 *
 * @since 1.12.0
 */

class ProjectManagerSpec extends Specification{

    def "missing first name shall raise a NullPointerException"() {
        when:
        new ProjectManager.Builder(null, "", "a.b@c.de").build()

        then:
        thrown(NullPointerException)
    }

    def "missing last name shall raise a NullPointerException"() {
        when:
        new ProjectManager.Builder("Max", null, "a.b@c.de").build()

        then:
        thrown(NullPointerException)
    }

    def "missing email name shall raise a NullPointerException"() {
        when:
        new ProjectManager.Builder("Max", "Mustermann", null).build()

        then:
        thrown(NullPointerException)
    }

    def "missing affiliation list shall cause the customer to contain an empty list"() {
        when:
        def projectManager = new ProjectManager.Builder("Max", "Mustermann", "max@example.com").build()
        then:
        assert projectManager.affiliations.isEmpty()
    }

    def "different project managers result in different objects"() {
        when: "two different project managers are created"
        ProjectManager projectManager1 = new ProjectManager.Builder("Andrew", "PM", "a.p@d.ef").build()
        ProjectManager projectManager2 = new ProjectManager.Builder("Betty", "PM", "b.p@d.ef").build()

        then: "the project managers and their hash code are not equal"
        projectManager1.hashCode() != projectManager2.hashCode()
        projectManager1 != projectManager2
    }

}
