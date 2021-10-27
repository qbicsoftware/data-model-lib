package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductCategory
import life.qbic.datamodel.dtos.business.ProductId
import life.qbic.datamodel.dtos.business.facilities.Facility

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
   * @param runningNumber Number used in conjunction with {@link ProductCategory} to identify product
   * @deprecated 2.5.0
   */
  @Deprecated
  Sequencing(String name, String description, double unitPrice, ProductUnit unit, String runningNumber) {
    super(name, description, unitPrice, unit, new ProductId(ProductCategory.SEQUENCING.getAbbreviation(), runningNumber))
  }

  /**
   * Basic product constructor.
   *
   * Checks that all passed arguments are not null.
   *
   * @param name The name of the product.
   * @param description The description of what the product is about.
   * @param unitPrice The price in € per unit
   * @param unit The product unit
   * @param runningNumber Number used in conjunction with {@link ProductCategory} to identify product
   *
   * @deprecated 2.11.0
   */
  @Deprecated
  Sequencing(String name, String description, double unitPrice, ProductUnit unit, long runningNumber) {
    super(name, description, unitPrice, unit, new ProductId.Builder(ProductCategory.SEQUENCING.getAbbreviation(), runningNumber).build())
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
   * @param runningNumber Number used in conjunction with {@link ProductCategory} to identify product
   * @param serviceProvider The facility providing the service product
   *
   * @since 2.11.0
   */
  Sequencing(String name, String description, double internalUnitPrice, double externalUnitPrice, ProductUnit unit, long runningNumber, Facility serviceProvider) {
    super(name, description, internalUnitPrice, externalUnitPrice, unit, new ProductId.Builder(ProductCategory.SEQUENCING.getAbbreviation(), runningNumber).build(), serviceProvider)
  }
}
