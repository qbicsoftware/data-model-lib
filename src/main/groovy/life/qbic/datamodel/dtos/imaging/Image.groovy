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
  private final Date acquisitionDate

  /**
   * Detailed description of image acquisition parameters.
   *
   * @see AcquisitionParameters
   */
  private final AcquisitionParameters acquisitionParameters

  /**
   * Detailed description of image analysis parameters
   *
   * @see AnalysisParameters
   */
  private final AnalysisParameters analysisParameters

  /**
   * A detailed instrument description that was used to create the image.
   *
   * @see Instrument
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
   * Information about the image size.
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
   * e.g. 5 nm
   *
   */
  private final Float resolution

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
/**
   * Returns detailed image acquisition parameters.
   * @return Image acquisition parameters.
   */
  AcquisitionParameters getAcquisitionParameters() {
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
   * @return The image resolution.
   */
  Float getResolution(){
    return this.resolution // TODO return deep copy
  }
}
