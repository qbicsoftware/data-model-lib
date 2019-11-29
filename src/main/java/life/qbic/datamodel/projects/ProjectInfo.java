package life.qbic.datamodel.projects;

public class ProjectInfo {

  private String description;
  private String secondaryName;
  private String investigator;
  private String contact;
  private String manager;
  private boolean isPilot;
  private String space;
  private String projectCode;
  private int projectID;

  public ProjectInfo(String space, String code, String description, String secondaryName, boolean isPilot, String investigator,
      String contact, String manager) {
    this.space = space;
    this.projectCode = code;
    this.description = description;
    this.secondaryName = secondaryName;
    this.isPilot = isPilot;
    this.investigator = investigator;
    this.contact = contact;
    this.manager = manager;
  }
  
  public ProjectInfo(String space, String code, String description, String secondaryName, int id) {
    this.space = space;
    this.projectCode = code;
    this.description = description;
    this.secondaryName = secondaryName;
    this.projectID = id;
    this.isPilot = false;
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


  public void setManager(String name) {
    this.manager = name;
  }

  public void setContact(String name) {
    this.contact = name;
  }

  public void setInvestigator(String name) {
    this.investigator = name;
  }

  @Override
  public String toString() {
    String res = projectCode + " (" + secondaryName + ")\n";
    res += "PI: " + investigator + ", ";
    res += "Ctct: " + contact + ", ";
    res += "Mngr: " + manager;
    return res;
  }

  public String getProjectCode() {
    return projectCode;
  }

  public String getSpace() {
    return space;
  }

  public int getProjectID() {
    return projectID;
  }
}
