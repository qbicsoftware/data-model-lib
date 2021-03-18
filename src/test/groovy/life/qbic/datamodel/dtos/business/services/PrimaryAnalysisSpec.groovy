package life.qbic.datamodel.dtos.business.services

import spock.lang.Specification

/**
 * <class short description - 1 Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <versiontag>
 */
class PrimaryAnalysisSpec extends Specification{

    def "Equality check shall return false for different primary analysis service products"() {
        given: "two different products"
        PrimaryAnalysis productOne = new PrimaryAnalysis("One", "", 0.0, ProductUnit.PER_GIGABYTE, "1")
        PrimaryAnalysis productTwo = new PrimaryAnalysis("Two", "", 0.0, ProductUnit.PER_GIGABYTE,
                "1")

        when: "we compare these two"
        def isEqualOneTwo = productOne.equals(productTwo)

        then: "the should be not equal"
        !isEqualOneTwo
    }

    def "Equality check shall return true for same primary analysis service products"() {
        given: "two identical products, but two instances"
        PrimaryAnalysis productOne = new PrimaryAnalysis("One", "", 0.0, ProductUnit.PER_GIGABYTE, "1")
        PrimaryAnalysis productCopy = new PrimaryAnalysis("One", "", 0.0, ProductUnit.PER_GIGABYTE,
                "1")

        when: "we compare them"
        def isEqual = productOne.equals(productCopy)

        then: "they should be evaluated as equal"
        isEqual
    }
}
