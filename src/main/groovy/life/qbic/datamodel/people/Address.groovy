package life.qbic.datamodel.people

import com.fasterxml.jackson.annotation.JsonProperty

class Address  {

  private String affiliation = ""
  private String street = ""
  private Integer zipCode = 0
  private String country = ""

  /**
   * Get affiliation
   * @return affiliation
   **/
  @JsonProperty("affiliation")
  String getAffiliation() {
    return affiliation;
  }

  void setAffiliation(String affiliation) {
    this.affiliation = affiliation;
  }

  Address affiliation(String affiliation) {
    this.affiliation = affiliation;
    return this;
  }

  /**
   * Get street
   * @return street
   **/
  @JsonProperty("street")
  String getStreet() {
    return street;
  }

  void setStreet(String street) {
    this.street = street;
  }

  Address street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Get zipCode
   * @return zipCode
   **/
  @JsonProperty("zip_code")
  Integer getZipCode() {
    return zipCode;
  }

  void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }

  Address zipCode(Integer zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  /**
   * Get country
   * @return country
   **/
  @JsonProperty("country")
  String getCountry() {
    return country;
  }

  void setCountry(String country) {
    this.country = country;
  }

  Address country(String country) {
    this.country = country;
    return this;
  }

  @Override
  boolean equals(Object a) {
    Address ad = (Address) a
    return ad.affiliation.equals(this.affiliation) && ad.country.equals(this.country) && ad.street.equals(this.street) && ad.zipCode == this.zipCode
  }

  @Override
  String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    sb.append("    affiliation: ").append(toIndentedString(affiliation)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

