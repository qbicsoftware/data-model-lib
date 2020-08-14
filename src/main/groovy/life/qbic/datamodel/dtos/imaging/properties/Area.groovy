package life.qbic.datamodel.dtos.imaging.properties

/**
 * DTO that describes the area of an image
 *
 * This class should be used to describe area information for imaging data
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
class Area {

    /**
     * Describes the type of area which can be 2D or 3D
     */
    private final String areaType

    /**
     * Describes the area of an image in pixels.
     * This can be a 2D or 3D area
     *
     * e.g x*y or x*y*z
     */
    private final int area
}
