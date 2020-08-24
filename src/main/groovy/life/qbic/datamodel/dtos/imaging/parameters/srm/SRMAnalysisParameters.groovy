package life.qbic.datamodel.dtos.imaging.parameters.srm

import life.qbic.datamodel.dtos.imaging.parameters.AnalysisParameters
import life.qbic.datamodel.dtos.imaging.properties.Dimensionality
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
     * Describes the dimensionality of an image
     * @see Dimensionality
     */
    private final Dimensionality dimensionality

    /**
     * Describes an estimate of the background color based on surrounding pixel's color.
     * The variable stores the name of the method to obtain the background estimation
     *
     * e.g. "Difference of Gaussians"
     */
    private final String backgroundEstimation

    /**
     * Size of the filter in pixels
     *
     * The convolution kernell is a window (usually rectangular).
     * Its size is described by a positive integer such as y x y
     *
     * A sample value would be 1.3 px
     */
    private final Float filterSize

    /**
     * It describes the limiting spatial frequency of the microscope
     * Based on this value the smallest object resolvable by the microscope can be determined
     *
     * It is given in photons, e.g. 1.5 photons
     */
    private final Float cutOff

    /**
     * ROI stands for region of interest.
     * This region is defined by a number of pixels. All pixels contained within the area of interest describe it.
     *
     * An image that comprises an ROI of 2x5 pixels has a ROI size of 10 pixels
     *
     */
    private final Float roiSize

    /**
     * Describes the size of the image pixels.
     *
     * The {@link PixelSize} is characterized by 5 elements:
     * (time, channel, x, y, z) in nm
     *
     * @see PixelSize
     */
    private final PixelSize pixelSize

    /**
     * The conversion factor applied for the analysis
     * e.g 0.43 e-/ADU
     * todo maybe rename it to conversionFactor? what conversion is meant specifically?
     */
    private final Float conversion

    /**
     * Offset applied in the analysis
     * This is e.g. 100 ADU
     * The collected signal from the light source can be shifted via an offset amount through pre-amplification
     */
    private final Integer offset

    /**
     * PSF stands for point spread function and describes the three-dimensional diffraction pattern of light emitted from
     * an infinitely small point source.
     *
     * An experimental PSF is acquired from measurements on a particular imaging setup and is used to calibrate the microscope
     * This setting is optional
     *
     */
    private final Boolean experimentalPSF

    /**
     * sCMOS stands for scientific Complementary metal–oxide–semiconductor, its an image sensor which offers rapid frame
     * rates, a wide dynamic range, high quantum efficiency, high resolution and a large field of view simultaneously in one image
     *
     * Describes if a sCMOS is used or not
     */
    private final Boolean sCMOS

    /**
     * During sample collection, in the process of analysing the sample, it can drift. Without correcting this drift
     * the spatial resolution in the final reconstructed image will be poor
     *
     * Either drift correction is present or not
     */
    private final Boolean driftCorrection

    /**
     * Describes the maximal distance that a molecule can "jump" within two frames in order to be traced
     * In context of SMT - Single Molecule Tracking
     *
     * Measured in pixels
     * e.g 1.5 pixels
     */
    private final Float maxJumpDistance

    /**
     * Blinking occurs when some fluorophores switch from a bright to a dark state due to photo-induced switching.
     * SRM are capable of detecting such blinking objects.
     * In context of  SMT - Single Molecule Tracking
     *
     * This variable describes the number of frames which are allowed between to signals in order to be traced (called a blink)
     * e.g. 2 frames
     */
    private final Integer blinking

    /**
     * Describes the number of frames in which a molecules could be detected/tracked
     * In context of SMT - Single Molecule Tracking
     *
     * Measured in frames,
     * e.g. a molecules was tracked in 5 frames
     */
    private final Integer trackLength

    SRMAnalysisParameters(Dimensionality dimensionality, String backgroundEstimation, Float filterSize, Float cutOff, Float roiSize, PixelSize pixelSize, Float conversion, Integer offset, Boolean experimentalPSF, Boolean sCMOS, Boolean driftCorrection, Float maxJumpDistance, Integer blinking, Integer trackLength) {
        this.dimensionality = dimensionality
        this.backgroundEstimation = backgroundEstimation
        this.filterSize = filterSize
        this.cutOff = cutOff
        this.roiSize = roiSize
        this.pixelSize = pixelSize
        this.conversion = conversion
        this.offset = offset
        this.experimentalPSF = experimentalPSF
        this.sCMOS = sCMOS
        this.driftCorrection = driftCorrection
        this.maxJumpDistance = maxJumpDistance
        this.blinking = blinking
        this.trackLength = trackLength
    }

    Dimensionality getDimensionality() {
        return dimensionality
    }

    String getBackgroundEstimation() {
        return backgroundEstimation
    }

    Float getFilterSize() {
        return filterSize
    }

    Float getCutOff() {
        return cutOff
    }

    Float getRoiSize() {
        return roiSize
    }

    PixelSize getPixelSize() {
        return pixelSize
    }

    Float getConversion() {
        return conversion
    }

    Integer getOffset() {
        return offset
    }

    Boolean getExperimentalPSF() {
        return experimentalPSF
    }

    Boolean getsCMOS() {
        return sCMOS
    }

    Boolean getDriftCorrection() {
        return driftCorrection
    }

    Float getMaxJumpDistance() {
        return maxJumpDistance
    }

    Integer getBlinking() {
        return blinking
    }

    Integer getTrackLength() {
        return trackLength
    }
}
