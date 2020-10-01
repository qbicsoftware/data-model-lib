package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.EnumFactory

/**
 * This class provides functionality for enum key retrieval
 *
 * This class retrieves the corresponding AffiliationCategory for a given String
 *
 * @see AffiliationCategory
 * @since: 1.12.0
 */
class AffiliationCategoryFactory extends EnumFactory<AffiliationCategory> {

    /** {@InheritDoc} */
    @Override
    AffiliationCategory getForString(String value) {
        AffiliationCategory desiredKey
        desiredKey = AffiliationCategory.values().find {it.value.equals(value.trim())}
        if (!desiredKey) {
            throw new IllegalArgumentException("Invalid value '$value' for ${AffiliationCategory.getSimpleName()}")
        }
        return desiredKey
    }
}
