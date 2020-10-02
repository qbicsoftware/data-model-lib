package life.qbic.datamodel.dtos.imaging.properties

import groovy.transform.EqualsAndHashCode

/**
 * A DTO to describe the size of images obtained from imaging experiments
 *
 * This class should be used whenever the size of an image in context of imaging projects needs to be described
 *
 * @author Jennifer Bödker
 * @since 1.10.0
 */
@EqualsAndHashCode
class ImageSize {

    /**
     * Describes the time point within a time series, it correlates with the frames of an image
     * One frame is one image taken at time point x
     *
     * e.g time point 10
     */
    final Integer timePoint

    /**
     * Channel from which the image was obtained
     */
    final Integer channel

    /**
     * Size on the x-axis in px
     */
    final Integer x

    /**
     * Size on the y-axis in px
     */
    final Integer y

    /**
     * Size on the z-axis in px
     */
    final Integer z

    /**
     *
     * @param timePoint {@see ImageSize#timePoint}
     * @param channel {@see ImageSize#channel}
     * @param x {@see ImageSize#x}
     * @param y {@see ImageSize#y}
     * @param z {@see ImageSize#z}
     */
    ImageSize(Integer timePoint, Integer channel, Integer x, Integer y, Integer z) {
        this.timePoint = timePoint
        this.channel = channel
        this.x = x
        this.y = y
        this.z = z
    }
}
