package life.qbic.datamodel.dtos.imaging

import life.qbic.datamodel.dtos.imaging.parameters.AcquisitionParameters
import life.qbic.datamodel.dtos.imaging.parameters.AnalysisParameters
import life.qbic.datamodel.dtos.imaging.properties.ImageSize
import life.qbic.datamodel.dtos.imaging.properties.Modality
import life.qbic.datamodel.dtos.imaging.properties.PixelSize
import life.qbic.datamodel.dtos.imaging.properties.Resolution

/**
 * This DTO class describes an image resulted from imaging analysis
 *
 * An image class shall be used to describe properties of an image
 * in the context of imaging analysis such as microscopy or tomography.
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
  private final Date acquisitionDate

  /**
   * Detailed description of the image acquisition parameters.
   *
   * @see AcquisitionParameters
   */
  private final AcquisitionParameters acquisitionParameters

  /**
   *
   */
  private final AnalysisParameters analysisParameters

  /**
   * A detailed instrument description that was used to create the image.
   */
  private final Instrument instrument

  /**
   * The image identifier in OMERO.
   */
  private final Integer imageId

  /**
   * The image modality.
   *
   * @see Modality
   */
  private final Modality modality

  /**
   * Information about tHe image size.
   *
   * @see ImageSize
   */
  private final ImageSize imageSize

  /**
   * Information about the time and spacial distribution of
   * a pixel.
   *
   * @see PixelSize
   */
  private final PixelSize pixelSize

  /**
   * Describes the resolution of the image.
   *
   * @see Resolution
   */
  private final Resolution resolution

  /**
   * Returns detailed image acquisition parameters.
   * @return Image acquisition parameters.
   */
  AcquisitionParameters getAcquisionParameters() {
    return this.acquisitionParameters // TODO return deep copy
  }

  /**
   * Returns detailed image analysis parameters.
   * @return Image analysis parameters.
   */
  AnalysisParameters getAnalysisParameters() {
    return this.analysisParameters // TODO return deep copy
  }

  /**
   * Returns detailed instrument information.
   * @return Image instrument information.
   */
  Instrument getInstrument(){
    return this.instrument // TODO return deep copy
  }

  /**
   * Returns the image size of an image.
   * @return The actual image size.
   */
  ImageSize getImageSize(){
    return this.imageSize // TODO return deep copy
  }

  /**
   * Returns the pixel size.
   * @return The actual pixel size.
   */
  PixelSize getPixelSize(){
    return this.pixelSize // TODO return deep copy
  }

  /**
   * Returns image resolution information.
   * @return THe image resolution.
   */
  Resolution getResolution(){
    return this.resolution // TODO return deep copy
  }
}
