package life.qbic.datamodel.dtos.business

import spock.lang.Shared
import spock.lang.Specification

/**
 * Specification on the behaviour of the ProductCategoryFactory
 *
 * @since 2.5.0
 */
class ProductCategoryFactorySpec extends Specification {
    @Shared ProductCategoryFactory productCategoryFactory = new ProductCategoryFactory()

    def "GetForString(java.lang.String) throws IllegalArgumentException if value is not associated"() {
        given: "the provided string being unknown to the enum"
        String request = "This is not known"

        when: "the factory is tasked with returning an enum for the provided String"
        productCategoryFactory.getForString(request)

        then: "an IllegalArgumentException is thrown"
        thrown IllegalArgumentException
    }

    def "GetForString(java.lang.String) returns the correct enums for correct requests"() {
        when: "the factory is tasked to deliver an enum given a string value"
        ProductCategory category = productCategoryFactory.getForString(request)

        then: "the returned ProductCategory is the same as the expected result"
        category == expectedEnum

        where: "all valid combinations are tested"
        request | expectedEnum
        "Sequencing" | ProductCategory.SEQUENCING
        "Project Management" | ProductCategory.PROJECT_MANAGEMENT
        "Primary Bioinformatics" | ProductCategory.PRIMARY_BIOINFO
        "Secondary Bioinformatics" | ProductCategory.SECONDARY_BIOINFO
        "Data Storage" | ProductCategory.DATA_STORAGE
        "Proteomics" | ProductCategory.PROTEOMIC
        "Metabolomics" | ProductCategory.METABOLOMIC
    }

    def "GetForString(java.lang.String) returns the correct enums and ignores whitespace"() {
        when: "the factory is tasked to deliver an enum given a string value"
        ProductCategory category = productCategoryFactory.getForString(request)

        then: "the returned ProductCategory is the same as the expected result"
        category == expectedEnum

        where: "all valid combinations are tested"
        request | expectedEnum
        "Sequencing    " | ProductCategory.SEQUENCING
        "      Project Management" | ProductCategory.PROJECT_MANAGEMENT
        "    Primary Bioinformatics       " | ProductCategory.PRIMARY_BIOINFO
        "\tSecondary Bioinformatics    " | ProductCategory.SECONDARY_BIOINFO
        "\nData Storage\t" | ProductCategory.DATA_STORAGE
        "  Proteomics  " | ProductCategory.PROTEOMIC
        "  Metabolomics  " | ProductCategory.METABOLOMIC
    }
}
