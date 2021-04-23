package life.qbic.datamodel.dtos.business

/**
 * We define 2 affiliation faculty labels here, which will be associated to internal affiliations.
 * The following affiliation labels are defined
 *  - MNF: Internal affiliation originated from a faculty of medicine
 *  - MFT: Internal affiliation originated from a faculty of natural sciences
 *   @since: 2.5.0
 */
enum AffiliationLabel {

    MNF("faculty of medicine"),
    MFT("faculty of natural sciences"),

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