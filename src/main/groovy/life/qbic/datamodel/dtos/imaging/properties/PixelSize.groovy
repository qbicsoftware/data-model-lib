package life.qbic.datamodel.dtos.imaging.properties

/**
 * A DTO describing pixel size in images
 *
 * This class should be used whenever the size of pixels in context of imaging needs to be described
 *
 * @author Jennifer Bödker
 * @since 1.10.0
 */
class PixelSize {

    /**
     * Describes the time point within a time series, it correlates with the frames of an image
     * One frame is one image taken at time point x
     *
     * e.g time point 0.2 seconds
     */
    final Float timePoint

    /**
     * Size on the x-axis in nm
     */
    final Float x

    /**
     * Size on the y-axis in nm
     */
    final Float y

    /**
     * Size on the z-axis in nm
     */
    final Float z

    /**
     * A DTO describing pixel size in images
     * @param timePoint {@link PixelSize#timePoint}
     * @param x {@link PixelSize#x}
     * @param y {@link PixelSize#y}
     * @param z {@link PixelSize#z}
     */
    PixelSize(Float timePoint, Float x, Float y, Float z) {
        this.timePoint = timePoint
        this.x = x
        this.y = y
        this.z = z
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        PixelSize pixelSize = (PixelSize) o

        if (timePoint != pixelSize.timePoint) return false
        if (x != pixelSize.x) return false
        if (y != pixelSize.y) return false
        if (z != pixelSize.z) return false

        return true
    }

    int hashCode() {
        int result
        result = (timePoint != null ? timePoint.hashCode() : 0)
        result = 31 * result + (x != null ? x.hashCode() : 0)
        result = 31 * result + (y != null ? y.hashCode() : 0)
        result = 31 * result + (z != null ? z.hashCode() : 0)
        return result
    }
}
