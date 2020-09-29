package life.qbic.datamodel.dtos.imaging.parameters

/**
 * Description of acquisition parameters during image analysis.
 *
 * This class serves as DTO and contains information about
 * general acquisition parameters during an image analysis.
 *
 * This class shall be extended, if you need to add more technology-specific
 * properties.
 *
 * @author Sven Fillinger
 * @since 1.10.0
 */
class AcquisitionParameters {

  /**
   * Binning describes the factor by which a pixel is
   * condensed.
   *
   * A binning of 1 means that all 8 pixels surrounding a pixel
   * will be merged into one super pixel.
   *
   * Binning is used to increase contrast with the downside
   * of losing spacial frequency information (resolution).
   *
   * Binning is always a positive Integer value.
   */
  final Integer binning

  /**
   * Creates a description of acquisition parameters during image analysis.
   * @param binning {@link AcquisitionParameters#binning}
   */
  AcquisitionParameters(Integer binning) {
    this.binning = binning
  }

  boolean equals(o) {
    if (this.is(o)) return true
    if (getClass() != o.class) return false

    AcquisitionParameters that = (AcquisitionParameters) o

    if (binning != that.binning) return false

    return true
  }

  int hashCode() {
    return (binning != null ? binning.hashCode() : 0)
  }
}
