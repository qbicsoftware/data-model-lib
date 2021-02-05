package life.qbic.datamodel.samples


import com.fasterxml.jackson.annotation.JsonProperty;

public class Sample  {

  private String code
  private Location currentLocation
  private List<String> pastLocations

  /**
   * Get code
   * @return code
   **/
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Sample code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get currentLocation
   * @return currentLocation
   **/
  @JsonProperty("current_location")
  public Location getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(Location currentLocation) {
    this.currentLocation = currentLocation;
  }

  public Sample currentLocation(Location currentLocation) {
    this.currentLocation = currentLocation;
    return this;
  }

  /**
   * Get pastLocations
   * @return pastLocations
   **/
  @JsonProperty("past_locations")
  public List<Location> getpastLocations() {
    return pastLocations;
  }

  public void setPastLocations(List<Location> pastLocations) {
    this.pastLocations = pastLocations;
  }

  public Sample pastLocations(List<Location> pastLocations) {
    this.pastLocations = pastLocations;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sample {\n");
    sb.append("    sample code: ").append(toIndentedString(code)).append("\n");
    sb.append("    current location: ").append(toIndentedString(currentLocation)).append("\n");
    sb.append("    past locations: ").append(toIndentedString(pastLocations)).append("\n");
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

