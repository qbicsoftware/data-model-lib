package life.qbic.datamodel.accounting

import life.qbic.datamodel.dtos.business.Customer
import life.qbic.datamodel.dtos.business.OfferId
import life.qbic.datamodel.dtos.business.ProductItem
import life.qbic.datamodel.dtos.business.ProjectManager

/**
 * An offer for a project
 *
 * An offer describes a legally binding service proposal with associated costs.
 *
 * @since: 1.9.0
 * @author: Tobias Koch
 *
 */
@Deprecated
class Offer {

    /**
     * Date on which the offer was lastly modified
     */
    final Date modificationDate

    /**
     * The date on which the offer expires
     */
    final Date expirationDate

    /**
     * The customer for which this offer was created
     */
    final Customer customer

    /**
     * The QBiC project manager who was assigned to the project
     */
    final ProjectManager projectManager

    /**
     * The title of the project
     */
    final String projectTitle

    /**
     * A short description of the project
     */
    final String projectDescription

    /**
     * A list of items for which the customer will be charged
     */
    final List<ProductItem> items

    /**
     * The total price of the offer (the price of all items)
     */
    final double totalPrice

    /**
     * The identifier for the offer which makes it distinguishable from other offers
     */
    final OfferId identifier

    Offer(Date modificationDate, Date expirationDate, Customer customer, ProjectManager projectManager, String projectTitle, String projectDescription, List<ProductItem> items, double totalPrice, OfferId identifier) {
        this.modificationDate = modificationDate
        this.expirationDate = expirationDate
        this.customer = customer
        this.projectManager = projectManager
        this.projectTitle = projectTitle
        this.projectDescription = projectDescription
        this.items = items
        this.totalPrice = totalPrice
        this.identifier = identifier
    }

    /**
     * Adds a new item to the items list of the offer
     *
     * @param item which should be added to current list of items
     */
    public void addItem(ProductItem item){
        items.add(item)
    }

    /**
     * Removes an item from the list of items of the offer
     *
     * @param item which should be removed from the current list of items
     */
    void removeItem(ProductItem item){
        items.remove(item)
    }
}