package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Simple tests for the projectManager dto class
 *
 * @since 1.12.0
 */
class ProjectManagerSpec extends Specification {

        def "missing first name shall raise a NullPointerException"() {
            when:
            def projectManager = new ProjectManager(null, "", AcademicTitle.NONE, "a.b@c.de", [])

            then:
            thrown(NullPointerException)
        }

        def "missing last name shall raise a NullPointerException"() {
            when:
            def projectManager = new ProjectManager("", null, AcademicTitle.NONE, "a.b@c.de", [])

            then:
            thrown(NullPointerException)
        }

        def "missing email name shall raise a NullPointerException"() {
            when:
            def projectManager = new ProjectManager("", "", AcademicTitle.NONE, null, [])

            then:
            thrown(NullPointerException)
        }

        def "missing affiliation list shall cause the projectManager to contain an empty list"() {
            when:
            def projectManager = new ProjectManager("", "", AcademicTitle.NONE, "a.b@c.de", null)
            then:
            projectManager.affiliations != null
            projectManager.affiliations.isEmpty()
        }
    }
