package life.qbic.datamodel.accounting

/**
 * Lists all packages that bundle the offer items
 *
 * A package can be of different types, they can be differentiated by the items that they contain
 *
 * @since: 1.0
 * @author: Jennifer Bödker
 *
 */
enum ProductCategory {

    SEQUENCING("Sequencing"),
    PROJECT_MANAGEMENT("Project Management"),
    PRIMARY_BIOINFO("Primary Bioinformatics"),
    SECONDARY_BIOINFO("Secondary Bioinformatics"),
    DATA_STORAGE("Data Storage")

    /**
     * Value describing the enum type with a string
     */
    private String value

    ProductCategory(String value){
        this.value = value
    }

}