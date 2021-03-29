package life.qbic.datamodel.dtos.business

/**
 * Lists all packages that bundle the offer items
 *
 * A package can be of different types, they can be differentiated by the items that they contain
 *
 * @since 1.0
 */
enum ProductCategory {

    SEQUENCING("Sequencing"),
    PROJECT_MANAGEMENT("Project Management"),
    PRIMARY_BIOINFO("Primary Bioinformatics"),
    SECONDARY_BIOINFO("Secondary Bioinformatics"),
    DATA_STORAGE("Data Storage"),
    PROTEOMIC("Proteomics"),
    METABOLOMIC("Metabolomics"),
    /**
     * Unknown category is used for all products that could not be matched to
     * another category. It is the default value if no assignment could be made.
     * <p><b><em>Do not use to categorize products intentionally.</em></b></p>
     * @since 2.5.0
     */
    UNKNOWN("Unknown")


    /**
     * Value describing the enum type with a string
     */
    private String value

    ProductCategory(String value) {
        this.value = value
    }

}