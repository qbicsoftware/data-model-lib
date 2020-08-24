package life.qbic.datamodel.dtos.imaging.properties

/**
 * A DTO to describe the dimensionality of an image
 *
 * This class should be used whenever the dimension of an image or in the image context needs to be described
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
enum Dimensionality {
    ThreeDimensional ("3D"),
    TwoDimensional ("2D")

    /**
     * Contains the String representation of a dimensionality item.
     */
    private String value

    /**
     * A DTO to describe the dimensionality of an image
     * @param value {@link Dimensionality#value}
     */
    Dimensionality(String value){
        this.value = value
    }

    /**
     * The String representation of the dimensionality item.
     * @return The value of the dimensionality item, which is its declarative String representation.
     */
    String getValue() {
        return this.value
    }

    /**
     * The <code>toString()</code> method is overridden to return the String
     * representation of a dimensionality item. This is equivalent
     * to the <code>getValue()</code> return value.
     *
     * @see #getValue()
     * @return The String representation of the dimensionality item
     */
    @Override
    String toString() {
        return this.getValue()
    }
}
