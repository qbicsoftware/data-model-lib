package life.qbic.datamodel.dtos.imaging.properties

/**
 * A DTO to describe the illumination mode in context of imaging
 *
 * Whenever a specific illumination mode is used for imaging data the mode should be described with this class
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
enum IlluminationMode {

    CONFOCAL("Confocal"),
    WIDEFIELD("Wiedefield"),
    TIRFVAEM("TIRF/VAEM"),
    UNKNOWN("unknown")

    /**
     * Contains the String representation of a illumination mode item.
     */
    private final String value

    /**
     * A DTO to describe the illumination mode in context of imaging
     * @param value {@link IlluminationMode#value}
     */
    private IlluminationMode(String value) {
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
