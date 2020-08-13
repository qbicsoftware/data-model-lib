package life.qbic.datamodel.dtos.imaging

/**
 * DTO that describes an instrument in the imaging context
 *
 * This class shall be used to describe some basic
 * properties of an instrument that has been used to create an image
 * during for example a microscopy or tomography analysis.
 *
 * @author Sven Fillinger
 * @since 1.10.0
 */
class Instrument {

  /**
   * The manufacturer of the instrument.
   * Examples are 'Leica', 'Zeiss' and many more.
   */
  private final String manufacturer

  /**
   * The model type of the instrument.
   */
  private final String model

  /**
   * The serial number of the instrument.
   */
  private final String serialNumber

  /**
   * The location of the instrument.
   *
   * @see: #Location
   */
  private final Location location

  /**
   * The type of the instrument.
   * Example: 'Confocal Microscope'.
   */
  private final String type

  /**
   * A more detailed description of the
   * hardware setup.
   *
   * @see: #ImagingHardware
   */
  private final ImagingHardware hardware

  /**
   * Returns a deep copy of the imaging hardware.
   *
   * @see: #ImagingHardware
   * @return The imaging hardware setup.
   */
  ImagingHardware getHardware() {
    return this.hardware // TODO implement deep copy
  }

  /**
   * Returns a deep copy of the instrument's location.
   *
   * @see: #Location
   * @return The instrument location.
   */
  Location getLocation() {
    return this.location // TODO implement deep copy
  }

}
