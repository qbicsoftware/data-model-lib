package life.qbic.datamodel.dtos.business.services

/**
 * Describes available product units.
 *
 * @since 1.12.0
 */
enum ProductUnit {

  PER_GIGABYTE("Gigabyte"),
  PER_SAMPLE("Sample"),
  PER_DATASET("Dataset"),
  PER_HOUR("Hour"),
  PER_PROJECT("Project"),
  PER_RUN("Run"),
  PER_CYCLE("Cycle"),
  PER_GEL("Gel/HpH"),
  PER_10_MG("10 Milligram"),
  PER_MEASUREMENT("Measurement"),
  PER_CHANNEL("Channel"),
  PER_100_MICROGRAM_PEPTIDE_CHANNEL("100 Microgram peptides channel"),
  PER_500_ML("500 Milliliter"),
  PER_COMPARISON("COMPARISON")

  /**
   Holds the String value of the enum
   */
  private final String value

  /**
   * Private constructor to create different ProductUnit enum items
   * @param value
   */
  private ProductUnit(String value) {
    this.value = value
  }

  /**
   * Returns to the enum item value
   * @return
   */
  String getValue() {
    return value
  }

  /**
   * Returns a String representation of the enum item
   * @return
   */
  @Override
  String toString() {
    return this.getValue()
  }

}
