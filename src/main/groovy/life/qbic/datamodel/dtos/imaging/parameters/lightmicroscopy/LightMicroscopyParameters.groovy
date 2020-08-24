package life.qbic.datamodel.dtos.imaging.parameters.lightmicroscopy

import life.qbic.datamodel.dtos.imaging.parameters.AcquisitionParameters
import life.qbic.datamodel.dtos.imaging.properties.Area
import life.qbic.datamodel.dtos.imaging.properties.EmissionRange
import life.qbic.datamodel.dtos.imaging.properties.Position
import life.qbic.datamodel.dtos.imaging.properties.ScanMode
import life.qbic.datamodel.dtos.imaging.properties.Unit

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
 * @since 1.10.0
 */
class LightMicroscopyParameters extends AcquisitionParameters{

    /**
     * It is light that excites fluorochromes. Its the light that gets absorbed by the specimen
     * A sufficient intensity needs to match the excitation range of the fluorochrome in order to get a signal.
     *
     * Measured as wavelength in nm per channel, it is stored as a list of
     * e.g (488, 561)
     */
    private final List<Integer> excitationPerChannel

    /**
     * Wavelength of emission light per channel. Its the light that is emitted by the fluorophores, it describes the fluorophore signal.
     *
     * Measured as light as wavelength in nm per channel
     *
     * The emission is stored as a range of wave lengths
     * e.g. (495-530,580-630)
     *
     * @see EmissionRange
     */
    private final List<EmissionRange> emissionPerChannel

    /**
     * Total Internal Reflection Fluorescence (TIRF)
     * Amount of power of the laser beam at the TIRF lens.
     *
     * It is measured in milliwats (mW)
     */
    private final Float laserPowerTIRFLens

    /**
     * Amount of power of the laser beam split at the beam splitter.
     * A beam splitter is an optical device that splits the beam of light
     *
     * It is measured in milliwatts (mW)
     *
     */
    private final Float laserPowerBeamSplitter

    /**
     * Time required to generate an image with the camera
     *
     * Described in ms (e.g 100 ms)
     */
    private final Float cameraAcquisitionTime

    /**
     * Position of the light beam on the scanning area
     *
     * Described by coordinates in pixels e.g position (x,y,z)
     */
    private final Position position

    /**
     * Time-Correlated Single Photon Counting (TCSPC)
     * A resolution is defined by the shortest distance between two points on a specimen that can still be distinguished
     * This describe the time resolution for TCSPC
     *
     * Describes the timing resolution of TCSPC in ps e.g. 32 ps
     */
    private final Integer tcspcTimingResolution

    /**
     * Position for the TCSPC.
     *
     * Described by coordinates in µm
     *
     * e.g position (x,y,z)
     */
    private final Position tcspcPosition

    /**
     * Describes the scan mode of the used for the TCSPC microscopy.
     *
     * @see ScanMode
     */
    private final ScanMode tscpcScanMode

    /**
     * Describes the time for the acquisition of an image area in pixels.
     * The rate is defined as time/px and has the unit ms.
     *
     * e.g. 5ms
     */
    private final Integer scanAcquisitionRate

    /**
     * The size of the scanned area
     * e.g. the area (40,40) in µm of on the image plane xy
     *
     * @see Area
     */
    private final Area scanSize

    /**
     * Creates a description of light microscope parameters during image analysis.
     * @param binning {@link LightMicroscopyParameters#binning}
     * @param excitationPerChannel {@link LightMicroscopyParameters#excitationPerChannel}
     * @param emissionPerChannel {@link LightMicroscopyParameters#emissionPerChannel}
     * @param laserPowerTIRFLens {@link LightMicroscopyParameters#laserPowerTIRFLens}
     * @param laserPowerBeamSplitter {@link LightMicroscopyParameters#laserPowerBeamSplitter}
     * @param cameraAcquisitionTime {@link LightMicroscopyParameters#cameraAcquisitionTime}
     * @param position {@link LightMicroscopyParameters#position}
     * @param tcspcTimingResolution {@link LightMicroscopyParameters#tcspcTimingResolution}
     * @param tcspcPosition {@link LightMicroscopyParameters#tcspcPosition}
     * @param tscpcScanMode {@link LightMicroscopyParameters#tscpcScanMode}
     * @param scanAcquisitionRate {@link LightMicroscopyParameters#scanAcquisitionRate}
     * @param scanSize {@link LightMicroscopyParameters#scanSize}
     */
    LightMicroscopyParameters(Integer binning, List<Integer> excitationPerChannel, List<EmissionRange> emissionPerChannel, Float laserPowerTIRFLens, Float laserPowerBeamSplitter, Float cameraAcquisitionTime, Position position, Integer tcspcTimingResolution, Position tcspcPosition, ScanMode tscpcScanMode, Integer scanAcquisitionRate, Area scanSize) {
        super(binning)
        this.excitationPerChannel = excitationPerChannel
        this.emissionPerChannel = emissionPerChannel
        this.laserPowerTIRFLens = laserPowerTIRFLens
        this.laserPowerBeamSplitter = laserPowerBeamSplitter
        this.cameraAcquisitionTime = cameraAcquisitionTime
        this.position = position
        this.tcspcTimingResolution = tcspcTimingResolution
        this.tcspcPosition = tcspcPosition
        this.tscpcScanMode = tscpcScanMode
        this.scanAcquisitionRate = scanAcquisitionRate
        this.scanSize = scanSize
    }
}
