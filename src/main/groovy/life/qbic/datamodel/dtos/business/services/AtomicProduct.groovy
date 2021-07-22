package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductId

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
   * @param internalUnitPrice The price in € per unit for internal customers
   * @param externalUnitPrice The price in € per unit for external customers
   * @param unit The product unit
   * @param productId The product identifier
   */
  AtomicProduct(String name, String description, double internalUnitPrice, double externalUnitPrice, ProductUnit unit, ProductId productId) {
    super(name, description, internalUnitPrice, externalUnitPrice, unit, productId)
  }
}
