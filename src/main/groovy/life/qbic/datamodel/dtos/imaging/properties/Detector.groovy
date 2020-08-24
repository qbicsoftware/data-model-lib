package life.qbic.datamodel.dtos.imaging.properties

/**
 * DTO class for detectors in the imaging context.
 *
 * A detector is used to capture the particle information
 * in the context of imaging analysis.
 *
 * Examples are Charged Coupled Device (CCD), Photomultiplier Tube (PMT)
 * or Backscatter Electron Detector (BSD)
 *
 * @author Sven Fillinger
 * @since 1.10.0
 */

class Detector {

  /**
   * Defines the detector type that has been used to
   * capture particle information.
   */
  private final String type

  /**
   * DTO class for detectors in the imaging context.
   * @param type {@link Detector#type}
   */
  Detector(String type) {
    this.type = type
  }
}
