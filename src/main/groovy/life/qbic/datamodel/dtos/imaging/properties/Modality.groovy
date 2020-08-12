package life.qbic.datamodel.dtos.imaging.properties

/**
 * Enumeration of different microscopy and spectroscopy modalities.
 *
 * This enum class should be used, whenever a imaging modality needs
 * to be described.
 *
 * Every modality needs to have a meaningful and descriptive label.
 * Abbreviations are discouraged.
 */
enum Modality {

  ANISOTROPY("Anisotropic microscopy"),
  CLSM("Confocal laser scanning microscopy"),
  DSTOR("Direct stochastic optical reconstruction microscopy"),
  FLCS("Fluorescence lifetime correlation spectroscopy"),
  FLIM("Fluorescence lifetime imaging microscopy"),
  SPECTROSCOPY("Spectroscopy"),
  SPT_PALM("Photo-activated localization microscopy"),
  SEM("Scanning electron microscopy")

  private String value

  private Modality(String value) {
    this.value = value
  }

  /**
   * The string representation of the modality item.
   * @return
   */
  String getValue() {
    return this.value
  }

  /**
   * The <code>toString()</code> method is overridden to return the String
   * representation of a modality item. This is equivalent
   * to the <code>getValue()</code> return value.
   *
   * @return The String representation of the modality item
   */
  @Override
  String toString() {
    return this.getValue()
  }

}