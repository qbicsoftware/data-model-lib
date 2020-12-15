package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode

/**
 * Describes a product type that can only have positive natural unit multipliers (N={0,1...,inf+})
 *
 * An example for an AtomicProduct is a sample sequencing service product. You can only offer
 * sequencing for 1,2,.. samples, not 1.4 samples.
 *
 * @since 1.12.0
 */
@EqualsAndHashCode(callSuper = true)
class AtomicProduct extends Product {
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
  AtomicProduct(String name, String description, double unitPrice, ProductUnit unit) {
    super(name, description, unitPrice, unit)
  }
}
