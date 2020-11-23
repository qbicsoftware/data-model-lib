package life.qbic.datamodel.dtos.business.services

/**
 * Describes a product type that can only have positive natural unit multipliers (N={0,1...,inf+})
 *
 * An example for an PartialProduct is a sample data storage service product. You can offer
 * multiple of this product and express the quantities as i.e. 1.5 * 1 Terabyte (100€/Tb) => 1.5
 * Terabyte with 150€ item cost sum.
 *
 * @since 1.12.0
 */
class PartialProduct extends Product {
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
  PartialProduct(String name, String description, double unitPrice, ProductUnit unit) {
    super(name, description, unitPrice, unit)
  }
}
