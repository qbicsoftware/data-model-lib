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
  PER_RUN("Run"),
  PER_CYCLE("Cycle"),
  PER_GEL("Gel/HpH"),
  PER_MG("10 mg"),
  PER_MEASUREMENT("Measurement"),
  PER_CHANNEL("Channel"),
  PER_PEPTIDE_CHANNEL("100 µg peptides channel"),
  PER_ML("500 ml"),
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