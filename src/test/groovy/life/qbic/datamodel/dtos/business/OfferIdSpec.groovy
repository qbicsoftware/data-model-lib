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
        OfferId idOne = new OfferId(conservedPart, randomPart, version)
        OfferId idOther = new OfferId(conservedPart2, randomPart2, version2)

        when: "we compare them"
        def isEqual = idOne.equals(idOther)

        then: "the comparison shall return false"
        !isEqual
        
        where: "constructor arguments differ for all possible fields"
        conservedPart | conservedPart2 | randomPart | randomPart2 | version | version2 
        "project" | "project" | "random" | "random" | "1" | "2"
        "project" | "project" | "random" | "random" | "2" | "1"
        "project" | "project2" | "random" | "random" | "3" | "3"
        "project2" | "project" | "random" | "random" | "3" | "3"
        "project3" | "project3" | "random1" | "random2" | "4" | "4"
        "project3" | "project3" | "random2" | "random1" | "4" | "4"   
        "project3" | "project4" | "random3" | "random4" | "5" | "6"
    }
}
