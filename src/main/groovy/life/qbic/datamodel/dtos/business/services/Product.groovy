package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductId

/**
 * Holds information about a simple QBiC service product.
 *
 * This class is abstract and needs to be subclassed in order
 * to create in instance of it.
 *
 * @since 1.12.0
 */
@EqualsAndHashCode
abstract class Product {

  /**
   * Some text describing what the the product providing.
   */
  final String description

  /**
   * A descriptive product name.
   */
  final String productName

  /**
   * The unit price in €/unit.
   */
  final double unitPrice

  /**
   * The currency of the price
   */
  final Currency currency

  /**
   * The unit of the product.
   */
  final ProductUnit unit

  /**
   * The Id of the product.
   */
  final ProductId productId

  /**
   * Basic product constructor.
   *
   * Checks that all passed arguments except productId are not null.
   *
   * @param name The name of the product.
   * @param description The description of what the product is about.
   * @param unitPrice The price in € per unit
   * @param unit The product unit
   * @param productId The Id of the product
   */
  Product(String name, String description, double unitPrice, ProductUnit unit, ProductId productId) {
    this.productName = Objects.requireNonNull(name, "Name must not be null")
    this.description = Objects.requireNonNull(description, "Description must not be null")
    this.unitPrice = Objects.requireNonNull(unitPrice, "Unit price must not be null")
    this.unit = Objects.requireNonNull(unit, "Unit must not be null")
    this.productId = Objects.requireNonNull(productId, "ProductId must not be null")
    //currency is on default in euro
    this.currency = Currency.getInstance(Locale.GERMANY)

  }
}
