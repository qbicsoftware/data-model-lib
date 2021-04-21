package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode

/**
 * This class serves as a simple DTO for customer affiliations
 *
 * @author Sven Fillinger
 * @since 1.11.0
 */
@EqualsAndHashCode
final class Affiliation {

  /**
   * The organisation label of an affiliation.
   *
   * For example "University of Tübingen"
   */
  final String organisation

  /**
   * An optional address addition.
   *
   * Like "Quantitative Biology Center"
   */
  final String addressAddition

  /**
   * The affiliation street
   */
  final String street

  /**
   * The affiliation postal code
   */
  final String postalCode

  /**
   * The affiliation city
   */
  final String city

  /**
   * The affiliation country. Defaults to "Germany" if not set otherwise in the builder.
   */
  final String country

/**
   * An affiliation category @link{AffiliationCategory}.
   *
   * Defaults to 'external non-academic'.
   */
  final AffiliationCategory category

  /**
   * An affiliation label @link{AffiliationLabel}.
   *
   * Defaults to "none".
   */
  final AffiliationLabel label

  static class Builder {

    String organisation

    String addressAddition

    String street

    String postalCode

    String city

    String country

    AffiliationCategory category

    AffiliationLabel label

    Builder(String organisation, String street, String postalCode, String city) {
      this.organisation = organisation
      this.street = street
      this.postalCode = postalCode
      this.city = city
      this.addressAddition = ""
      this.country = "Germany"
      this.category = AffiliationCategory.EXTERNAL
      this.label = AffiliationLabel.MNF
    }

    /**
     * Sets an address addition
     * @param addressAddition
     * @return #Affiliation.Builder
     */
    Builder addressAddition(String addressAddition) {
      this.addressAddition = addressAddition
      return this
    }

    Builder country(String country) {
      this.country = country
      return this
    }

    Builder category(AffiliationCategory category) {
      this.category = category
      return this
    }

    Builder label(AffiliationLabel label) {
      this.label = label
      return this
    }


    Affiliation build() {
      return new Affiliation(this)
    }

  }

  private Affiliation(Builder builder) {
    this.addressAddition = builder.addressAddition
    this.organisation = builder.organisation
    this.street = builder.street
    this.country = builder.country
    this.postalCode = builder.postalCode
    this.category = builder.category
    this.city = builder.city
    this.label = builder.label
  }

  @Override
  String toString() {
    return "${organisation} ${addressAddition}"
  }

}
