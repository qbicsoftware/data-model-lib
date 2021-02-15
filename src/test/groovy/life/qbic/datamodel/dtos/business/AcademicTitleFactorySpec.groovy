package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Tests for the AcademicTitleFactory
 *
 * @since: 1.12.0
 * @see AcademicTitleFactory
 */
class AcademicTitleFactorySpec extends Specification {
    def "GetForString works for correct strings"() {
        when:
        AcademicTitleFactory factory = new AcademicTitleFactory()

        then:
        factory.getForString("None") == AcademicTitle.NONE
        factory.getForString("Dr.") == AcademicTitle.DOCTOR
        factory.getForString("Prof. Dr.") == AcademicTitle.PROFESSOR
        factory.getForString("PhD") == AcademicTitle.PHD
    }

    def "GetForString works for correct strings regardless of leading and tailing whitespace"() {
        when:
        AcademicTitleFactory factory = new AcademicTitleFactory()

        then:
        factory.getForString(" None") == AcademicTitle.NONE
        factory.getForString(" Dr.") == AcademicTitle.DOCTOR
        factory.getForString(" Prof. Dr.") == AcademicTitle.PROFESSOR
        factory.getForString(" PhD") == AcademicTitle.PHD

        factory.getForString("None ") == AcademicTitle.NONE
        factory.getForString("Dr. ") == AcademicTitle.DOCTOR
        factory.getForString("Prof. Dr. ") == AcademicTitle.PROFESSOR
        factory.getForString("PhD ") == AcademicTitle.PHD

        factory.getForString(" None ") == AcademicTitle.NONE
        factory.getForString(" Dr. ") == AcademicTitle.DOCTOR
        factory.getForString(" Prof. Dr. ") == AcademicTitle.PROFESSOR
        factory.getForString(" PhD ") == AcademicTitle.PHD
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
