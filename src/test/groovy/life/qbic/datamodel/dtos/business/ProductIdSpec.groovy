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
        then: "no exceptions occur and the product is not null"
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

        expect:
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
        new ProductId.Builder("C",1).build()  |   new ProductId.Builder("B",1).build()   |   new ProductId.Builder("A",1).build()
        new ProductId.Builder("CCC",1).build()  |   new ProductId.Builder("CC",1).build()   |   new ProductId.Builder("C",1).build()
        new ProductId.Builder("A",3).build()  |   new ProductId.Builder("A",2).build()   |   new ProductId.Builder("A",0).build()
    }


    @Unroll
    def "compareTo is symmetric: sgn(x.compareTo(y)) = -sgn(y.compareTo(x)) for x=#x and y=#y"() {
        expect: "sgn(#x.compareTo(#y)) = -sgn(#y.compareTo(#x))"
        Integer.signum(x.compareTo(y)) == -Integer.signum(y.compareTo(x))
        where:
        x   |   y
        new ProductId.Builder("A",1).build()  |   new ProductId.Builder("B",1).build()
        new ProductId.Builder("B",1).build()  |   new ProductId.Builder("A",1).build()
        new ProductId.Builder("A",1).build()  |   new ProductId.Builder("A",1).build()
        new ProductId.Builder("A",1).build()  |   new ProductId.Builder("A",42).build()
        new ProductId.Builder("A",42).build()  |   new ProductId.Builder("A",1).build()
    }

    @Unroll
    def "compareTo is reflexive: #productId equals itself"() {
        when:
        int result = productId.compareTo(productId)
        then:
        result == 0
        productId.equals(productId)
        where:
        productId << [new ProductId.Builder("A", 1).build(), new ProductId.Builder("ZA", 42).build()]
    }

    @Unroll
    def "compareTo #x <=> #y = #expectedResult"() {
        when:
        int result = x <=> y
        then:
        result == expectedResult

        where:
        x                                      | y                                       | expectedResult
        new ProductId.Builder("A", 1).build()  | new ProductId.Builder("B", 1).build()   | -1
        new ProductId.Builder("B", 1).build()  | new ProductId.Builder("A", 1).build()   | 1
        new ProductId.Builder("A", 1).build()  | new ProductId.Builder("A", 1).build()   | 0
        new ProductId.Builder("A", 1).build()  | new ProductId.Builder("A", 42).build()  | -1
        new ProductId.Builder("A", 42).build() | new ProductId.Builder("A", 1).build()   | 1
        new ProductId.Builder("A", 1).build()  | new ProductId.Builder("B", 0).build()   | -1
        new ProductId.Builder("Z", 42).build() | new ProductId.Builder("A", 100).build() | 1

    }

    def "Valid ProductId String can be converted to ProductId"() {
        when:
        ProductId productId = ProductId.from(validProductIdString)
        then:
        validProductId == productId

        where:
        validProductIdString | validProductId
        "SE_1"               | new ProductId.Builder("SE", 1).build()
        "PM_2"               | new ProductId.Builder("PM", 2).build()
        "PB_3"               | new ProductId.Builder("PB", 3).build()
        "SB_4"               | new ProductId.Builder("SB", 4).build()
        "DS_5"               | new ProductId.Builder("DS", 5).build()
        "PR_6"               | new ProductId.Builder("PR", 6).build()
        "ME_7"               | new ProductId.Builder("ME", 7).build()
        "EXT_8"              | new ProductId.Builder("EXT", 8).build()
    }

    def "ProductId String with invalid number will return NumberFormatException"() {
        when:
        ProductId.from(inValidProductIdString)
        then:
        thrown(NumberFormatException)
        where:
        inValidProductIdString | _
        "SE_1.5"               | _
        "PM_Z"                 | _
        "PB_ARG"               | _
        "SB_1,4"               | _
        "DS_1,A"               | _
        "PR_A_5"               | _
        "ME_A-0"               | _
        "EXT_D/0"              | _
    }

    def "ProductId String with invalid productType will return IllegalArgumentException"() {
        when:
        ProductId.from(inValidProductIdString)
        then:
        thrown(IllegalArgumentException)
        where:
        inValidProductIdString | _
        "Dane_1"               | _
        "Mary_2"               | _
        "Fred_3"               | _
        "A:P_4"                | _
        "101_5"                | _
        "Wat_6"                | _
        "Decibel_7"            | _
        "Why_8"                | _
    }

    def "ProductId String with invalid Format will return IllegalArgumentException"() {
        when:
        ProductId.from(inValidProductIdString)
        then:
        thrown(IllegalArgumentException)
        where:
        inValidProductIdString | _
        "SE1"                  | _
        "PM2"                  | _
        "PB3"                  | _
        "SB4"                  | _
        "DS5"                  | _
        "PR&6"                 | _
        "ME-7"                 | _
        "EXT/8"                | _
    }

}
