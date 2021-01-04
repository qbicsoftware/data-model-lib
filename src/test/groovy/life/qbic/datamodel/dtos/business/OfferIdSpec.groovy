package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * <class short description - 1 Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <versiontag>
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
