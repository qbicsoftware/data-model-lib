package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.business.CostEstimate
import spock.lang.Specification

/**
 * Simple test class to assert the correct behaviour of the CostEstimate Builder.
 *
 * @since 1.12.0
 */

class CostEstimateSpec extends Specification {

    def "Fluent API shall create a CustomerEstimate object"() {

        given:
        Date date = new Date(1000, 10, 10)
        AcademicTitleFactory academicTitleFactory = new AcademicTitleFactory()
        Customer customer = new Customer.Builder("Max", "Mustermann", "max@example.com").build()
        ProjectManager projectManager = new ProjectManager.Builder("Max", "Mustermann",
                "max@example.com").build()
        Double price = 1000
        CostEstimateId costEstimateId = new CostEstimateId("ab", "cd", 1)
        Affiliation selectedAffiliation = new Affiliation.Builder("Universität Tübingen",
                "Auf der Morgenstelle 10",
                "72076",
                "Tübingen")
                .build()

        when:
        CostEstimate costEstimate =
                new CostEstimate.Builder(date,
                        date,
                        customer,
                        projectManager,
                        "Cartoon Series",
                        "Archer",
                        [],
                        price,
                        costEstimateId,
                        selectedAffiliation)
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
}
