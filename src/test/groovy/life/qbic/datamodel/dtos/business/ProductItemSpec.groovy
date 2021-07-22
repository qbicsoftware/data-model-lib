package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.business.services.Product
import life.qbic.datamodel.dtos.business.services.ProductUnit
import life.qbic.datamodel.dtos.business.services.Sequencing
import spock.lang.Specification

/**
 * Simple tests for the ProductItem dto class
 *
 * @since 1.12.0
 */
class ProductItemSpec extends Specification {


    def "ProductItem shall store and provide the given properties: name, description and product"() {

        when:
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 3.0, ProductUnit.PER_SAMPLE, 1)

        def productItem = new ProductItem(3.0, product)

        then:
        productItem.product == product
    }

    def "Products shall be comparable"(){
        when:

        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE, 1)
        Product product2 = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 2.0, ProductUnit.PER_SAMPLE, 1)
        Product product3 = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 2.0, ProductUnit.PER_SAMPLE, 1)

        then:
        product.currency == product2.currency
        product.description == product2.description
        product.productName == product2.productName
        product.unit == product2.unit
        product.unitPrice == product2.unitPrice
        product.productId.toString() == product2.productId.toString()

        product3.internalUnitPrice == product2.internalUnitPrice
        product3.externalUnitPrice == product2.externalUnitPrice
    }

    def "Product currency is euro"(){
        when:
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, 2.0, ProductUnit.PER_SAMPLE, 1)

        then:
        product.currency.toString() == "EUR"
        product.currency.displayName == "Euro"
    }


}
