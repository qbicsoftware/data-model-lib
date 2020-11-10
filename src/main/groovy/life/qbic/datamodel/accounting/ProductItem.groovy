package life.qbic.datamodel.accounting

import groovy.transform.EqualsAndHashCode

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

    /**
     * The name of the item
     */
    final String NAME

    /**
     * A short description of what the item comprises
     */
    final String DESCRIPTION

    ProductItem(String NAME, String DESCRIPTION, Product product) {
        this.NAME = NAME
        this.DESCRIPTION = DESCRIPTION
        this.product = product
    }

    ProductItem(double quantity, String NAME, String DESCRIPTION, Product product) {
        this.quantity = quantity
        this.NAME = NAME
        this.DESCRIPTION = DESCRIPTION
        this.product = product
    }

}

