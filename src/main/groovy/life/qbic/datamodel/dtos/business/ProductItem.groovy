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
@EqualsAndHashCode(excludes = ["id"])
class ProductItem {

    /**
     * The database of an id of a ProductItem
     *
     * For example "1"
     */
    final int id

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
     * Stores the latest position on the offer.
     *
     * A negative value indicates no specific position was stored in the item.
     */
    private int offerPosition = -1

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

    ProductItem(int id, double quantity, Product product, double totalPrice, double quantityDiscount) {
        this.id = id
        this.quantity = quantity
        this.product = product
        this.totalPrice = totalPrice
        this.quantityDiscount = quantityDiscount
    }

    /**
     * Sets the position information on the offer the item should be placed
     *
     * A negative value indicates no positional information.
     * @param position a positive value >= 0 indicating a position on the offer
     * @since 2.22.0
     */
    void setOrderPosition(int position) {
        offerPosition = position
    }

    /**
     * The position on the offer.
     *
     * Is negative, if no positional information is available.
     * @return
     * @since 2.22.0
     */
    int offerPosition() {
        return offerPosition
    }


}
