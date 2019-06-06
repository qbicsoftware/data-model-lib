package life.qbic.datamodel.services

import com.fasterxml.jackson.annotation.JsonProperty
import java.text.DateFormat
import java.text.SimpleDateFormat

import java.util.Date

class Location  {

  private String name
  private String responsiblePerson
  private String responsibleEmail
  private Address address
  private Status status
  private Date arrivalDate
  private Date forwardDate

  /**
   * Get name
   * @return name
   **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Location name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get responsiblePerson
   * @return responsiblePerson
   **/
  @JsonProperty("responsible_person")
  public String getResponsiblePerson() {
    return responsiblePerson;
  }

  public void setResponsiblePerson(String responsiblePerson) {
    this.responsiblePerson = responsiblePerson;
  }

  public Location responsiblePerson(String responsiblePerson) {
    this.responsiblePerson = responsiblePerson;
    return this;
  }

  /**
   * Get responsibleEmail
   * @return responsibleEmail
   **/
  @JsonProperty("responsible_person_email")
  public String getResponsibleEmail() {
    return responsibleEmail;
  }

  public void setResponsibleEmail(String responsibleEmail) {
    this.responsibleEmail = responsibleEmail;
  }

  public Location responsibleEmail(String responsibleEmail) {
    this.responsibleEmail = responsibleEmail;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  @JsonProperty("address")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Location address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get sample status
   * @return status
   **/
  @JsonProperty("sample_status")
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Location status(Status status) {
    this.status = status;
    return this;
  }

  /**
   * Get arrival_date
   * @return arrivalDate
   **/
  @JsonProperty("arrival_date")
  public String getArrivalDate() {
    return parseDate(arrivalDate);
  }

  public void setArrivalDate(Date arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public Location arrivalDate(Date arrivalDate) {
    this.arrivalDate = arrivalDate;
    return this;
  }

  /**
   * Get forward_date
   * @return forwardDate
   **/
  @JsonProperty("forward_date")
  public String getForwardDate() {
    String res = parseDate(forwardDate)
    return res
  }

  public void setforwardDate(Date forwardDate) {
    this.forwardDate = forwardDate;
  }

  public Location forwardDate(Date forwardDate) {
    this.forwardDate = forwardDate;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    responsible person: ").append(toIndentedString(responsiblePerson)).append("\n");
    sb.append("    responsible person email: ").append(toIndentedString(responsibleEmail)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    sample status: ").append(toIndentedString(status)).append("\n");
    sb.append("    arrival date: ").append(toIndentedString(arrivalDate)).append("\n");
    sb.append("    forward date: ").append(toIndentedString(forwardDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  public boolean equals(Object o) {
    Location a = (Location) o
    return a.status.equals(this.status) && a.address.equals(this.address) && a.getArrivalDate().equals(this.getArrivalDate()) && a.getForwardDate().equals(this.getForwardDate()) && a.name.equals(this.name) && a.responsibleEmail.equals(this.responsibleEmail) && a.responsiblePerson.equals(this.responsiblePerson)
  }

  public String parseDate(Date date) {
    if(date==null)
      return ""
    TimeZone tz = TimeZone.getTimeZone("MEZ");
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    df.setTimeZone(tz);
    return df.format(date);
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return null
    }
    return o.toString().replace("\n", "\n    ");
  }
}

