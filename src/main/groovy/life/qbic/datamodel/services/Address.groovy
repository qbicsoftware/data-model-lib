package life.qbic.datamodel.services

import com.fasterxml.jackson.annotation.JsonProperty

class Address  {

  private String affiliation
  private String street
  private Integer zipCode
  private String country

  /**
   * Get affiliation
   * @return affiliation
   **/
  @JsonProperty("affiliation")
  public String getAffiliation() {
    return affiliation;
  }

  public void setAffiliation(String affiliation) {
    this.affiliation = affiliation;
  }

  public Address affiliation(String affiliation) {
    this.affiliation = affiliation;
    return this;
  }

  /**
   * Get street
   * @return street
   **/
  @JsonProperty("street")
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Address street(String street) {
    this.street = street;
    return this;
  }
  //
  // /**
  //   * Get number
  //   * @return number
  //  **/
  //  @JsonProperty("number")
  //  public Integer getNumber() {
  //    return number;
  //  }
  //
  //  public void setNumber(Integer number) {
  //    this.number = number;
  //  }
  //
  //  public Address number(Integer number) {
  //    this.number = number;
  //    return this;
  //  }

  /**
   * Get zipCode
   * @return zipCode
   **/
  @JsonProperty("zip_code")
  public Integer getZipCode() {
    return zipCode;
  }

  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }

  public Address zipCode(Integer zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  /**
   * Get country
   * @return country
   **/
  @JsonProperty("country")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Address country(String country) {
    this.country = country;
    return this;
  }

  @Override
  public boolean equals(Object a) {
    Address ad = (Address) a
    return ad.affiliation.equals(this.affiliation) && ad.country.equals(this.country) && ad.street.equals(this.street) && ad.zipCode == this.zipCode
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");

    sb.append("    affiliation: ").append(toIndentedString(affiliation)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
//    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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

