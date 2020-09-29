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
    final Integer firstDimensionValue

    /**
     * Describes the value in µm of the second dimension of the area, e.g. 40 µm
     */
    final Integer secondDimensionValue

    /**
     * Describes the image plane of the area
     * @see ImagePlane
     */
    final ImagePlane plane

    /**
     * DTO that describes the area of an image.
     * @param firstDimensionValue {@link Area#firstDimensionValue}
     * @param secondDimensionValue {@link Area#secondDimensionValue}
     * @param plane {@link Area#plane}
     */
    Area(Integer firstDimensionValue, Integer secondDimensionValue, ImagePlane plane) {
        this.firstDimensionValue = firstDimensionValue
        this.secondDimensionValue = secondDimensionValue
        this.plane = plane
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Area area = (Area) o

        if (firstDimensionValue != area.firstDimensionValue) return false
        if (plane != area.plane) return false
        if (secondDimensionValue != area.secondDimensionValue) return false

        return true
    }

    int hashCode() {
        int result
        result = (firstDimensionValue != null ? firstDimensionValue.hashCode() : 0)
        result = 31 * result + (secondDimensionValue != null ? secondDimensionValue.hashCode() : 0)
        result = 31 * result + (plane != null ? plane.hashCode() : 0)
        return result
    }
}
