package life.qbic.datamodel.dtos.business.services

/**
 * Lists the abbreviation for each Product used as a type specification
 * by the ProductIdentifier {@link life.qbic.datamodel.dtos.business.ProductId}
 *
 * @since: 2.0.0
 */

enum ProductType {

    SEQUENCING("SE"),
    PROJECT_MANAGEMENT("PM"),
    PRIMARY_BIOINFO("PB"),
    SECONDARY_BIOINFO("SB"),
    DATA_STORAGE("DS"),
    PROTEOMIC("PR"),
    METABOLOMIC("ME"),
    EXTERNAL_SERVICE("EXT")

    /**
     Holds the String value of the enum
     */
    private final String value

    /**
     * Private constructor to create different ProductType enum items
     * @param value
     */
    private ProductType(String value) {
        this.value = value
    }

    /**
     * Returns to the enum item value
     * @return
     */
    String getValue() {
        return value
    }

    /**
     * Returns a String representation of the enum item
     * @return
     */
    @Override
    String toString() {
        return this.getValue()
    }
}