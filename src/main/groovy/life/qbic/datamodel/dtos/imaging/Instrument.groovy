package life.qbic.datamodel.dtos.imaging

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.imaging.parameters.ImagingHardware

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
@EqualsAndHashCode
class Instrument {

  /**
   * The manufacturer of the instrument.
   * Examples are 'Leica', 'Zeiss' and many more.
   */
  final String manufacturer

  /**
   * The model type of the instrument.
   */
  final String model

  /**
   * The serial number of the instrument.
   */
  final String serialNumber

  /**
   * The location of the instrument.
   *
   * @see: Location
   */
  final Location location

  /**
   * The type of the instrument.
   * Example: 'Confocal Microscope'.
   */
  final String type

  /**
   * A more detailed description of the
   * hardware setup.
   *
   * @see: ImagingHardware
   */
  final ImagingHardware hardware

  /**
   * DTO that describes an instrument in the imaging context
   * @param manufacturer {@link Instrument#manufacturer}
   * @param model {@link Instrument#model}
   * @param serialNumber {@link Instrument#serialNumber}
   * @param location {@link Instrument#location}
   * @param type {@link Instrument#type}
   * @param hardware {@link Instrument#hardware}
   */
  Instrument(String manufacturer, String model, String serialNumber, Location location, String type, ImagingHardware hardware) {
    this.manufacturer = manufacturer
    this.model = model
    this.serialNumber = serialNumber
    this.location = location
    this.type = type
    this.hardware = hardware
  }
}
