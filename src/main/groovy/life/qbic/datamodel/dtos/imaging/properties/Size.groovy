package life.qbic.datamodel.dtos.imaging.properties

/**
 * DTO to describe the size of an object in context of imaging
 *
 * This class should be used whenever the size of an object needs to be described
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
enum Size {

    thirty("30 µm"),
    DETECTOR("detector area (100µm)"),
    NON("no pinhole"),

    /**
     * Contains the String representation of a illumination mode item.
     */
    private String value

    private Size(String value) {
        this.value = value
    }

    /**
     * The string representation of the illumination mode item.
     * @return The value of the illumination mode item, which is its declarative String representation.
     */
    String getValue() {
        return this.value
    }

    /**
     * The <code>toString()</code> method is overridden to return the String
     * representation of a illumination mode item. This is equivalent
     * to the <code>getValue()</code> return value.
     *
     * @see #getValue()
     * @return The String representation of the illumination mode item
     */
    @Override
    String toString() {
        return this.getValue()
    }
}
