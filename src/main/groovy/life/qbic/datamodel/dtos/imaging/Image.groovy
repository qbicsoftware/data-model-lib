package life.qbic.datamodel.dtos.imaging

import groovy.transform.EqualsAndHashCode
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
@EqualsAndHashCode
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
}
