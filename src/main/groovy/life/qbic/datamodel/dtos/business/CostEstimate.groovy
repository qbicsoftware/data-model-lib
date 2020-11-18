package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.accounting.ProductItem

/**
 * A cost estimate for a project
 *
 * During project planning a cost estimate is often required to list expected costs.
 * This estimate is not intended to be legally binding. It provides an overview over the project
 * scope and the costs associated with it.
 *
 * @since: 1.12.0
 *
 */
class CostEstimate {

    /**
     * Date on which the Cost Estimate was lastly modified
     */
    final Date modificationDate
    /**
     * The date on which the Cost Estimate expires
     */
    final Date expirationDate
    /**
     * The customer for which this Cost Estimate was created
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
     * The total price of the Cost Estimate (the price of all items)
     */
    final double totalPrice
    /**
     * The identifier for the Cost Estimate which makes it distinguishable from other Cost Estimate
     */
    final CostEstimateId identifier
    /**
     * The affiliation of the customer selected for this Cost Estimate
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

        Builder(Customer customer, ProjectManager projectManager, String projectTitle, String projectDescription, List<ProductItem> items, Affiliation selectedCustomerAffiliation) {
            this.customer = Objects.requireNonNull(customer, "Customer must not be null")
            this.projectManager = Objects.requireNonNull(projectManager, "Project Manager must not be null")
            this.projectTitle = Objects.requireNonNull(projectTitle, "Project Title must not be null")
            this.projectDescription = Objects.requireNonNull(projectDescription, "Project Description must not be null")
            this.items = []
            this.selectedCustomerAffiliation = Objects.requireNonNull(selectedCustomerAffiliation, "Customer Affiliation must not be null")
        }

        Builder modificationDate(Date modificationDate) {
            this.modificationDate = modificationDate
            return this
        }

        Builder expirationDate(Date expirationDate) {
            this.expirationDate = expirationDate
            return this
        }

        Builder totalPrice(Double totalPrice) {
            this.totalPrice = totalPrice
            return this
        }

        Builder identifier(CostEstimateId identifier) {
            this.identifier = identifier
            return this
        }

        Builder selectedCustomerAffiliation(Affiliation selectedCustomerAffiliation) {
            this.selectedCustomerAffiliation = selectedCustomerAffiliation
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
