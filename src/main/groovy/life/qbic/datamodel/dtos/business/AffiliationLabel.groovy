package life.qbic.datamodel.dtos.business

/**
 * We define X affiliation faculty labels here, which will be associated to internal affiliations.
 * The following faculty labels are defined
 *  - aaa:
 *  - bbb:
 *  - ccc:
 *  - none:
 *   @since: 2.5.0
 */
enum AffiliationLabel {

    AAA("aaa"),
    BBB("bbb"),
    CCC("ccc"),
    NONE("none")

    /**
     * Holds the value of the enum
     */
    private final String value

    /**
     * Private constructor to create different AffiliationLabel enum items
     * @param value
     */
    private AffiliationLabel(String value) {
        this.value = value
    }

    /**
     * Returns to the enum item value
     * @return
     */
    String getValue() {
        return this.value
    }

    /**
     * Returns a String representation of the enum item
     * @return
     */
    @Override
    String toString() {
        return this.getValue()
    }

}