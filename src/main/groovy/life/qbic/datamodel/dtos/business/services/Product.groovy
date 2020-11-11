package life.qbic.datamodel.dtos.business.services

/**
 * <class short description - 1 Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since 1.12.0
 */
class Product {

  private final String description

  private final String productName

  private final double unitPrice

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
