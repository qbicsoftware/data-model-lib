package life.qbic.datamodel.dtos.business

import spock.lang.Specification


/**
 * Simple tests for the Affiliation Category Enum and its methods.
 *
 * @since 1.12.0
 */
class AffiliationCategorySpec extends Specification{

    def "Established Enum properties can be accessed with the getValue and toString Methods "() {
        when:
        AffiliationCategory affiliationCategory = AffiliationCategory.INTERNAL

        then:
        affiliationCategory.getValue() == "internal"
        affiliationCategory.toString() == "internal"
    }




}
