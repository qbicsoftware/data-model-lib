package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Test class to check the offer id performance
 * @since 2.0.0
 */
class OfferIdSpec extends Specification {

    def 'accessing offer id properties shall work'() {
        given:
        def randomPart ="abc"
        def projectPart = "project123"
        def version = "v1"

        when:
        def offerId = new OfferId(projectPart, randomPart, version)

        then:
        offerId.getRandomPart().equals("abc")
    }

    def 'confirm equals method override works as intended'() {
        given: "two offer id instances with the same content"
        OfferId idOne = new OfferId("project", "random", "1")
        OfferId idOther = new OfferId("project", "random", "1")

        when: "we compare them"
        def isEqual = idOne.equals(idOther)

        then: "the comparison shall return true"
        isEqual
    }

    def 'Equality check shall return false, if id conent differs'() {
        given: "two offer id instances with the same content"
        OfferId idOne = new OfferId("project", "random", "1")
        OfferId idOther = new OfferId("project", "random", "2")

        when: "we compare them"
        def isEqual = idOne.equals(idOther)

        then: "the comparison shall return true"
        !isEqual
    }
}
