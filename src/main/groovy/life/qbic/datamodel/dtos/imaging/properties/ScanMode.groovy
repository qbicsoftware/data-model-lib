package life.qbic.datamodel.dtos.imaging.properties

/**
 * Enumeration of different microscopy scan modes.
 *
 * This enum class should be used, whenever a imaging scan modes needs
 * to be described.
 *
 * Every scan mode needs to have a meaningful and descriptive label.
 * Abbreviations are discouraged.
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
enum ScanMode {
    POINT("single point"),
    XY("xy plane"),
    XZ("xz plane"),
    YZ("yz plane")

    /**
     * Contains the String representation of a image plane item.
     */
    private String value

    /**
     * Enumeration of different microscopy scan modes.
     * @param value {@link ScanMode#value}
     */
    private ScanMode(String value) {
        this.value = value
    }

    /**
     * The string representation of the image plane item.
     * @return The value of the image plane item, which is its declarative String representation.
     */
    String getValue() {
        return this.value
    }

    /**
     * The <code>toString()</code> method is overridden to return the String
     * representation of a image plane item. This is equivalent
     * to the <code>getValue()</code> return value.
     *
     * @see #getValue()
     * @return The String representation of the image plane item
     */
    @Override
    String toString() {
        return this.getValue()
    }
}
