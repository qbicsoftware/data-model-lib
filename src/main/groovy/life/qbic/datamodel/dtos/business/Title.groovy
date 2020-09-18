package life.qbic.datamodel.dtos.business

enum Title {

/**
 * We define four different titles depending on the academic title of the customer here:
 *  - Mr.: Mister, the default address of male customers without academic credentials
 *  - Ms.: Miss, the default address of female customers without academic credentials
 *  - Dr.: Doctor, addressing a customers with a doctorate degree
 *  - Prof. Dr.: Professor Doctor, addressing a customer with a doctorate degree and habilitation
 * @since: 1.0
 */

    MISTER("Mr."),
    MISS("Ms."),
    DOCTOR("Dr."),
    PROFESSOR_DOCTOR("Prof. Dr.")

    /**
     * Holds the value of the enum
     */

    private final String value

    /**
     *
     * Private constructor to create different Title enum items
     * @param value
     */
    private Title(String value) {
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


