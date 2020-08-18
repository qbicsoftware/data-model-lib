package life.qbic.datamodel.dtos.imaging.properties

/**
 * DTO that describes a position on an image
 *
 * This class should be used to describe a position on an image
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
class Position {

    /**
     * Describes the position on the x-axis
     * This could be e.g 20 µm (depending on the defined unit)
     *
     * Always a positive number
     */
    private final Float x

    /**
     * Describes the position on the y-axis
     * This could be e.g 60 µm (depending on the defined unit)
     *
     * Always a positive number
     */
    private final Float y

    /**
     * Describes the position on the z-axis
     * This could be e.g 60 µm (depending on the defined unit)
     *
     * As default this value can be put to 0 if its not required
     *
     * Always a positive number
     */
    private final Float z
}
