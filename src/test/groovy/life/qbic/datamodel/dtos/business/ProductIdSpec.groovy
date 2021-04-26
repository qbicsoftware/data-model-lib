package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Tests for the ProductId class
 * @since 2.5.0
 */
class ProductIdSpec extends Specification{

    def "Ids with different content should return false on equality comparison"() {
        given: "Two ids with different content"
        def productIdA = new ProductId("A", "1")
        def productIdB = new ProductId("B", "1")

        when: "we compare them"
        def equal = productIdA == productIdB

        then: "must be false"
        assert !equal
    }

}
