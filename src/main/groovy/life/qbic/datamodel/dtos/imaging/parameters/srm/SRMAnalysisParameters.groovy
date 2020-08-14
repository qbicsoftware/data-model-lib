package life.qbic.datamodel.dtos.imaging.parameters.srm

import life.qbic.datamodel.dtos.imaging.properties.PixelSize

/**
 * Describes super resolution microscope (SRM) analysis parameters during image analysis
 *
 * This class serves as DTO and contains information about
 * general SRM analysis parameters during an image analysis.
 *
 * This class shall be extended, if you need to add more technology-specific
 * properties.
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
class SRMAnalysisParameters extends AnalysisParameters {

    /**
     * Describes the dimensionality used to analyse an image
     * This could be e.g 3 for a three-dimensional image
     */
    private final int dimensionality

    /**
     * Describes an estimate of the background color based on surrounding pixel's color.
     * The variable stores the name of the color
     * todo rather use something more specific like rgb color like an array?
     */
    private final String backgroundEstimation

    /**
     * Size of the filter in pixels
     *
     * The convolution kernell is a window (usually rectangular).
     * Its size is described by a positive integer such as y x y
     */
    private final int filterSize

    /**
     * It describes the limiting spatial frequency of the microscope
     * Based on this value the smallest object resolvable by the microscope can be determined
     *
     * It is given in cycles/millimeter
     */
    private final int cutOff

    /**
     * ROI stands for region of interest.
     * This region is defined by a number of pixels. All pixels contained within the area of interest describe it.
     *
     * An image that comprises an ROI of 2x5 pixels has a ROI size of 10
     * todo is it 2d or 3d, assume 2d since we name it region of interest and not VOI (volume of interest)
     */
    private final int roiSize

    /**
     * Describes the size of the image pixels.
     *
     * The {@link PixelSize} is characterized by 5 elements:
     * (time, channel, x, y, z)
     *
     * @see PixelSize
     */
    private final PixelSize pixelSize

    /**
     * The conversion factor applied for the analysis
     * todo maybe rename it to conversionFactor? what conversion is meant specifically?
     */
    private final int conversion

    /**
     * PSF stands for point spread function and describes the three-dimensional diffraction pattern of light emitted from
     * an infinitely small point source.
     *
     * An experimental PSF is acquired from measurements on a particular imaging setup and is used to calibrate the microscope
     *
     * Todo is it deterimined by an infinit small point object (its size)?
     */
    private final float experimentalPSF

    /**
     * sCMOS stands for scientific Complementary metal–oxide–semiconductor, its an image sensor which offers rapid frame
     * rates, a wide dynamic range, high quantum efficiency, high resolution and a large field of view simultaneously in one image
     *
     * Describes the name of the used sensor
     * todo or should this be Volt to determine how much volt are transferred by the cmos?
     */
    private final String sCMOS

    /**
     * During sample collection, in the process of analysing the sample, it can drift. Without correcting this drift
     * the spatial resolution in the final reconstructed image will be poor
     *
     * todo is this a number describing the distance or is it measured in pixel?
     */
    private final double driftCorrection

    /**
     * todo describe this parameter, find a suitable data type
     */
    private final int maxJumpDistance

    /**
     * States if the blinking fluorophores wre detected. Some fluorophores can phoswitch from a brigth to a dark state.
     * SRM are capable of detecting such blinking objects.
     *
     * This variable describes if blinking was detected
     */
    private final boolean blinking

    /**
     * Describes the length of the track of the microscope
     *
     * todo is this really the track length of the microscope table?
     */
    private final int trackLength
}
