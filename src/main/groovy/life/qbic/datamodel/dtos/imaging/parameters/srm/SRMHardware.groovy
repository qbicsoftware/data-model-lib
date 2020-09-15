package life.qbic.datamodel.dtos.imaging.parameters.srm

import life.qbic.datamodel.dtos.imaging.properties.Detector
import life.qbic.datamodel.dtos.imaging.properties.Filter

import life.qbic.datamodel.dtos.imaging.properties.IlluminationMode
import life.qbic.datamodel.dtos.imaging.parameters.ImagingHardware
import life.qbic.datamodel.dtos.imaging.properties.Size

/**
 * Describes the properties of the super resolution microscope (SRM) hardware
 *
 * This class serves as DTO and contains information about
 * general SRM hardware parameters during an image analysis.
 *
 * This class shall be extended, if you need to add more technology-specific
 * properties.
 *
 * @author Sven Fillinger
 * @since 1.10.0
 */
class SRMHardware extends ImagingHardware {

    /**
     * Piezo is greek and means 'to squeeze or press'
     * Its the stage which 'holds' the specimen
     *
     * The table controller enables the control of the squeezing and position of the probe plate
     *
     * The name of the table controller is defined with this parameter,
     * e.g. E-710.3CD digital piezo controller
     */
    private final String piezoTableController

    /**
     * Scanner to detect fast, high precision motion in one or more axes
     *
     * The name of the scanner is defined with this parameter,
     * e.g. P-527.3CD multi axis piezo scanner
     */
    private final String piezoScanner

    /**
     * Cw stands for cool white and describes the brightness of the light / laser beam
     *
     * Defines the wavelength of laser lines in a continuous wave laser
     * e.g 405 nm
     */
    private final Integer laserLinesCw

    /**
     * Describes the wavelength of pulsed laser lines
     * e.g. 488 nm
     */
    private final Integer laserLinesPulsed

    /**
     * Describes the filter that has been applied to the laser lines.
     * Optical filter such as e.g. Bandpass filters(BP) are employed to center the wavelength of a light source
     *
     * e.g 488 nm BP/LL, BP (Sem rock)
     *
     */
    private final Float laserLineFilter

    /**
     * Describes the number of pulses per second(frequency) of a laser employed in pulse mode.
     *
     * Pulse frequency is measured in mega hertz (MHz), e.g 20 MHz
     */
    private final Integer laserRepetitionRate

    /**
     * Polarization optics change the state of polarization of incident radiation
     *
     * Describes the name of the polarization optics hardware
     * e.g Glen Thompson linear polarizer,
     *     Lambda/2 wave plate,
     *     Lambda/4 wave plate
     */
    private final String polarizationOptics

    /**
     * A beam splitter is an optical device that splits a beam of light in two. 
     *
     * Describes the name of the beam splitter hardware 
     * e.g TIRF Quad Line zt405/488/561/640rpc 514 BS LP
     */
    private final String excitationBeamSplitter

    /**
     * A microscope can have different illumination modes. It describes from where the lighting comes.
     * The sample could be illuminated from e.g. the back or the front (direct illumination)
     *
     * {@link IlluminationMode} describes the applied mode with a controlled vocabulary
     */
    private final IlluminationMode illuminationMode

    /**
     * This variable describes the size of the pinhole, which helps to focus the light and eliminate stray light
     *
     * The {@link Size} of the pinhole is measured in µm
     */
    private final Size pinholeSize

    /**
     * It filters out the entire excitation range of the fluorophore under inspection
     *
     * Described by the controlled vocabulary of {@link Filter}
     */
    private final Filter emissionFilter

    /**
     * BeamSplitters are designed to efficiently reflect excitation wavelengths and pass emission wavelengths
     *
     * Beside the product name the filter used with it needs to be specified
     */
    private final Filter beamSplitter

    /**
     * Different channels can have different filters, this variable collects all filter applied for different channels
     */
    private final List<Filter> emissionFilterChannels

    static class Builder extends ImagingHardware.Builder<Builder> {

        String piezoTableController = ""
        String piezoScanner = ""
        Integer laserLinesCw = -1
        Integer laserLinesPulsed = -1
        Float laserLineFilter = -1.0
        Integer laserRepetitionRate = -1
        String polarizationOptics = ""
        String excitationBeamSplitter = ""
        IlluminationMode illuminationMode = IlluminationMode.UNKNOWN
        Size pinholeSize = Size.UNKNOWN
        Filter emissionFilter = Filter.UNKNOWN
        Filter beamSplitter = Filter.UNKNOWN
        List<Filter> emissionFilterChannels = new ArrayList<>()

        /**
         * Constructor with mandatory parameters.
         * @param objective
         * @param detector {@link Detector}
         */
        Builder(String objective, Detector detector) {
            super(objective, detector)
        }

        /**
         * Sets the piezo table controller.
         * @param piezoTableController
         * @return
         */
        Builder setPiezoTableController(String piezoTableController) {
            this.piezoTableController = piezoTableController
            return this
        }

        /**
         * Sets the piezo scanner.
         * @param piezoScanner
         * @return
         */
        Builder setPiezoScanner(String piezoScanner) {
            this.piezoScanner = piezoScanner
            return this
        }

        /**
         * Sets the laser line.
         * @param laserLinesCw
         * @return
         */
        Builder setLaserLinesCw(Integer laserLinesCw) {
            this.laserLinesCw = laserLinesCw
            return this
        }

        /**
         * Sets the laser line pulse.
         * @param laserLinesPulsed
         * @return
         */
        Builder setLaserLinesPulsed(Integer laserLinesPulsed) {
            this.laserLinesPulsed = laserLinesPulsed
            return this
        }

        /**
         * Sets the laser line filter.
         * @param laserLineFilter
         * @return
         */
        Builder setLaserLineFilter(Float laserLineFilter) {
            this.laserLineFilter = laserLineFilter
            return this
        }

        /**
         * Sets the laser repetition rate.
         * @param laserRepetitionRate
         * @return
         */
        Builder setLaserRepetitionRate(Integer laserRepetitionRate) {
            this.laserRepetitionRate = laserRepetitionRate
            return this
        }

        /**
         * Sets the polarization optics.
         * @param polarizationOptics
         * @return
         */
        Builder setPolarizationOptics(String polarizationOptics) {
            this.polarizationOptics = polarizationOptics
            return this
        }

        /**
         * Sets the excitation beam splitter.
         * @param excitationBeamSplitter
         * @return
         */
        Builder setExcitationBeamSplitter(String excitationBeamSplitter) {
            this.excitationBeamSplitter = excitationBeamSplitter
            return this
        }

        /**
         * Sets the illumination mode.
         * @param illuminationMode {@link IlluminationMode}
         * @return
         */
        Builder setIlluminationMode(IlluminationMode illuminationMode) {
            this.illuminationMode = illuminationMode
            return this
        }

        /**
         * Sets the pinhole size.
         * @param pinholeSize {@link Size}
         * @return
         */
        Builder setPinholeSize(Size pinholeSize) {
            this.pinholeSize = pinholeSize
            return this
        }

        /**
         * Sets the emission filter.
         * @param emissionFilter {@link Filter}.
         * @return
         */
        Builder setEmissionFilter(Filter emissionFilter) {
            this.emissionFilter = emissionFilter
            return this
        }

        /**
         * Sets the beam splitter filter.
         * @param beamSplitter {@link Filter}.
         * @return
         */
        Builder setBeamSplitter(Filter beamSplitter) {
            this.beamSplitter = beamSplitter
            return this
        }

        /**
         * Sets the emission filter channels.
         * @param emissionFilterChannels A list of {@link Filter}.
         * @return
         */
        Builder setEmissionFilterChannels(List<Filter> emissionFilterChannels) {
            this.emissionFilterChannels = emissionFilterChannels
            return this
        }

        /**
         * Builds an immutable SRMHardware object.
         * @return
         */
        @Override
        SRMHardware build() {
            return new SRMHardware(this)
        }

        @Override
        protected Builder self() {
            return this
        }
    }

    private SRMHardware(Builder builder) {
        super(builder)
        piezoTableController = builder.piezoTableController
        piezoScanner = builder.piezoScanner
        laserLinesCw = builder.laserLinesCw
        laserLineFilter = builder.laserLineFilter
        laserLinesPulsed = builder.laserLinesPulsed
        laserRepetitionRate = builder.laserRepetitionRate
        polarizationOptics = builder.polarizationOptics
        excitationBeamSplitter = builder.excitationBeamSplitter
        illuminationMode = builder.illuminationMode
        pinholeSize = builder.pinholeSize
        emissionFilter = builder.emissionFilter
        beamSplitter = builder.beamSplitter
        emissionFilterChannels = builder.emissionFilterChannels
    }
}
