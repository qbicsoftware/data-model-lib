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

}
