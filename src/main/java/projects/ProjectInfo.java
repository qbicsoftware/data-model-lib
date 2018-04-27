package projects;

public class ProjectInfo {

  private String description;
  private String secondaryName;
  private String investigator;
  private String contact;
  private String manager;
  private boolean isPilot;

  public ProjectInfo() {}

  public ProjectInfo(String description, String secondaryName, boolean isPilot, String investigator,
      String contact, String manager) {
    this.description = description;
    this.secondaryName = secondaryName;
    this.isPilot = isPilot;
    this.investigator = investigator;
    this.contact = contact;
    this.manager = manager;
  }

  public boolean isPilot() {
    return isPilot;
  }

  public String getDescription() {
    return description;
  }

  public String getSecondaryName() {
    return secondaryName;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setSecondaryName(String secondaryName) {
    this.secondaryName = secondaryName;
  }

  public String getInvestigator() {
    return investigator;
  }

  public String getContact() {
    return contact;
  }

  public String getManager() {
    return manager;
  }

}
