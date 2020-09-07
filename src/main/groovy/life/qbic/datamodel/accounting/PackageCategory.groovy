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
enum PackageCategory {

    SEQUENCING(""),
    PROJECTMANAGEMENT(""),
    PRIMARYBIOINFO(""),
    SECONDARYBIOINFO(""),
    DATASTORAGE("")

    private String value

    PackageCategory(String value){
        this.value = value
    }


}