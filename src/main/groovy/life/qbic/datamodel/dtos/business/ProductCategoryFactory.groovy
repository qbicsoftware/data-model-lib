package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.EnumFactory

/**
 * <h1>This class provides functionality for enum key retrieval</h1>
 *
 * <p>This class retrieves the corresponding ProductCategory for a given String</p>
 *
 * @since 2.5.0
 */
class ProductCategoryFactory extends EnumFactory<ProductCategory>{

    /**
     * This method returns the enum with the provided String value.
     *
     * @throws IllegalArgumentException in case the String could not be mapped
     * @param value the String corresponding to a key of the enum
     * @return the enum key for the provided string value
     */
    @Override
    ProductCategory getForString(String value) {
        ProductCategory desiredKey
        desiredKey = ProductCategory.values().find {it.value.equals(value.trim())}
        if (!desiredKey) {
            throw new IllegalArgumentException("Invalid value '$value' for ${ProductCategory.getSimpleName()}")
        }
        return desiredKey
    }

    /**
     * This method returns the enum with the provided String abbreviation.
     *
     * @throws IllegalArgumentException in case the String could not be mapped
     * @param abbreviation the String corresponding to the abbreviation stored in the enum
     * @return the enum key for the provided abbreviation
     */
    ProductCategory getForAbbreviation(String abbreviation) {
        ProductCategory desiredKey
        desiredKey = ProductCategory.values().find {it.abbreviation.equals(abbreviation.trim())}
        if (!desiredKey) {
            throw new IllegalArgumentException("Unknown abbreviation'$abbreviation' for ${ProductCategory.getSimpleName()}")
        }
        return desiredKey
    }
}
