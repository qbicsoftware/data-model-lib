package life.qbic.datamodel.accounting

/**
 * Describes the packages from which the cost items can be chosen
 *
 * A package describes the characteristics of a set of items
 *
 * @since: 1.0
 * @author: Jennifer Bödker
 *
 */
class Package {

    final PackageCategory packageCategory
    final Currency currency
    final String description
    final String packageName
    final Double unitPrice
    final Unit unit
    final Boolean proportionateAllowed

}
