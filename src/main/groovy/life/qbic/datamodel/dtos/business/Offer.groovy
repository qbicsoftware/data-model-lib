package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode

/**
 * An offer DTO for a project
 *
 * An offer describes a legally binding service proposal with associated costs.
 *
 * @since: 1.12.0
 */
@EqualsAndHashCode
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
     * The net price of all items without taxes and overhead
     */
    final double netPrice
    /**
     * The amount of taxes, part of the total total price
     */
    final double taxes
    /**
     * The amount of overheads part, of the total price
     */
    final double overheads
    /**
     * The identifier for the offer which makes it distinguishable from other offers
     */
    final OfferId identifier
    /**
     * The affiliation of the customer selected for this offer
     */
    final Affiliation selectedCustomerAffiliation
    /**
     * A list of items for which an overhead cost is applicable
     */
    final List<ProductItem> itemsWithOverhead
    /**
     * A list of Items for which an overhead cost is not applicable
     */
    final List<ProductItem> itemsWithoutOverhead
    /**
     * The net price of all items for which an overhead cost is applicable, without overhead and taxes
     */
    final double itemsWithOverheadNetPrice
    /**
     * The net price of all items for which an overhead cost is not applicable, without overhead and taxes
     */
    final double itemsWithoutOverheadNetPrice

    static class Builder {

        /*
        Overall offer describing properties
         */
        String projectTitle
        String projectDescription
        Customer customer
        ProjectManager projectManager
        Affiliation selectedCustomerAffiliation
        Date modificationDate
        Date expirationDate
        List<ProductItem> items
        List<ProductItem> itemsWithOverhead
        List<ProductItem> itemsWithoutOverhead
        /*
        Offer identifier
         */
        OfferId identifier

        /*
        Price related properties
         */
        double totalPrice
        double netPrice
        double taxes
        double overheads
        double itemsWithOverheadNet
        double itemsWithoutOverheadNet

        Builder(Customer customer, ProjectManager projectManager, String projectTitle, String projectDescription, Affiliation selectedCustomerAffiliation) {
            this.customer = Objects.requireNonNull(customer, "Customer must not be null")
            this.projectManager = Objects.requireNonNull(projectManager, "Project Manager must not be null")
            this.projectTitle = Objects.requireNonNull(projectTitle, "Project Title must not be null")
            this.projectDescription = Objects.requireNonNull(projectDescription, "Project Description must not be null")
            this.selectedCustomerAffiliation = Objects.requireNonNull(selectedCustomerAffiliation, "Customer Affiliation must not be null")
            this.items = []
            netPrice = 0
            overheads = 0
            taxes = 0
            totalPrice = 0
            itemsWithOverhead = []
            itemsWithoutOverhead = []
            itemsWithOverheadNet = 0
            itemsWithoutOverheadNet = 0
        }

        Builder modificationDate(Date modificationDate) {
            this.modificationDate = modificationDate
            return this
        }

        Builder expirationDate(Date expirationDate) {
            this.expirationDate = expirationDate
            return this
        }

        Builder netPrice(Double netPrice) {
            this.netPrice = netPrice
            return this
        }

        Builder overheads(Double overheads) {
            this.overheads = overheads
            return this
        }

        Builder taxes(Double taxes) {
            this.taxes = taxes
            return this
        }

        Builder totalPrice(Double totalPrice) {
            this.totalPrice = totalPrice
            return this
        }

        Builder items(List<ProductItem> items) {
            this.items = items
            return this
        }

        Builder identifier(OfferId identifier) {
            this.identifier = identifier
            return this
        }

        Builder itemsWithOverhead(List<ProductItem> itemsWithOverhead) {
            this.itemsWithOverhead= itemsWithOverhead
            return this
        }

        Builder itemsWithoutOverhead(List<ProductItem> itemsWithoutOverhead) {
            this.itemsWithoutOverhead= itemsWithoutOverhead
            return this
        }

        Builder itemsWithOverheadNet(double itemsWithOverheadNet) {
            this.itemsWithOverheadNet = itemsWithOverheadNet
            return this
        }

        Builder itemsWithoutOverheadNet(double itemsWithoutOverheadNet) {
            this.itemsWithoutOverheadNet = itemsWithoutOverheadNet
            return this
        }

        Offer build() {
            return new Offer(this)
        }
    }

    private Offer(Builder builder) {
        this.modificationDate = builder.modificationDate
        this.expirationDate = builder.expirationDate
        this.customer = builder.customer
        this.projectManager = builder.projectManager
        this.projectDescription = builder.projectDescription
        this.projectTitle = builder.projectTitle
        this.items = builder.items
        this.identifier = builder.identifier
        this.selectedCustomerAffiliation = builder.selectedCustomerAffiliation
        this.netPrice = builder.netPrice
        this.overheads = builder.overheads
        this.taxes = builder.taxes
        this.totalPrice = builder.totalPrice
        this.itemsWithOverhead = builder.itemsWithOverhead
        this.itemsWithoutOverhead = builder.itemsWithoutOverhead
        this.itemsWithOverheadNetPrice = builder.itemsWithOverheadNet
        this.itemsWithoutOverheadNetPrice = builder.itemsWithoutOverheadNet
    }

    /**
     * Returns an unmodifiable list from the given items
     * @return
     */
    List<ProductItem> getItems() {
        return Collections.unmodifiableList(items)
    }
}

