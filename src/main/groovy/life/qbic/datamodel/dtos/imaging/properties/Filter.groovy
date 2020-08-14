package life.qbic.datamodel.dtos.imaging.properties

/**
 * A DTO to describe filters in the imaging context
 *
 * This class should be used in case any filter is used to obtain an image
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
enum Filter {
    EMISSION510LP("510 LP"),
    EMISSION550BP("550/30 BP"),
    BEAMLP("594 BS LP"),
    BEAMSP("596 BS SP"),
    BEAMPOLARIZING("Polarizing beam cube"),
    EMISSION580LP("580 LP"),
    EMISSION600BP("600/35 BP")
    /**
     * Contains the String representation of a filter item.
     */
    private String value

    private Filter(String value) {
        this.value = value
    }

    /**
     * The string representation of the filter item.
     * @return The value of the filter item, which is its declarative String representation.
     */
    String getValue() {
        return this.value
    }

    /**
     * The <code>toString()</code> method is overridden to return the String
     * representation of a filter item. This is equivalent
     * to the <code>getValue()</code> return value.
     *
     * @see #getValue()
     * @return The String representation of the filter item
     */
    @Override
    String toString() {
        return this.getValue()
    }
}
