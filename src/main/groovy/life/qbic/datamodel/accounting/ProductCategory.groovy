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
    PROJECTMANAGEMENT("Project Management"),
    PRIMARYBIOINFO("Primary Bioinformatics"),
    SECONDARYBIOINFO("Secondary Bioinformatics"),
    DATASTORAGE("Data Storage")

    /**
     * Value describing the enum type with a string
     */
    private String value

    ProductCategory(String value){
        this.value = value
    }

}