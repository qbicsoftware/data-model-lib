package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductId
import life.qbic.datamodel.dtos.business.facilities.Facility

/**
 * Describes a product type that can have positive rational unit multipliers (N={0,1...,inf+})
 *
 * An example for an PartialProduct is a sample data storage service product. You can offer
 * multiple of this product and express the quantities as i.e. 1.5 * 1 Terabyte (100€/Tb) => 1.5
 * Terabyte with 150€ item cost sum.
 *
 * @since 1.12.0
 */
@EqualsAndHashCode(callSuper = true)
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
   * @param productId The product identifier
   *
   * @deprecated 2.11.0
   */
  @Deprecated
  PartialProduct(String name, String description, double unitPrice, ProductUnit unit, ProductId productId) {
    super(name, description, unitPrice, unit, productId)
  }

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
   * @param serviceProvider The facility providing the service product
   *
   * @since 2.11.0
   */
  PartialProduct(String name, String description, double internalUnitPrice, double externalUnitPrice, ProductUnit unit, ProductId productId, Facility serviceProvider) {
    super(name, description, internalUnitPrice, externalUnitPrice, unit, productId, serviceProvider)
  }
}
