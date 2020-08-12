package life.qbic.datamodel.dtos.imaging.parameters.electronmicroscopy

import life.qbic.datamodel.dtos.imaging.properties.Voltage

/**
 * Describes the properties of electron microscopy
 *
 * This class serves as DTO and contains information about
 * general electron microscope parameters during an image analysis.
 *
 * This class shall be extended, if you need to add more technology-specific
 * properties.
 *
 * @author Sven Fillinger
 * @since 1.0
 */
class ElectronMicroscopyParameters {

    /**
     * Voltage used to accelerate electrons.
     * Applied between cathode and electrode in the acceleration tube
     *
     * It is usually in the range of 500 to 30.000 volts
     */
    private final Voltage acceleratingVoltage

    /**
     * Shift of focus of the objective lens.
     * It is used to observe 'Fresnel fringes', for taking lattice image or structure images.
     *
     * Defocused images occur when the light rays from a point source are not focused on a single point.
     * TODO whats the unit? wavelengths?
     */
    private final Float targetDefocus

    /**
     * The accumulated amount of electrons transmitting the materials
     *
     * Measured in electrons per unit area
     * TODO check if this is correct
     */
    private final Float cumulativeElectronDose
}
