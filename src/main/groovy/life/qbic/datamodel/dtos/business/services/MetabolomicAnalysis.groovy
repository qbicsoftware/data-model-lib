package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductId

/**
 * Describes a product for metabolomic services.
 *
 * @since 2.4.0
 */
@EqualsAndHashCode(callSuper = true)
class MetabolomicAnalysis extends AtomicProduct {
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

    MetabolomicAnalysis(String name, String description, double unitPrice, ProductUnit unit, String runningNumber) {
      super(name, description, unitPrice, unit, new ProductId(ProductType.METABOLOMIC.toString(), runningNumber))
    }
}

