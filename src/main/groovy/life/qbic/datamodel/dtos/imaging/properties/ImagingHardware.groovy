package life.qbic.datamodel.dtos.imaging.properties

/**
 * Describes hardware properties for an instrument in the imaging context
 *
 * This class describes some basic properties that are shared
 * between hardware of different instruments in the field of imaging.
 *
 * Extend this class, if you want to add hardware-specific properties.
 *
 * @author Sven Fillinger
 * @since 1.10.0
 */
class ImagingHardware {

  /**
   * The objective used in the instrument
   */
  private final Objective objective

  /**
   * The detector used in the instrument
   */
  private final Detector detector

  /**
   * Returns the objective described in the hardware
   * @see: #Objective
   * @return The objective type
   */
  Objective getObjective() {
    return objective // TODO: implement deep copy
  }

  /**
   * Returns the detector described in the hardware
   * @see: #Detector
   * @return The detector type
   */
  Detector getDetector() {
    return detector // TODO: return deep copy
  }

}
