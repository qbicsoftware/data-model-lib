package life.qbic.datamodel.dtos.business

import groovy.transform.builder.Builder

/**
 * This class serves as a simple DTO for customer affiliations
 *
 * @author Sven Fillinger
 * @since 1.11.0
 */
final class Affiliation {

  final String organisation

  final String addressAddition

  final String street

  final String postalCode

  final String city

  final String country

  final AffiliationCategory category

  static class Builder {

    String organisation

    String addressAddition

    String street

    String postalCode

    String city

    String country

    AffiliationCategory category

    Builder(String organisation, String street, String postalCode, String city) {
      this.organisation = organisation
      this.street = street
      this.postalCode = postalCode
      this.city = city
      this.addressAddition = ""
      this.country = ""
      this.category = AffiliationCategory.EXTERNAL
    }

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
  }


}
