package life.qbic.datamodel.dtos.imaging.parameters

import life.qbic.datamodel.dtos.imaging.properties.Detector

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
abstract class ImagingHardware {

  /**
   * The objective used in the instrument
   */
  private final String objective

  /**
   * The detector used in the instrument
   */
  private final Detector detector

  abstract static class Builder<T extends Builder<T>> {

    String objective

    Detector detector

    Builder(String objective, Detector detector) {
      this.objective = objective
      this.detector = detector
    }

    abstract ImagingHardware build()

    protected abstract T self()
  }

  ImagingHardware(Builder<?> builder) {
    this.detector = builder.detector
    this.objective = builder.objective
  }

  /**
   * Returns the objective described in the hardware
   *
   * @return The objective type
   */
  String getObjective() {
    return objective
  }

  /**
   * Returns the detector described in the hardware
   *
   * @return The detector type
   * @see Detector
   */
  Detector getDetector() {
    return detector
  }

  boolean equals(o) {
    if (this.is(o)) return true
    if (getClass() != o.class) return false

    ImagingHardware hardware = (ImagingHardware) o

    if (detector != hardware.detector) return false
    if (objective != hardware.objective) return false

    return true
  }

  int hashCode() {
    int result
    result = (objective != null ? objective.hashCode() : 0)
    result = 31 * result + (detector != null ? detector.hashCode() : 0)
    return result
  }
}
