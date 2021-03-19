package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductId

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
   * @param runningNumber Number used in conjunction with ProductType{@link life.qbic.datamodel.dtos.business.services.ProductType} to identify product
   */
  DataStorage(String name, String description, double unitPrice, ProductUnit unit, String runningNumber) {
    super(name, description, unitPrice, unit, new ProductId(ProductType.DATA_STORAGE.toString(), runningNumber))
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
  DataStorage(String name, String description, double unitPrice, ProductUnit unit, long runningNumber) {
    super(name, description, unitPrice, unit, new ProductId.Builder(ProductType.DATA_STORAGE.toString(), runningNumber).build())
  }
}
