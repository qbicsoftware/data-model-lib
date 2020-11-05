package life.qbic.datamodel.dtos.business


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
        assert testOffer.getModificationDate().equals(date)
        assert testOffer.getExpirationDate().equals(date)
        assert testOffer.getCustomer().equals(customer)
        assert testOffer.getProjectManager().equals(projectManager)
        assert testOffer.getProjectDescription().equals("Cartoon Series")
        assert testOffer.getProjectTitle().equals("Archer")
        assert testOffer.getItems().equals([])
        assert testOffer.getTotalPrice().equals(price)
        assert testOffer.getIdentifier().equals(offerId)
    }

}
