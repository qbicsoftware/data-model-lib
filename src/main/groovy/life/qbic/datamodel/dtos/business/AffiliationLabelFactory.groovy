package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.EnumFactory

/**
 * This class provides functionality for enum key retrieval
 *
 * This class retrieves the corresponding AffiliationLabel for a given String
 *
 * @see AffiliationLabel
 * @since: 2.5.0
 */
class AffiliationLabelFactory extends EnumFactory<AffiliationLabel> {

    /** {@InheritDoc} */
    @Override
    AffiliationLabel getForString(String value) {
        AffiliationLabel desiredKey
        desiredKey = AffiliationLabel.values().find {it.value.equals(value.trim())}
        if (!desiredKey) {
            throw new IllegalArgumentException("Invalid value '$value' for ${AffiliationLabel.getSimpleName()}")
        }
        return desiredKey
    }
}
