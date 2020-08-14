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
     * Describes the time point of when the image was taken
     */
    private final Date time

    /**
     * Size on the x-axis in nm
     */
    private final int x

    /**
     * Size on the y-axis in nm
     */
    private final int y

    /**
     * Size on the z-axis in nm
     */
    private final int z
}
