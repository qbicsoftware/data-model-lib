package life.qbic.datamodel.accounting

import life.qbic.datamodel.dtos.business.Affiliation
import life.qbic.datamodel.dtos.business.CostEstimateId
import life.qbic.datamodel.dtos.business.Customer
import life.qbic.datamodel.dtos.business.ProjectManager

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
@Deprecated
class CostEstimate {

    /**
     * The date on which the cost estimate was created
     */
    final Date modificationDate

    /**
     * The date on which the cost estimate expires
     */
    final Date expirationDate

    /**
     * The customer for which the estimate is created
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

    /**
     * An identifier which makes the CostEstimate distinguishable from other CostEstimates
     */
    final Affiliation selectedCustomerAffiliation

    static class Builder {

        Date modificationDate
        Date expirationDate
        Customer customer
        ProjectManager projectManager
        String projectTitle
        String projectDescription
        List<ProductItem> items
        double totalPrice
        CostEstimateId identifier
        Affiliation selectedCustomerAffiliation

        Builder(Date modificationDate, Date expirationDate, Customer customer, ProjectManager projectManager, String projectDescription, String projectTitle, List<ProductItem> items, double totalPrice, CostEstimateId identifier, Affiliation selectedCustomerAffiliation) {
            this.modificationDate = modificationDate
            this.expirationDate = expirationDate
            this.customer = customer
            this.projectManager = projectManager
            this.projectDescription = projectDescription
            this.projectTitle = projectTitle
            this.items = new ArrayList<ProductItem>(Collections.unmodifiableList(items))
            this.totalPrice = totalPrice
            this.identifier = identifier
            this.selectedCustomerAffiliation = selectedCustomerAffiliation
        }
        //ToDo Determine if any properties should be able to be modified later or can't be set to Null
        Builder identifier(CostEstimateId identifier) {
            this.identifier = identifier
            return this
        }

        CostEstimate build() {
            return new CostEstimate(this)
        }
    }

    private CostEstimate(Builder builder) {
        this.modificationDate = builder.modificationDate
        this.expirationDate = builder.expirationDate
        this.customer = builder.customer
        this.projectManager = builder.projectManager
        this.projectDescription = builder.projectDescription
        this.projectTitle = builder.projectTitle
        this.items = builder.items
        this.totalPrice = builder.totalPrice
        this.identifier = builder.identifier
        this.selectedCustomerAffiliation = builder.selectedCustomerAffiliation
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
