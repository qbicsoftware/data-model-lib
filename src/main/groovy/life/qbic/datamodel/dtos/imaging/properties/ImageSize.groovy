package life.qbic.datamodel.dtos.imaging.properties

/**
 * A DTO to describe the size of images obtained from imaging experiments
 *
 * This class should be used whenever the size of an image in context of imaging projects needs to be described
 *
 * @author Jennifer Bödker
 * @since 1.10.0
 */
class ImageSize {

    /**
     * Describes the time point of when the image was taken
     */
    private final Date time

    /**
     * Channel from which the image was obtained
     */
    private final int channel

    /**
     * Size on the x-axis in px
     */
    private final int x

    /**
     * Size on the y-axis in px
     */
    private final int y

    /**
     * Size on the z-axis in px
     */
    private final int z

}
