package life.qbic.datamodel.dtos.business

/**
 * Possible academic titles
 *
 * This enum describes all academic titles known to the qbic infrastructure.
 * Bachelor and Masters titles as well as multiple doctorates are not supported.
 *
 * @since: 1.11.0
 */
enum AcademicTitle {

    PROFESSOR("Prof. Dr."),
    DOCTOR("Dr."),
    NONE("None"),
    PHD("PhD")

    /**
     Holds the String value of the enum
     */
    private final String value

    /**
     * Private constructor to create different AcademicTitle enum items
     * @param value
     */
    private AcademicTitle(String value) {
        this.value = value
    }

    /**
     * Returns to the enum item value
     * @return
     */
    String getValue() {
        return value
    }

    /**
     * Returns a String representation of the enum item
     * @return
     */
    @Override
    public String toString() {
        return this.getValue()
    }
}