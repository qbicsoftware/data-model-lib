package life.qbic.datamodel.dtos.business

/**
 * We define three major business affiliation categories here, which
 * means that we decide between
 *  - internal: An affiliation we consider as within the University of Tübingen or University
 *  Hospital of Tübingen
 *  - external academic: An outside affiliation but an academic institution (public research
 *  institutions)
 *  - external: An outside affiliation but not academic (i.e. private sector, companies, etc)
 */
enum AffiliationCategory {

  INTERNAL("internal"),
  EXTERNAL_ACADEMIC("external academic"),
  EXTERNAL("external non-academic")

  /**
   * Holds the value of the enum
   */
  private final String value

  /**
   * Private constructor to create different AffiliationCategory enum items
   * @param value
   */
  private AffiliationCategory(String value) {
    this.value = value
  }

  /**
   * Returns to the enum item value
   * @return
   */
  String getValue() {
    return this.value
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