package life.qbic.datamodel.dtos.business.services

import life.qbic.datamodel.dtos.EnumFactory

/**
 * This class provides functionality for enum key retrieval
 *
 * This class retrieves the corresponding ProductUnit for a given String
 *
 * @since 1.12.0
 */
class ProductUnitFactory extends EnumFactory<ProductUnit> {

  /** {@InheritDoc} */
  @Override
  ProductUnit getForString(String value) {
    ProductUnit desiredKey
    desiredKey = ProductUnit.values().find {it.value.equals(value.trim())}
    if (!desiredKey) {
      throw new IllegalArgumentException("Invalid value '$value' for ${ProductUnit.getSimpleName()}")
    }
    return desiredKey
  }
}
