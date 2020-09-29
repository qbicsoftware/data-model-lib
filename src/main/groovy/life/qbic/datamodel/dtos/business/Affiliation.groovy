package life.qbic.datamodel.dtos.business

/**
 * This class serves as a simple DTO for customer affiliations
 *
 * @author Sven Fillinger
 * @since 1.11.0
 */
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

  boolean equals(o) {
    if (this.is(o)) return true
    if (getClass() != o.class) return false

    Affiliation that = (Affiliation) o

    if (addressAddition != that.addressAddition) return false
    if (category != that.category) return false
    if (city != that.city) return false
    if (country != that.country) return false
    if (organisation != that.organisation) return false
    if (postalCode != that.postalCode) return false
    if (street != that.street) return false

    return true
  }

  int hashCode() {
    int result
    result = (organisation != null ? organisation.hashCode() : 0)
    result = 31 * result + (addressAddition != null ? addressAddition.hashCode() : 0)
    result = 31 * result + (street != null ? street.hashCode() : 0)
    result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0)
    result = 31 * result + (city != null ? city.hashCode() : 0)
    result = 31 * result + (country != null ? country.hashCode() : 0)
    result = 31 * result + (category != null ? category.hashCode() : 0)
    return result
  }
/**
   * An affiliation category @link{AffiliationCategory}.
   *
   * Defaults to 'external non-academic'.
   */
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
      this.country = "Germany"
      this.category = AffiliationCategory.EXTERNAL
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
