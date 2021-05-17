package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * <h1>Tests for ProductId creation</h1>
 *
 * <p>This specification tests that the product Id can be build</p>
 *
 * @since 2.5.0
 */
class ProductIdSpec extends Specification {

    def "builder works for String long"() {
        given:
        ProductId.Builder builder = new ProductId.Builder(productType, uniqueId)
        when: "a productId is build"
        ProductId productId = builder.build()
        then: "no exceptions occure and the product is not null"
        noExceptionThrown()
        productId instanceof ProductId
        and: "the uniqueId is greater or equal to 0"
        productId.uniqueId >= 0

        where: "the constructor parameters are"
        productType | uniqueId
        "test" | 1234
        "test2" | 0
    }

    def "builder works for String String"() {
        given:
        ProductId.Builder builder = new ProductId.Builder(productType, uniqueId)
        when: "a productId is build"
        ProductId productId = builder.build()
        then: "no exceptions occure and the product is not null"
        noExceptionThrown()
        productId instanceof ProductId
        and: "the uniqueId is greater or equal to 0"
        productId.uniqueId >= 0

        where: "the constructor parameters are"
        productType | uniqueId
        "test" | "1234"
        "test2" | "0"
    }

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
