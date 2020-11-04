package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.accounting.Offer
import life.qbic.datamodel.dtos.general.Person
import spock.lang.Specification

class OfferSpec extends Specification{

    AcademicTitleFactory academicTitleFactory = new AcademicTitleFactory()
    Person person = new Person("", "", "", academicTitleFactory.getForString("None"), "", []) {}
    Date date = new Date(1000, 10, 10)

    def "Check offer generation without providing modificationDate, expirationDate, totalPrice and identifier"() {
        when:
        def offerMinimal = new Offer(person, person, "", "", [])

        then:
        offerMinimal.totalPrice == 0
        offerMinimal.expirationDate == null
        offerMinimal.modificationDate == null
    }

    def "Check offer generation without providing a totalPrice and identifier"() {
        when:
        def offerReduced = new Offer(date, date, person, person, "", "", [])
        then:
        offerReduced.totalPrice == 0
        offerReduced.identifier == null
    }

    def "Check offer generation with all properties provided "() {
        when:
        OfferId offerId = new OfferId("ab", "cd", 1)
        def offerFull = new Offer(date, date, person, person, "", "", [], 1, offerId)
        then:
        offerFull.totalPrice == 1
        offerFull.identifier != null
    }

}
