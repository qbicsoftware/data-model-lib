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
class Position<T> {

    /**
     * Describes the unit of the position
     */
    private final T unit

    /**
     * Describes the position on the x-axis
     * This could be e.g 20 µm (depending on the defined unit)
     */
    private final int x

    /**
     * Describes the position on the y-axis
     * This could be e.g 60 µm (depending on the defined unit)
     */
    private final int y
}
