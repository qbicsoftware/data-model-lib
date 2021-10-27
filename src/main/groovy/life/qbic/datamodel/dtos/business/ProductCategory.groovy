package life.qbic.datamodel.dtos.business

/**
 * Lists all packages that bundle the offer items
 *
 * A package can be of different types, they can be differentiated by the items that they contain
 *
 * @since: 1.0
 */
enum ProductCategory {

    SEQUENCING("Sequencing", "SE"),
    PROJECT_MANAGEMENT("Project Management", "PM"),
    PRIMARY_BIOINFO("Primary Bioinformatics", "PB"),
    SECONDARY_BIOINFO("Secondary Bioinformatics", "SB"),
    DATA_STORAGE("Data Storage", "DS"),
    PROTEOMIC("Proteomics", "PR"),
    METABOLOMIC("Metabolomics", "ME"),
    EXTERNAL_SERVICE("External Service", "EXT")

    /**
     * Value describing the enum type with a string
     */
    private String value

    /**
     * Contains the abbreviation for each Product used as a type specification
     * by the ProductIdentifier {@link life.qbic.datamodel.dtos.business.ProductId}
     */
    private String abbreviation

    ProductCategory(String value, String abbreviation) {
        this.value = value
        this.abbreviation = abbreviation
    }

    /**
     * Returns the value associated to the given enum
     * This is <em>NOT</em> the same as {@link #toString}
     * @return a user-friendly string value
     */
    String getValue() {
        return value
    }

    /**
     * Returns the abbreviation associated to the given enum
     * This is <em>NOT</em> the same as {@link #toString}
     * @return a user-friendly string value
     */
    String getAbbreviation() {
        return abbreviation
    }

}