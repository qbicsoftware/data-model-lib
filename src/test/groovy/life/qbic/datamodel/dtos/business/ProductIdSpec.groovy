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

    def "Ids are sorted first by their type and then by their unique id"(){
        given:"two ids with different types"
        ProductId productId1 = new ProductId.Builder("DS",1).build()
        ProductId productId2 = new ProductId.Builder("SE",1).build()

        and:"two ids with equal types"
        ProductId productId3 = new ProductId.Builder("DS",1).build()
        ProductId productId4 = new ProductId.Builder("DS",10).build()

        when:
        def res1 = productId1.compareTo(productId2)
        def res2 = productId4.compareTo(productId3)

        then:
        res1 < 0
        res2 > 0
    }

}
