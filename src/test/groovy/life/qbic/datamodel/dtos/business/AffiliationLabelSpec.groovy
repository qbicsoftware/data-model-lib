package life.qbic.datamodel.dtos.business

import spock.lang.Specification


/**
 * Simple tests for the Affiliation Label Enum and its methods.
 *
 * @since 2.5.0
 */
class AffiliationLabelSpec extends Specification {

    def "Established Enum properties can be accessed with the getValue and toString Methods "() {
        when:
        AffiliationLabel affiliationLabel = AffiliationLabel.NONE

        then:
        affiliationLabel.getValue() == "none"
        affiliationLabel.toString() == "none"
    }
}