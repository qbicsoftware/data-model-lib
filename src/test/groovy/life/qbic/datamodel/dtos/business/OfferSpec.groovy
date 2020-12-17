package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.business.services.ProductUnit
import life.qbic.datamodel.dtos.business.services.Sequencing
import spock.lang.Specification

/**
 * Simple test class to assert the correct behaviour of the Offer Builder.
 *
 * @since 1.12.0
 */

class OfferSpec extends Specification {


    Date date = new Date(1000, 10, 10)
    Customer customer = new Customer.Builder("Max", "Mustermann", "").build()
    ProjectManager projectManager = new ProjectManager.Builder("Max", "Mustermann", "").build()
    Affiliation selectedAffiliation = new Affiliation.Builder("Universität Tübingen",
            "Auf der Morgenstelle 10",
            "72076",
            "Tübingen")
            .build()

    def "Fluent API shall create an Offer object"() {

        given:
        double price = 1000
        double vat = 0.19
        double overhead = 0.2
        double net = 900
        OfferId offerId = new OfferId("ab", "cd", 1)
        ProductItem item = new ProductItem(2,new Sequencing("DNA Sequencing","This is a sequencing package",1.50, ProductUnit.PER_SAMPLE))

        when:
        Offer testOffer =
                new Offer.Builder(customer, projectManager, "Archer", "Cartoon Series", selectedAffiliation)
                        .modificationDate(date).expirationDate(date).totalPrice(price).identifier(offerId).taxes(vat).overheads(overhead).netPrice(net).items([item])
                        .build()

        then:
        testOffer.getModificationDate() == date
        testOffer.getExpirationDate() == date
        testOffer.getCustomer() == customer
        testOffer.getProjectManager() == projectManager
        testOffer.getProjectTitle() == "Archer"
        testOffer.getProjectDescription() == "Cartoon Series"
        testOffer.getTaxes() == vat
        testOffer.getOverheads() == overhead
        testOffer.getNetPrice() == net
        testOffer.getItems() == [item]
        testOffer.getTotalPrice() == price
        testOffer.getIdentifier() == offerId
        testOffer.getSelectedCustomerAffiliation() == selectedAffiliation
        testOffer.currency.toString() == "EUR"
    }

    def "Missing optional Field definitions shall haven null values in an Offer object"() {

        given:
        OfferId offerId = new OfferId("ab", "cd", 1)

        when:
        Offer testOffer =
                new Offer.Builder(customer, projectManager, "Archer", "Cartoon Series", selectedAffiliation)
                        .build()

        then:
        testOffer.getModificationDate() == null
        testOffer.getExpirationDate() == null
        testOffer.getCustomer() == customer
        testOffer.getProjectManager() == projectManager
        testOffer.getProjectTitle() == "Archer"
        testOffer.getProjectDescription() == "Cartoon Series"
        testOffer.getItems() == []
        testOffer.getTotalPrice() == 0
        testOffer.getIdentifier() == null
        testOffer.getSelectedCustomerAffiliation() == selectedAffiliation
    }

}
