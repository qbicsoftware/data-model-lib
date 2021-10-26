package life.qbic.datamodel.dtos.business.services

import spock.lang.Specification

/**
 * <h1>Tests the ProductTypeFactory</h1>
 *
 * @since 2.14.0
 * @see ProductTypeFactory
 */
class ProductTypeFactorySpec extends Specification {
    def "GetForString works for all values"() {
        setup:
        ProductTypeFactory factory = new ProductTypeFactory()
        when:
        ProductType result = factory.getForString(testValue)
        then:
        result == expectedValue
        where:
        testValue | expectedValue
        "SE"      | ProductType.SEQUENCING
        "PM"      | ProductType.PROJECT_MANAGEMENT
        "PB"      | ProductType.PRIMARY_BIOINFO
        "SB"      | ProductType.SECONDARY_BIOINFO
        "DS"      | ProductType.DATA_STORAGE
        "PR"      | ProductType.PROTEOMIC
        "ME"      | ProductType.METABOLOMIC
        "EXT"     | ProductType.EXTERNAL_SERVICE
    }

    def "GetForString throws IllegalArgument on unknown String"() {
        setup:
        ProductTypeFactory factory = new ProductTypeFactory()
        when:
        ProductType result = factory.getForString(testValue)
        then:
        thrown IllegalArgumentException
        where:
        testValue | expectedValue
        "se"      | ProductType.SEQUENCING
        "pm"      | ProductType.PROJECT_MANAGEMENT
        "pb"      | ProductType.PRIMARY_BIOINFO
        "sb"      | ProductType.SECONDARY_BIOINFO
        "ds"      | ProductType.DATA_STORAGE
        "pr"      | ProductType.PROTEOMIC
        "me"      | ProductType.METABOLOMIC
        "ext"     | ProductType.EXTERNAL_SERVICE
    }
}
