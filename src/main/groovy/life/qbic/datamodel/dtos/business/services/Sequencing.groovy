package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductId

/**
 * Describes a product for sequencing services.
 *
 * @since 1.12.0
 */
@EqualsAndHashCode(callSuper = true)
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
   * @param productId The product identifier
   */

  Sequencing(String name, String description, double unitPrice, ProductUnit unit, String identifier) {
    super(name, description, unitPrice, unit, new ProductId(ProductType.SEQUENCING.toString(), identifier))
  }
}
