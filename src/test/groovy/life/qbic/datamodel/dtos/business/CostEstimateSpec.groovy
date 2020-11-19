package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Simple test class to assert the correct behaviour of the CostEstimate Builder.
 *
 * @since 1.12.0
 */

class CostEstimateSpec extends Specification {

    Date date = new Date(1000, 10, 10)
    Customer customer = new Customer.Builder("Max", "Mustermann", "").build()
    ProjectManager projectManager = new ProjectManager.Builder("Max", "Mustermann", "").build()
    Affiliation selectedAffiliation = new Affiliation.Builder("Universität Tübingen",
            "Auf der Morgenstelle 10",
            "72076",
            "Tübingen")
            .build()

    def "Fluent API shall create a CustomerEstimate object"() {

        given:
        Double price = 1000
        CostEstimateId costEstimateId = new CostEstimateId("ab", "cd", 1)

        when:
        CostEstimate costEstimate =
                new CostEstimate.Builder(customer, projectManager, "Archer", "Cartoon Series", [], selectedAffiliation)
                        .modificationDate(date).expirationDate(date).totalPrice(price).identifier(costEstimateId)
                        .build()

        then:
        costEstimate.getModificationDate() == date
        costEstimate.getExpirationDate() == date
        costEstimate.getCustomer() == customer
        costEstimate.getProjectManager() == projectManager
        costEstimate.getProjectDescription() == "Cartoon Series"
        costEstimate.getProjectTitle() == "Archer"
        costEstimate.getItems() == []
        costEstimate.getTotalPrice() == price
        costEstimate.getIdentifier() == costEstimateId
        costEstimate.getSelectedCustomerAffiliation() == selectedAffiliation
    }

    def "Missing optional Field definitions shall haven null values in a CostEstimate object"() {

        given:
        CostEstimateId costEstimateId = new CostEstimateId("ab", "cd", 1)

        when:
        Offer testOffer =
                new Offer.Builder(customer, projectManager, "Archer", "Cartoon Series", [], selectedAffiliation).build()

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
