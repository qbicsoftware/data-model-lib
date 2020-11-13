package life.qbic.datamodel.dtos.business


import spock.lang.Specification

/**
 * Simple test class to assert the correct behaviour of the Offer Builder.
 *
 * @since 1.12.0
 */

class OfferSpec extends Specification {


    Date date = new Date(1000, 10, 10)
    AcademicTitleFactory academicTitleFactory = new AcademicTitleFactory()
    Customer customer = new Customer.Builder("Max", "Mustermann", "").build()
    ProjectManager projectManager = new ProjectManager.Builder("Max", "Mustermann", "").build()

    def "Fluent API shall create an Offer object"() {

        given:
        Double price = 1000
        OfferId offerId = new OfferId("ab", "cd", 1)
        Affiliation selectedAffiliation = new Affiliation.Builder("Universität Tübingen",
                                        "Auf der Morgenstelle 10",
                                        "72076",
                                        "Tübingen")
                                        .build()

        when:
        Offer testOffer =
                new Offer.Builder(date, date, customer, projectManager, "Archer").projectDescription("Cartoon Series").items([]).totalPrice(price).identifier(offerId).selectedCustomerAffiliation(selectedAffiliation).build()

        then:
        testOffer.getModificationDate() == date
        testOffer.getExpirationDate() == date
        testOffer.getCustomer() == customer
        testOffer.getProjectManager() == projectManager
        testOffer.getProjectTitle() == "Archer"
        testOffer.getProjectDescription() == "Cartoon Series"
        testOffer.getItems() == []
        testOffer.getTotalPrice() == price
        testOffer.getIdentifier() == offerId
        testOffer.getSelectedCustomerAffiliation() == selectedAffiliation
    }

    def "Missing optional Field definitions shall have default values in an Offer object"() {

        when:
        Offer testOffer =
                new Offer.Builder(date, date, customer, projectManager, "Gummy Bears").build()

        then:
        testOffer.getModificationDate() == date
        testOffer.getExpirationDate() == date
        testOffer.getCustomer() == customer
        testOffer.getProjectManager() == projectManager
        testOffer.getProjectTitle() == "Gummy Bears"
        testOffer.getProjectDescription() == ""
        testOffer.getItems() == []
        testOffer.getTotalPrice() == -1
        testOffer.getIdentifier() == null
        testOffer.getSelectedCustomerAffiliation() == null
    }

}
