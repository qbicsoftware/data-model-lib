package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.EnumFactory

/**
 * This class provides functionality for enum key retrieval
 *
 * This class retrieves the corresponding AcademicTitle for a given String
 *
 * @see AcademicTitle
 * @since: 1.12.0
 */
class AcademicTitleFactory extends EnumFactory<AcademicTitle>{

    /** {@InheritDoc} */
    @Override
    AcademicTitle getForString(String value) {
        AcademicTitle desiredKey
        desiredKey = AcademicTitle.values().find {it.value.equals(value.trim())}
        if (!desiredKey) {
            throw new IllegalArgumentException("Invalid value '$value' for ${AcademicTitle.getSimpleName()}")
        }
        return desiredKey
    }
}
