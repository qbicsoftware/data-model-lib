package life.qbic.datamodel.dtos.imaging.properties

/**
 * Enumeration of different image planes.
 *
 * This enum class should be used, whenever a imaging plane needs
 * to be described.
 *
 * Every image plane needs to have a meaningful and descriptive label.
 * Abbreviations are discouraged.
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
enum ImagePlane {
    XY("xy plane"),
    YZ("yz plane")

    /**
     * Contains the String representation of a image plane item.
     */
    private final String value

    /**
     * Enumeration of different image planes.
     * @param value {@link ImagePlane#value}
     */
    private ImagePlane(String value) {
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
