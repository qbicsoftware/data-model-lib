package life.qbic.datamodel.accounting

import life.qbic.datamodel.dtos.business.CostEstimateId
import life.qbic.datamodel.dtos.general.Person

/**
 * A cost estimate for a project
 *
 * During project planning a cost estimate is often required to list expected costs.
 * This estimate is not intended to be legally binding. It provides an overview over the project
 * scope and the costs associated with it.
 *
 * @since: 1.9.0
 * @author: Tobias Koch
 *
 */
class CostEstimate {

    /**
     * The date on which the cost estimate was created
     */
    final Date creationDate

    /**
     * The customer for which the estimate is created
     */
    final Person customer

    /**
     * The title of the project
     */
    final String projectTitle

    /**
     * A short description of the project
     */
    final String projectDescription

    /**
     * A list of items which for which the customer will be charged
     */
    final List<ProductItem> items

    /**
     * The total price of the cost estimate (including the price for all items)
     */
    final double totalPrice

    /**
     * An identifier which makes the CostEstimate distinguishable from other CostEstimates
     */
    final CostEstimateId identifier

    CostEstimate(Date creationDate, Person customer, String projectTitle, String projectDescription, List<ProductItem> items, double totalPrice, CostEstimateId identifier) {
        this.creationDate = creationDate
        this.customer = customer
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
