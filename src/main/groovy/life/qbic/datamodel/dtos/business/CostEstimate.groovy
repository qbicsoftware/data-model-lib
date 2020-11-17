package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.general.Person

/**
 * A cost estimate Dto for a project
 *
 * During project planning a cost estimate is often required to list expected costs.
 * This estimate is not intended to be legally binding. It provides an overview over the project
 * scope and the costs associated with it.
 *
 * @since: 1.12.0
 *
 */
@EqualsAndHashCode
class CostEstimate {

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
    final Person projectManager
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
    final CostEstimateId identifier
    /**
     * The affiliation of the customer selected for this offer
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
     * Returns an unmodifiable list from the given items
     * @return
     */
    List<ProductItem> getItems() {
        return Collections.unmodifiableList(items)
    }
}

