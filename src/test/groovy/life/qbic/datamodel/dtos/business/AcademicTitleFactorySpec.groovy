package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * <short description>
 *
 * <detailed description>
 *
 * @since: <versiontag>
 */
class AcademicTitleFactorySpec extends Specification {
    def "GetForString works for correct strings"() {
        when:
        AcademicTitleFactory factory = new AcademicTitleFactory()

        then:
        factory.getForString("None") == AcademicTitle.NONE
        factory.getForString("Dr.") == AcademicTitle.DOCTOR
        factory.getForString("Prof. Dr.") == AcademicTitle.PROFESSOR
    }

    def "GetForString works for correct strings regardless of leading and tailing whitespace"() {
        when:
        AcademicTitleFactory factory = new AcademicTitleFactory()

        then:
        factory.getForString(" None") == AcademicTitle.NONE
        factory.getForString(" Dr.") == AcademicTitle.DOCTOR
        factory.getForString(" Prof. Dr.") == AcademicTitle.PROFESSOR

        factory.getForString("None ") == AcademicTitle.NONE
        factory.getForString("Dr. ") == AcademicTitle.DOCTOR
        factory.getForString("Prof. Dr. ") == AcademicTitle.PROFESSOR

        factory.getForString(" None ") == AcademicTitle.NONE
        factory.getForString(" Dr. ") == AcademicTitle.DOCTOR
        factory.getForString(" Prof. Dr. ") == AcademicTitle.PROFESSOR
    }

    def "GetForString throws IllegalArgumentException for incorrect values"() {
        given:
        AcademicTitleFactory factory = new AcademicTitleFactory()
        when:
        AcademicTitle academicTitle = factory.getForString("ThisIsNotValid")
        then:
        thrown IllegalArgumentException
    }
}
