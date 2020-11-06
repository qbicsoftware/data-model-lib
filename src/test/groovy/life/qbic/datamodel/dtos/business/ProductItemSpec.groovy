package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.accounting.Product
import life.qbic.datamodel.accounting.ProductCategory
import life.qbic.datamodel.accounting.ProductItem
import spock.lang.Specification

/**
 * Simple tests for the ProductItem dto class
 *
 * @since 1.12.0
 */
class ProductItemSpec extends Specification{

    Product product = new Product(ProductCategory.PRIMARY_BIOINFO, null, "", "", 0, "", false)

    def "ProductItem shall store and provide the given properties: name, description and product"() {
        when:
        def productItem = new ProductItem("Pandoras Box", "Don't open it!", product)

        then:
        productItem.NAME == "Pandoras Box"
        productItem.DESCRIPTION == "Don't open it!"
        productItem.product == product
    }

    def "ProductItem shall store and provide the given properties: quantity, name, description and product"() {
        when:
        def productItem = new ProductItem(1, "Pandoras Box", "Don't open it!", product)

        then:
        productItem.quantity == 1
        productItem.NAME == "Pandoras Box"
        productItem.DESCRIPTION == "Don't open it!"
        productItem.product == product
    }


}
