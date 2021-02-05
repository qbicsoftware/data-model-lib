package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.general.Address
import spock.lang.Specification

/**
 * Simple test class to assert the correct behaviour of the Address Builder.
 *
 * @since 1.12.0
 */
class AddressSpec extends Specification{

    def "Fluent API shall create an Address object"() {
        given:
        Affiliation affiliation =
                new Affiliation.Builder("dummyOrganization",
                        "dummyStreet",
                        "012345",
                        "dummyCity")
                        .build()
        when:
        Address testAddress =
                new Address.Builder(affiliation,
                        "dummyStreet",
                         012345,
                        "dummyCountry")
                        .build()

        then:
        testAddress.getAffiliation() == affiliation
        testAddress.getStreet() == "dummyStreet"
        testAddress.getZipCode() == 012345
        testAddress.getCountry() == "dummyCountry"
    }

}
