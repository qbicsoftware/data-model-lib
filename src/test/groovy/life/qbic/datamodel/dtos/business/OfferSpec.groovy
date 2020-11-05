package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.accounting.Product
import life.qbic.datamodel.accounting.ProductItem
import life.qbic.datamodel.dtos.general.Person
import spock.lang.Specification

class OfferSpec extends Specification {


    def "Fluent API shall create an Offer object"() {

        given:
        Date date = new Date(1000, 10, 10)
        AcademicTitleFactory academicTitleFactory = new AcademicTitleFactory()
        Customer customer = new Customer("", "", academicTitleFactory.getForString("None"), "", [])
        Person projectManager = new Person("Project Manager", "Malory", "Archer", academicTitleFactory.getForString("None"), "", []) {
        }
        Double price = 1000
        OfferId offerId = new OfferId("ab", "cd", 1)

        when:
        Offer testOffer =
                new Offer.Builder(date,
                        date,
                        customer,
                        projectManager,
                        "Cartoon Series",
                        "Archer",
                        [],
                        price,
                        offerId)
                        .build()

        then:
        testOffer.getModificationDate() == date
        testOffer.getExpirationDate() == date
        testOffer.getCustomer() == customer
        testOffer.getProjectManager() == projectManager
        testOffer.getProjectDescription() == "Cartoon Series"
        testOffer.getProjectTitle() == "Archer"
        testOffer.getItems() == []
        testOffer.getTotalPrice() == price
        testOffer.getIdentifier() == offerId
    }

}
