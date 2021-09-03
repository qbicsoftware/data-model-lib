package life.qbic.datamodel.validation.projectmanagement

import life.qbic.datamodel.validation.ValidationException
import spock.lang.Specification
import spock.lang.Unroll

/**
 * <p>Tests the ProjectCodeValidator</p>
 *
 * @since 2.12.0
 */
class ProjectCodeValidatorSpec extends Specification {
    ProjectCodeValidator validator = new ProjectCodeValidator()

    @Unroll
    def "Accept throws no exception for valid project code: #validProjectCode"() {
        when:
        validator.accept(validProjectCode)
        then:
        noExceptionThrown()
        where:
        validProjectCode << ["QABCD", "QBBBA", "QPPEO", "QQQQQ", "Q0000", "Q00A0"]
    }

    @Unroll
    def "Accept throws ValidationException for invalid project code: #invalidProjectCode"() {
        when:
        validator.accept(invalidProjectCode)
        then:
        thrown(ValidationException)
        where:
        invalidProjectCode << [null, "", "testQABCD", "QABCD0000", "YABCD", "ZABCD", "QZZBA"]
    }
}
