package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.accounting.ProductItem
import life.qbic.datamodel.dtos.general.Person

/**
 * An offer DTO for a project
 *
 * @since: 1.12.0*
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
    final OfferId identifier
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
        OfferId identifier
        Affiliation selectedCustomerAffiliation

        Builder(Date modificationDate, ProjectManager projectManager, OfferId identifier) {
            this.modificationDate = Objects.requireNonNull(modificationDate, "Modification Date must not be null")
            this.projectManager = Objects.requireNonNull(projectManager, "Project Manager must not be null")
            this.identifier = Objects.requireNonNull(identifier, "Offer identifier must not be null")
            this.items = []
        }

        Builder expirationDate(Date expirationDate) {
            this.expirationDate = expirationDate
            return this
        }

        Builder projectTitle(String projectTitle) {
            this.projectTitle = projectTitle
            return this
        }

        Builder customer(Customer customer) {
            this.customer = customer
            return this
        }

        Builder projectDescription(String projectDescription) {
            this.projectDescription = projectDescription
            return this
        }

        Builder items(List<ProductItem> items) {
            this.items = items
            return this
        }

        Builder totalPrice(Double totalPrice) {
            this.totalPrice = totalPrice
            return this
        }

        Builder selectedCustomerAffiliation(Affiliation selectedCustomerAffiliation) {
            this.selectedCustomerAffiliation = selectedCustomerAffiliation
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

