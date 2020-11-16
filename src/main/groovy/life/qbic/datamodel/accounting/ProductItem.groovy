package life.qbic.datamodel.accounting

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.services.Product

/**
 * An item with associated costs and quantity
 *
 * Cost items describe services and their price. They are the building blocks of invoices and offers.
 * The unit price is always provided in euros.
 * @since: 1.9.0
 * @author: Tobias Koch
 *
 */
@EqualsAndHashCode
class ProductItem {

    /**
     * Describes the amount of a given item
     */
    final double quantity

    /**
     * Describes the which product type of the current item
     */
    final Product product

    ProductItem(double quantity, Product product) {
        this.quantity = quantity
        this.product = product
    }

}

