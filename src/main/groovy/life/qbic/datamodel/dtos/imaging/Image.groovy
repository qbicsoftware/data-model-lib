package life.qbic.datamodel.dtos.imaging

import life.qbic.datamodel.dtos.imaging.parameters.AcquisitionParameters
import life.qbic.datamodel.dtos.imaging.parameters.AnalysisParameters
import life.qbic.datamodel.dtos.imaging.properties.ImageSize
import life.qbic.datamodel.dtos.imaging.properties.Modality
import life.qbic.datamodel.dtos.imaging.properties.PixelSize

/**
 * This DTO class describes the image resulting from imaging experiments
 *
 * An image class shall be used to describe properties of an image
 * in the context of imaging experiments such as microscopy or tomography.
 *
 * @author Sven Fillinger
 * @since 1.10.0
 */
final class Image {
  /**
   * The image acquisition date.
   *
   * @see Date
   */
  final Date acquisitionDate

  /**
   * Detailed description of image acquisition parameters.
   *
   * @see AcquisitionParameters
   */
  final AcquisitionParameters acquisitionParameters

  /**
   * Detailed description of image analysis parameters
   *
   * @see AnalysisParameters
   */
  final AnalysisParameters analysisParameters

  /**
   * A detailed instrument description that was used to create the image.
   *
   * @see Instrument
   */
  final Instrument instrument

  /**
   * The image identifier in OMERO.
   */
  final Integer imageId

  /**
   * The image modality.
   *
   * @see Modality
   */
  final Modality modality

  /**
   * Information about the image size.
   *
   * @see ImageSize
   */
  final ImageSize imageSize

  /**
   * Information about the time and spacial distribution of
   * a pixel.
   *
   * @see PixelSize
   */
  final PixelSize pixelSize

  /**
   * Describes the resolution of the image.
   * e.g. 5 nm
   *
   */
  final Float resolution

  /**
   * This DTO class describes the image resulting from imaging experiments
   * @param acquisitionDate {@link Image#acquisitionDate}
   * @param acquisitionParameters {@link Image#acquisitionParameters}
   * @param analysisParameters {@link Image#analysisParameters}
   * @param instrument {@link Image#instrument}
   * @param imageId {@link Image#imageId}
   * @param modality {@link Image#modality}
   * @param imageSize {@link Image#imageSize}
   * @param pixelSize {@link Image#pixelSize}
   * @param resolution {@link Image#resolution}
   */
  Image(Date acquisitionDate, AcquisitionParameters acquisitionParameters, AnalysisParameters analysisParameters, Instrument instrument, Integer imageId, Modality modality, ImageSize imageSize, PixelSize pixelSize, Float resolution) {
    this.acquisitionDate = acquisitionDate
    this.acquisitionParameters = acquisitionParameters
    this.analysisParameters = analysisParameters
    this.instrument = instrument
    this.imageId = imageId
    this.modality = modality
    this.imageSize = imageSize
    this.pixelSize = pixelSize
    this.resolution = resolution
  }

  boolean equals(o) {
    if (this.is(o)) return true
    if (getClass() != o.class) return false

    Image image = (Image) o

    if (acquisitionDate != image.acquisitionDate) return false
    if (acquisitionParameters != image.acquisitionParameters) return false
    if (analysisParameters != image.analysisParameters) return false
    if (imageId != image.imageId) return false
    if (imageSize != image.imageSize) return false
    if (instrument != image.instrument) return false
    if (modality != image.modality) return false
    if (pixelSize != image.pixelSize) return false
    if (resolution != image.resolution) return false

    return true
  }

  int hashCode() {
    int result
    result = (acquisitionDate != null ? acquisitionDate.hashCode() : 0)
    result = 31 * result + (acquisitionParameters != null ? acquisitionParameters.hashCode() : 0)
    result = 31 * result + (analysisParameters != null ? analysisParameters.hashCode() : 0)
    result = 31 * result + (instrument != null ? instrument.hashCode() : 0)
    result = 31 * result + (imageId != null ? imageId.hashCode() : 0)
    result = 31 * result + (modality != null ? modality.hashCode() : 0)
    result = 31 * result + (imageSize != null ? imageSize.hashCode() : 0)
    result = 31 * result + (pixelSize != null ? pixelSize.hashCode() : 0)
    result = 31 * result + (resolution != null ? resolution.hashCode() : 0)
    return result
  }
}
