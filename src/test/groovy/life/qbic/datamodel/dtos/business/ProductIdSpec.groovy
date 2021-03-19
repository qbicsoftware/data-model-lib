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
}
