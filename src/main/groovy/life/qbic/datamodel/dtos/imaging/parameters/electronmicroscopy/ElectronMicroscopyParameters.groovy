package life.qbic.datamodel.dtos.imaging.parameters.electronmicroscopy

import life.qbic.datamodel.dtos.imaging.parameters.AcquisitionParameters

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
     * e.g 120 kV
     */
    final Integer acceleratingVoltage

    /**
     * Shift of focus of the objective lens.
     * It is used to observe 'Fresnel fringes', for taking lattice image or structure images.
     *
     * The defocus value is a parameter of the contrast transfer function in electron microscopy.
     *
     * This could be for example -4 nm.
     * Usually this value is negative.
     */
    final Float targetDefocus

    /**
     * The accumulated amount of electrons that are applied to an area of the sample
     *
     * Measured in electrons per unit area e.g 100 electrons/Angstrom^2
     */
    final Float cumulativeElectronDose

    /**
     * Creates a description of the properties of electron microscopy
     * @param binning {@link ElectronMicroscopyParameters#binning}
     * @param acceleratingVoltage {@link ElectronMicroscopyParameters#acceleratingVoltage}
     * @param targetDefocus {@link ElectronMicroscopyParameters#targetDefocus}
     * @param cumulativeElectronDose {@link ElectronMicroscopyParameters#cumulativeElectronDose}
     */
    ElectronMicroscopyParameters(Integer binning, Integer acceleratingVoltage, Float targetDefocus, Float cumulativeElectronDose) {
        super(binning)
        this.acceleratingVoltage = acceleratingVoltage
        this.targetDefocus = targetDefocus
        this.cumulativeElectronDose = cumulativeElectronDose
    }
}
