package life.qbic.datamodel.dtos.imaging.parameters.electronmicroscopy

import life.qbic.datamodel.dtos.imaging.parameters.AcquisitionParameters
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
 * @since 1.10.0
 */
class ElectronMicroscopyParameters extends AcquisitionParameters{

    /**
     * Voltage is used to accelerate electrons.
     * Applied between cathode and electrode in the acceleration tube
     *
     * @see Voltage
     */
    private final Voltage acceleratingVoltage

    /**
     * Shift of focus of the objective lens.
     * It is used to observe 'Fresnel fringes', for taking lattice image or structure images.
     *
     * Defocused images occur when the light rays from a point source are not focused on a single point.
     *
     * This could be for example -4 nm
     * TODO whats the unit? wavelengths?
     */
    private final Float targetDefocus

    /**
     * The accumulated amount of electrons transmitting the materials
     *
     * Measured in electrons per unit area e.g 100 electrons/Angstrom^2
     * TODO check if this is correct
     */
    private final Float cumulativeElectronDose
}
