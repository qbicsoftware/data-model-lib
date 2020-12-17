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
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE)

        def productItem = new ProductItem(3.0, product)

        then:
        productItem.product == product
    }

    def "Products shall be comparable"(){
        when:
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE)
        Product product2 = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE)

        then:
        product == product2
    }

    def "Product currency is euro"(){
        when:
        Product product = new Sequencing("RNA Sequencing", "This package manages the pricing for all RNA sequencings", 1.0, ProductUnit.PER_SAMPLE)

        then:
        product.currency.symbol == "EUR"
        product.currency.displayName == "Euro"
    }


}
