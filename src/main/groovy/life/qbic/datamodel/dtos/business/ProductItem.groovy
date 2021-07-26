package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.services.Product

/**
 * An item with associated costs and quantity
 *
 * Product items describe services and their price. They are the building blocks of invoices and offers.
 * The unit price is always provided in euros.
 * @since: 1.9.0
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
     * Describes the total price of an item based on the quantity and unit price of a product
     */
    final double totalPrice

    /**
     * Describe the total discount price for a product (based on the quantity)
     */
    final double quantityDiscount

    /**
     *
     * @param quantity The quantity of a product
     * @param product The product for which an item is created
     *
     * @deprecated 2.11.0
     */
    @Deprecated
    ProductItem(double quantity, Product product) {
        this.quantity = quantity
        this.product = product
        this.totalPrice = 0
        this.quantityDiscount = 0
    }

    ProductItem(double quantity, Product product, double totalPrice, double quantityDiscount) {
        this.quantity = quantity
        this.product = product
        this.totalPrice = totalPrice
        this.quantityDiscount = quantityDiscount
    }



}
