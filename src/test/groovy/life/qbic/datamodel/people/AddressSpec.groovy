package life.qbic.datamodel.people

import spock.lang.Specification

class AddressSpec extends Specification {

    def "Default Constructor shall provide empty strings for all properties and a zipcode value of 0"() {
        when:
        def address = new Address()
        then:
        address.getZipCode() == 0
        address.getCountry() == ""
        address.getStreet() == ""
        address.getAffiliation() == ""
    }

    def "SetAffiliation method shall set the provided string to the affiliation property"() {
        when:
        def address = new Address()
        address.setAffiliation("dummyAffiliation")
        then:
        address.getZipCode() == 0
        address.getCountry() == ""
        address.getStreet() == ""
        address.getAffiliation() == "dummyAffiliation"
    }

    def "SetStreet method shall set the provided string to the Street property"() {
        when:
        def address = new Address()
        address.setStreet("dummyStreet")
        then:
        address.getZipCode() == 0
        address.getCountry() == ""
        address.getStreet() == "dummyStreet"
        address.getAffiliation() == ""
    }

    def "SetZipCode method shall set the provided Integer to the ZipCode property"() {
        when:
        def address = new Address()
        address.setZipCode(123456)
        then:
        address.getZipCode() == 123456
        address.getCountry() == ""
        address.getStreet() == ""
        address.getAffiliation() == ""
    }


    def "SetCountry method shall set the provided String to the Country property"() {
        when:
        def address = new Address()
        address.setCountry("dummyCountry")
        then:
        address.getZipCode() == 0
        address.getCountry() == "dummyCountry"
        address.getStreet() == ""
        address.getAffiliation() == ""
    }

}

