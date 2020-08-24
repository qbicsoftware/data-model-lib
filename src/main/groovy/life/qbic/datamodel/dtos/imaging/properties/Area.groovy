package life.qbic.datamodel.dtos.imaging.properties

/**
 * DTO that describes the area of an image. An area is described by two values, a starting point and an end point e.g (40,40)
 *
 * This class should be used to describe area information for imaging data
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
class Area {

    /**
     * Describes the value in µm of the first dimension of the area, e.g. 40 µm
     */
    private final Integer firstDimensionValue

    /**
     * Describes the value in µm of the second dimension of the area, e.g. 40 µm
     */
    private final Integer secondDimensionValue

    /**
     * Describes the image plane of the area
     * @see ImagePlane
     */
    private final ImagePlane plane

    /**
     * Constructor for an Area DTO instance.
     *
     * @param firstDimensionValue
     * @param secondDimensionValue
     * @param plane
     *
     * @see ImagePlane
     */
    Area(Integer firstDimensionValue, Integer secondDimensionValue, ImagePlane plane) {
        this.firstDimensionValue = firstDimensionValue
        this.secondDimensionValue = secondDimensionValue
        this.plane = plane
    }
}
