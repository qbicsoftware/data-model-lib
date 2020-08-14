package life.qbic.datamodel.dtos.imaging.parameters.lightmicroscopy

import life.qbic.datamodel.dtos.imaging.parameters.AcquisitionParameters
import life.qbic.datamodel.dtos.imaging.properties.Area
import life.qbic.datamodel.dtos.imaging.properties.Position
import life.qbic.datamodel.dtos.imaging.properties.Power
import life.qbic.datamodel.dtos.imaging.properties.Unit
import life.qbic.datamodel.dtos.imaging.properties.WaveLength

/**
 * Description of light microscope parameters during image analysis.
 *
 * This class serves as DTO and contains information about
 * general light microscope parameters during an image analysis.
 *
 * This class shall be extended, if you need to add more technology-specific
 * properties.
 *
 * @author Sven Fillinger
 * @since 1.10
 */
class LightMicroscopyParameters extends AcquisitionParameters{

    /**
     * It is light that excites fluorochromes. Its the light that gets absorbed by the specimen
     * A sufficient intensity needs to match the excitation range of the fluorochrome in order to get a signal.
     *
     * Measured as light in wavelength per channel, it is stored as a list of {@link WaveLength}
     * e.g (488, 561)
     */
    private final List<WaveLength> excitationPerChannel

    /**
     * Wavelength of emission light per channel. Its the light that passes the specimen and is not absorbed.
     *
     * Measured as light in {@link WaveLength} per channel
     *
     * The emission is stored as a range of wave lengths and is therefor a string
     */
    private final List<WaveLength> emissionPerChannel

    /**
     * Total Internal Reflection Fluorescence (TIRF)
     * Amount of power of the laser beam of the TIRF lens
     *
     * {@link Power} is measured in milliwats (mW)
     *
     * @see Power
     */
    private final Power laserPowerTIRFLens

    /**
     * Amount of power of the laser beam split by the beam splitter.
     * A beam splitter is an optical device that splits the beam of light
     *
     * {@link Power} is measured in milliwats (mW)
     *
     * @see Power
     */
    private final Power laserPowerBeamSplitter

    /**
     * Time required to generate an image with the camera
     *
     * Described in ms (e.g 100 ms)
     */
    private final Float cameraAcquisitionTime

    /**
     * TODO is this correct?
     * Position of the light beam on the scanning area
     *
     * Described by coordinates in pixels or µm e.g position (x,y)
     */
    private final Position<Unit> position

    /**
     * TODO add a description and a parameter type, time resolution?
     * Time-Correlated Single Photon Counting (TCSPC)
     * A resolution is defined by the shortest distance between two points on a specimen that can still be distinguished
     *
     * Describes the timing resolution of TCSPC in ps e.g. 32 ps
     */
    private final int tcspcResolution

    /**
     * TODO is this correctly described? Whats the difference to position?
     * Position of the laser spot on the scanning area
     *
     * Described by coordinates in pixels or µm e.g position (x,y)
     */
    private final Position<Unit> tcspcPosition

    /**
     * TODO the type of this parameter was not defined yet
     * Describes the scan mode of the used for the TCSPC microscopy
     */
    private final String tscpcScanMode

    /**
     * Describes the time for the acquisition of the scan head
     * The rate is defined as time/px and has the unit ms
     *
     * e.g. 5ms
     */
    private final int scanAcquisitionRate

    /**
     * The size of the scanned area
     * e.g. area in pixels (x,y)
     *
     * @see Area
     */
    private final Area scanSize
}
