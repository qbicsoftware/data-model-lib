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
                new Offer.Builder(date, projectManager, offerId).expirationDate(date).customer(customer).projectTitle("Archer").projectDescription("Cartoon Series").items([]).totalPrice(price).selectedCustomerAffiliation(selectedAffiliation).build()

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

    def "Missing optional Field definitions shall haven null values in an Offer object"() {

        given:
        OfferId offerId = new OfferId("ab", "cd", 1)

        when:
        Offer testOffer =
                new Offer.Builder(date, projectManager, offerId).build()
        then:
        testOffer.getModificationDate() == date
        testOffer.getExpirationDate() == null
        testOffer.getCustomer() == null
        testOffer.getProjectManager() == projectManager
        testOffer.getProjectTitle() == null
        testOffer.getProjectDescription() == null
        testOffer.getItems() == []
        testOffer.getTotalPrice() == 0
        testOffer.getIdentifier() == offerId
        testOffer.getSelectedCustomerAffiliation() == null
    }

}
