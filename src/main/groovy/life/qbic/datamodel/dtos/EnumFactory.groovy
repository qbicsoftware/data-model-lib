package life.qbic.datamodel.dtos

/**
 * This class provides functionality for enum key retrieval
 *
 * For enums that provide a String value, this class retrieves the corresponding enum key for a given value.
 *
 * @since: 1.12.0
 */
abstract class EnumFactory<T extends Enum<T>> {
    /**
     * This method returns the enum with the provided String value.
     *
     * @throws IllegalArgumentException in case the String could not be mapped
     * @param value the String corresponding to a key of the enum
     * @return the enum key for the provided string value
     */
    abstract T getForString(String value);

}
