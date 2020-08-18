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
    private final Float timePoint

    /**
     * Size on the x-axis in nm
     */
    private final Float x

    /**
     * Size on the y-axis in nm
     */
    private final Float y

    /**
     * Size on the z-axis in nm
     */
    private final Float z
}
