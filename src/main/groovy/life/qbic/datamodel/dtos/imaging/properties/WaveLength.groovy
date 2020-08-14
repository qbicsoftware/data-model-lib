package life.qbic.datamodel.dtos.imaging.properties

/**
 * A DTO to describe the wave length of light in the imaging context
 *
 * Whenever the wave length of light in the imaging context needs to be described, this class should be used
 *
 * @author Sven Fillinger
 * @since 1.10.0
 */
class WaveLength {

    /**
     * Describes the wave length of a excitation light source in nm
     * e.g 488 nm
     */
    private final int excitationWaveLength

    /**
     * Describes the wave length of a emission light source in nm
     * Emissions is described in a range of wavelength
     * e.g "495-530" nm
     * todo do we really want to store this as a string?
     */
    private final String emissionWaveLength
}
