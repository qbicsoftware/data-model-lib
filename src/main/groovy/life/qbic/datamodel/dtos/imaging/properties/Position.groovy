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
     * An array of size three describes the three dimensional position of an object on an image
     *
     * T describes e.g the unit used to measure the position
     * This could be metrical values or pixels
     */
    private final T[] position
}
