package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductId

/**
 * Describes a product for primary bioinformatic analysis services.
 *
 * @since 1.12.0
 */
@EqualsAndHashCode(callSuper = true)
class PrimaryAnalysis extends AtomicProduct {
  /**
   * Basic product constructor.
   *
   * Checks that all passed arguments are not null.
   *
   * @param name The name of the product.
   * @param description The description of what the product is about.
   * @param unitPrice The price in € per unit
   * @param unit The product unit
   * @param runningNumber Number used in conjunction with ProductType{@link life.qbic.datamodel.dtos.business.services.ProductType} to identify product
   * @deprecated since 2.5.0
   */
  @Deprecated
  PrimaryAnalysis(String name, String description, double unitPrice, ProductUnit unit, String runningNumber) {
    super(name, description, unitPrice, unit, new ProductId(ProductType.PRIMARY_BIOINFO.toString(), runningNumber))
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
   * @param runningNumber Number used in conjunction with ProductType{@link life.qbic.datamodel.dtos.business.services.ProductType} to identify product
   */
  PrimaryAnalysis(String name, String description, double unitPrice, ProductUnit unit, long runningNumber) {
    super(name, description, unitPrice, unit, new ProductId.Builder(ProductType.PRIMARY_BIOINFO.toString(), runningNumber).build())
  }
}
