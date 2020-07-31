package life.qbic.datamodel.accounting

/**
 * An item with associated costs and quantity
 *
 * Cost items describe services and their price. They are the building blocks of invoices and offers.
 * The unit price is always provided in euros.
 * @since: 1.9.0
 * @author: Tobias Koch
 *
 * * */
class CostItem {

    double quantity
    final String IDENTIFIER
    final double UNIT_PRICE
    final String UNIT_NAME
    final String NAME
    final String DESCRIPTION

    CostItem(double UNIT_PRICE, String UNIT_NAME, String NAME, String DESCRIPTION) {
        this.UNIT_PRICE = UNIT_PRICE
        this.UNIT_NAME = UNIT_NAME
        this.NAME = NAME
        this.DESCRIPTION = DESCRIPTION
    }

    CostItem(double quantity, double UNIT_PRICE, String UNIT_NAME, String NAME, String DESCRIPTION) {
        this.quantity = quantity
        this.UNIT_PRICE = UNIT_PRICE
        this.UNIT_NAME = UNIT_NAME
        this.NAME = NAME
        this.DESCRIPTION = DESCRIPTION
    }

    double getQuantity() {
        return quantity
    }

    void setQuantity(double quantity) {
        this.quantity = quantity
    }
}

