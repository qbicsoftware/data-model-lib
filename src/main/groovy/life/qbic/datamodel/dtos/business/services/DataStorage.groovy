package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode

/**
 * Describes a product for data storage services.
 *
 * @since 1.12.0
 */
@EqualsAndHashCode(callSuper = true)
class DataStorage extends PartialProduct {
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
  DataStorage(String name, String description, double unitPrice, ProductUnit unit) {
    super(name, description, unitPrice, unit)
  }
}
