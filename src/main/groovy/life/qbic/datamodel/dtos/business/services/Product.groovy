package life.qbic.datamodel.dtos.business.services

/**
 * Holds information about a simple QBiC service product.
 *
 * This class is abstract and needs to be subclassed in order
 * to create in instance of it.
 *
 * @since 1.12.0
 */
abstract class Product {

  /**
   * Some text describing what the the product providing.
   */
  private final String description

  /**
   * A descriptive product name.
   */
  private final String productName

  /**
   * The unit price in €/unit.
   */
  private final double unitPrice

  /**
   * The unit of the product.
   */
  private final ProductUnit unit

  /**
   * Basic product constructor.
   *
   * Checks that all passed arguments are not null.
   *
   * @param name The name of the product.
   * @param description The description of what the product is about.
   * @param unitPrice The price in € per unit
   * @param unit The product unit
   */
  Product(String name, String description, double unitPrice, ProductUnit unit) {
    this.productName = Objects.requireNonNull(name, "Name must not be null")
    this.description = Objects.requireNonNull(description, "Description must not be null")
    this.unitPrice = Objects.requireNonNull(unitPrice, "Unit price must not be null")
    this.unit = Objects.requireNonNull(unit, "Unit must not be null")
  }

}
