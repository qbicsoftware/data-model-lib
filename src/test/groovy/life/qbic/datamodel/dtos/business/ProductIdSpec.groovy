package life.qbic.datamodel.dtos.business

import spock.lang.Specification
import spock.lang.Unroll

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
        ProductId productId5 = new ProductId.Builder("DS",3).build()

        then:
        productId1.compareTo(productId2) < 0
        productId4.compareTo(productId3) > 0
        productId4.compareTo(productId5) > 0
    }

    @Unroll
    def "compareTo is transitive: (#x > #y and #y > #z) then #x > #z"() {
        when: "x.compareTo(y) > 0 && y.compareTo(z) > 0"
        assert x.compareTo(y) > 0 && y.compareTo(z) > 0
        then: "x.compareTo(y) > 0"
        x.compareTo(z) > 0
        where: "x, y and z are as follows"
        x   |   y   |   z
        10  |   5   |   2
        2   |   1   |   0
        10 |   -20 |   -25
    }


    @Unroll
    def "compareTo is symmetric: sgn(x.compareTo(y)) = -sgn(y.compareTo(x)) for x=#x and y=#y"() {
        expect: "sgn(#x.compareTo(#y)) = -sgn(#y.compareTo(#x))"
        Integer.signum(x.compareTo(y)) == -Integer.signum(y.compareTo(x))
        where:
        x   |   y
        10  |   0
        0   |   2
        3   |   3
    }

    @Unroll
    def "compareTo is reflexive: #productId equals itself"() {
        when:
        int result = productId.compareTo(productId)
        then:
        result == 0
        productId.equals(productId)
        where:
        productId = new ProductId.Builder("DS", 1).build()

    }

    @Unroll
    def "compareTo #x <=> #y = #expectedResult"() {
        when:
        int result = x <=> y
        then:
        result == expectedResult

        where:
        x | y | expectedResult
        1 | 0 | 1
        42 | -0 | 1
        0 | -0 | 0
        0 | 42 | -1
        -10 | -42 | 1
        -3 | -2 | -1
    }


}
