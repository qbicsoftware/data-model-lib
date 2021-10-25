package life.qbic.datamodel.dtos.business.services

import life.qbic.datamodel.dtos.EnumFactory

/**
 * This class provides functionality for enum key retrieval
 *
 * This class retrieves the corresponding ProductType for a given String
 *
 * @see life.qbic.datamodel.dtos.business.services.ProductType
 * @since: 2.14.0
 */
class ProductTypeFactory extends EnumFactory<ProductType>{

    /**
     * This method returns the enum with the provided String value.
     *
     * @throws IllegalArgumentException in case the String could not be mapped
     * @param value the String corresponding to a key of the enum
     * @return the enum key for the provided string value
     */
    @Override
    ProductType getForString(String value) {
        ProductType desiredKey
        desiredKey = ProductType.values().find { (it.value == value.trim()) }
        if (!desiredKey) {
            throw new IllegalArgumentException("Invalid value '$value' for ${ProductType.getSimpleName()}")
        }
        return desiredKey
    }
}