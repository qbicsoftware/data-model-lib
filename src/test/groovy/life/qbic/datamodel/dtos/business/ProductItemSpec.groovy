package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.business.facilities.Facility
import life.qbic.datamodel.dtos.business.services.DataStorage
import life.qbic.datamodel.dtos.business.services.ExternalServiceProduct
import life.qbic.datamodel.dtos.business.services.MetabolomicAnalysis
import life.qbic.datamodel.dtos.business.services.PrimaryAnalysis
import life.qbic.datamodel.dtos.business.services.Product
import life.qbic.datamodel.dtos.business.services.ProductUnit
import life.qbic.datamodel.dtos.business.services.ProjectManagement
import life.qbic.datamodel.dtos.business.services.ProteomicAnalysis
import life.qbic.datamodel.dtos.business.services.SecondaryAnalysis
import life.qbic.datamodel.dtos.business.services.Sequencing
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Simple tests for the ProductItem dto class
 *
 * @since 1.12.0
 */
class ProductItemSpec extends Specification {


    def "ProductItem shall store and provide the given properties: name, description and product"() {

        when:
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 3.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC)

        def productItem = new ProductItem(3.0, product)

        then:
        productItem.product == product
    }

    def "Equal ProductItems shall be equal"() {

        given: "two product item contents"
        def referenceProduct = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 3.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC)
        Double referenceQuantity = 1.0
        Double referenceTotalPrice = 3.0
        Double referenceQuantityDiscount = 0.0

        when: "two product items are created from the same content"
        ProductItem item1 = new ProductItem(referenceQuantity, referenceProduct, referenceTotalPrice, referenceQuantityDiscount)
        ProductItem item2 = new ProductItem(referenceQuantity, referenceProduct, referenceTotalPrice, referenceQuantityDiscount)

        ProductItem item3 = new ProductItem(referenceQuantity, referenceProduct)
        ProductItem item4 = new ProductItem(referenceQuantity, referenceProduct)

        then: "the product items are equal"
        item1 == item2
        item3 == item4
    }

    @Unroll
    def "Different ProductItems shall be different for property #differentProperty"() {

        given: "a reference product item and a different product"
        def referenceProduct = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 3.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC)
        Double referenceQuantity = 1.0
        Double referenceTotalPrice = 3.0
        Double referenceQuantityDiscount = 0.0

        when: "we create a product item with different information"
        ProductItem reference = new ProductItem(referenceQuantity, referenceProduct, referenceTotalPrice, referenceQuantityDiscount)
        ProductItem differentItem = new ProductItem(quantity, product, totalPrice, quantityDiscount)

        then: "the product items are not equal"
        reference != differentItem

        where: "for every property"
        differentProperty | quantity| product| totalPrice| quantityDiscount
        "quantity" | 1.0 +1 | new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 3.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC) | 3.0 | 0.0
        "product" | 1.0 | new PrimaryAnalysis("Test", "Different description", 1.0, 3.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC) | 3.0 | 0.0
        "totalPrice" | 1.0 | new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 3.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC) | 3.0 +1 | 0.0
        "quantityDiscount" | 1.0 | new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 3.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC) | 3.0 | 0.0 + 1
    }

    def "Products shall be comparable"(){
        when:

        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE, 1)
        Product product2 = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 2.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC)
        Product product3 = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 2.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC)

        then:
        product.currency == product2.currency
        product.description == product2.description
        product.productName == product2.productName
        product.unit == product2.unit
        product.unitPrice != product2.unitPrice
        product2.unitPrice == 0
        product.productId.toString() == product2.productId.toString()

        product3.internalUnitPrice == product2.internalUnitPrice
        product3.externalUnitPrice == product2.externalUnitPrice
        product3.equals(product2)
    }

    def "Product currency is euro"(){
        when:
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 2.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC)

        then:
        product.currency.toString() == "EUR"
        product.currency.displayName == "Euro"
    }

  def "ProductItems allow partial quantities for all services"() {

    when: "ProductItems for all service products can be created"
    ProductItem productItem = new ProductItem(quantity, product, totalPrice, quantityDiscount)

    then: "No exceptions are thrown"
    noExceptionThrown()

    where: "for every service product"
    quantity | internalUnitPrice | product                                                                                                                                                        | totalPrice                   | quantityDiscount
    1.1      | 1                 | new Sequencing("Sequencing", "Sequencing description", 1.0, 3.0, ProductUnit.PER_SAMPLE, 1, Facility.QBIC)                                                     | quantity * internalUnitPrice | 0.0
    2.2      | 2                 | new PrimaryAnalysis("Primary Analysis", "Primary Analysis description", 2.0, 4.0, ProductUnit.PER_CYCLE, 2, Facility.QBIC)                                     | quantity * internalUnitPrice | 0.0
    3.3      | 3                 | new SecondaryAnalysis("Secondary Analysis", "Secondary Analysis description", 3.0, 5.0, ProductUnit.PER_DATASET, 3, Facility.QBIC)                             | quantity * internalUnitPrice | 0.0
    4.4      | 4                 | new ProteomicAnalysis("Proteomic Analysis", "Proteomic Analysis description", 4.0, 6.0, ProductUnit.PER_FLOW_CELL, 4, Facility.QBIC)                           | quantity * internalUnitPrice | 0.0
    5.5      | 5                 | new MetabolomicAnalysis("Metabolomic Analysis", "Metabolomic Analysis description", 5.0, 7.0, ProductUnit.PER_100_MICROGRAM_PEPTIDE_CHANNEL, 5, Facility.QBIC) | quantity * internalUnitPrice | 0.0
    6.6      | 6                 | new ProjectManagement("Project Management", "Project Management description", 6.0, 8.0, ProductUnit.PER_HOUR, 6, Facility.QBIC)                                | quantity * internalUnitPrice | 0.0
    7.7      | 7                 | new DataStorage("Data Storage", "Data Storage description", 7.0, 9.0, ProductUnit.PER_GIGABYTE, 7, Facility.QBIC)                                              | quantity * internalUnitPrice | 0.0
    8.8      | 8                 | new ExternalServiceProduct("External Service", "External Service description", 8.0, 10.0, ProductUnit.PER_PROJECT, 8, Facility.CEGAT)                          | quantity * 10                | 0.0
  }
}
