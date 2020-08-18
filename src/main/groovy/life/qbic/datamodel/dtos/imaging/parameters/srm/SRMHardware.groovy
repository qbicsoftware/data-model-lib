package life.qbic.datamodel.dtos.imaging.parameters.srm

import life.qbic.datamodel.dtos.imaging.properties.Filter

import life.qbic.datamodel.dtos.imaging.properties.IlluminationMode
import life.qbic.datamodel.dtos.imaging.properties.ImagingHardware
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
class SRMHardware extends ImagingHardware{

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
     * Defines the wavelength of laser lines in Cw todo is this right defined?
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
     * at wavelengths away from the actual laser line.
     *
     * e.g 488 nm BP/LL, BP (Sem rock)
     *
     */
    private final Float laserLineFilter

    /**
     * Describes the repetition rate of the laser based on its frequency
     *
     * Laser frequency is measured in mega hertz (MHz), e.g 20 MHz
     */
    private final Integer laserRepetitionRate

    /**
     * Polarization optics change the state of polarization of incident radiation
     *
     * This variable describes the name of the polarization optics hardware //todo controlled vocabulary?
     * e.g Glen Thompson linear polarizer,
     *     Lambda/2 wave plate,
     *     Lambda/4 wave plate
     */
    private final String polarizationOptics

    /**
     * The beam splitter splits the beam, it comes in different forms like cubes, plates, hexagons,..
     *
     * This variable describes the name of the beam splitter hardware  //todo controlled vocabulary?
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

}
