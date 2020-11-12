package life.qbic.datamodel.dtos.business.services

/**
 * Describes a product for sequencing services.
 *
 * @since 1.12.0
 */
class Sequencing extends AtomicProduct {
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
  Sequencing(String name, String description, double unitPrice, ProductUnit unit) {
    super(name, description, unitPrice, unit)
  }
}
