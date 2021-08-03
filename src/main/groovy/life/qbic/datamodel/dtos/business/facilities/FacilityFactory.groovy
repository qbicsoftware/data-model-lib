package life.qbic.datamodel.dtos.business.facilities

import life.qbic.datamodel.dtos.EnumFactory

/**
 * This class provides functionality for enum key retrieval
 *
 * This class retrieves the corresponding Facility for a given String
 *
 * @see Facility
 * @since: 2.11.0
 */
class FacilityFactory extends EnumFactory<Facility> {
    /**
     * This method returns the enum with the provided String value.
     *
     * @throws IllegalArgumentException in case the String could not be mapped
     * @param value the String corresponding to a key of the enum
     * @return the enum key for the provided string value
     * @since 2.11.0
     */
    @Override
    Facility getForString(String value) {
        Facility desiredKey
        desiredKey = Facility.values().find {it.fullName.equals(value.trim())}
        if (!desiredKey) {
            throw new IllegalArgumentException("Invalid value '$value' for ${Facility.getSimpleName()}")
        }
        return desiredKey
    }
}
