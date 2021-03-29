package life.qbic.datamodel.dtos.business

/**
 * Lists all packages that bundle the offer items
 *
 * A package can be of different types, they can be differentiated by the items that they contain
 *
 * @since: 1.0
 */
enum ProductCategory {

    SEQUENCING("Sequencing"),
    PROJECT_MANAGEMENT("Project Management"),
    PRIMARY_BIOINFO("Primary Bioinformatics"),
    SECONDARY_BIOINFO("Secondary Bioinformatics"),
    DATA_STORAGE("Data Storage"),
    PROTEOMIC("Proteomics"),
    METABOLOMIC("Metabolomics")

    /**
     * Value describing the enum type with a string
     */
    private final String value

    ProductCategory(String value) {
        this.value = value
    }

    /**
     * Returns the value associated to the given enum
     * This is <em>NOT</em> the same as {@link #toString}
     * @return a user-friendly string value
     */
    String getValue() {
        return value
    }
}