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
        ProductId productId = new ProductId("SE", "0")
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE, productId)

        def productItem = new ProductItem(3.0, product)

        then:
        productItem.product == product
    }

    def "Products shall be comparable"(){
        when:
        ProductId productId = new ProductId("SE", "0")
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE, productId)
        Product product2 = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE, productId)

        then:
        product == product2
    }

    def "Product currency is euro"(){
        when:
        ProductId productId = new ProductId("SE", "0")
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE, productId)

        then:
        product.currency.toString() == "EUR"
        product.currency.displayName == "Euro"
    }


}
