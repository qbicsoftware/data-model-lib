package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductCategory
import life.qbic.datamodel.dtos.business.ProductId
import life.qbic.datamodel.dtos.business.facilities.Facility

/**
 * Describes a product for project management services.
 *
 * @since 1.12.0
 */
@EqualsAndHashCode(callSuper = true)
class ProjectManagement extends PartialProduct {
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
   * @deprecated since 2.5.0
   */
  @Deprecated
  ProjectManagement(String name, String description, double unitPrice, ProductUnit unit, String runningNumber) {
    super(name, description, unitPrice, unit, new ProductId(ProductCategory.PROJECT_MANAGEMENT.getAbbreviation(), runningNumber))
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
  ProjectManagement(String name, String description, double unitPrice, ProductUnit unit, long runningNumber) {
    super(name, description, unitPrice, unit, new ProductId.Builder(ProductCategory.PROJECT_MANAGEMENT.getAbbreviation(), runningNumber).build())
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
  ProjectManagement(String name, String description, double internalUnitPrice, double externalUnitPrice, ProductUnit unit, long runningNumber, Facility serviceProvider) {
    super(name, description, internalUnitPrice, externalUnitPrice, unit, new ProductId.Builder(ProductCategory.PROJECT_MANAGEMENT.getAbbreviation(), runningNumber).build(), serviceProvider)
  }

  /**
   * Basic product constructor with id
   *
   * Checks that all passed arguments except id are not null.
   * @param id the id of the product
   * @param name The name of the product.
   * @param description The description of what the product is about.
   * @param internalUnitPrice The price in € per unit for internal customers
   * @param externalUnitPrice The price in € per unit for external customers
   * @param unit The product unit
   * @param runningNumber Number used in conjunction with {@link ProductCategory} to identify product
   * @param serviceProvider The facility providing the service product
   *
   * @since 2.17.0
   */
  ProjectManagement(int id, String name, String description, double internalUnitPrice, double externalUnitPrice, ProductUnit unit, long runningNumber, Facility serviceProvider) {
    super(id, name, description, internalUnitPrice, externalUnitPrice, unit, new ProductId.Builder(ProductCategory.PROJECT_MANAGEMENT.getAbbreviation(), runningNumber).build(), serviceProvider)
  }
}
