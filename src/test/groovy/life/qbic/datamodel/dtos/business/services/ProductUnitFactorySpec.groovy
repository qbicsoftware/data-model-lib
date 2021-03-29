package life.qbic.datamodel.dtos.business.services

import spock.lang.Specification

/**
 * <h1>Tests the ProductUnitFactory</h1>
 *
 * <p><detailed description></p>
 *
 * @since 2.5.0
 */
class ProductUnitFactorySpec extends Specification {
    def "GetForString works for all values"() {
        setup:
        ProductUnitFactory factory = new ProductUnitFactory()
        when:
        ProductUnit result = factory.getForString(testValue)
        then:
        result == expectedValue
        where:
        testValue | expectedValue
        "Gigabyte" | ProductUnit.PER_GIGABYTE
        "Sample" | ProductUnit.PER_SAMPLE
        "Dataset" | ProductUnit.PER_DATASET
        "Hour" | ProductUnit.PER_HOUR
    }

    def "GetForString throws IllegalArgument on unknown String"() {
        setup:
        ProductUnitFactory factory = new ProductUnitFactory()
        when:
        ProductUnit result = factory.getForString(testValue)
        then:
        thrown IllegalArgumentException
        where:
        testValue | expectedValue
        "gigabyte" | ProductUnit.PER_GIGABYTE
        "sample" | ProductUnit.PER_SAMPLE
        "dataset" | ProductUnit.PER_DATASET
        "hour" | ProductUnit.PER_HOUR
    }
}
