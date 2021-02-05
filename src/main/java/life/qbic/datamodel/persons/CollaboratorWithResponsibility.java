package life.qbic.datamodel.persons;

public class CollaboratorWithResponsibility {

  private int id;
  private String person;
  private String openbisCode;
  private String openbisIdentifier;
  private String openbisType; // project or type of experiment
  private String role;

  public CollaboratorWithResponsibility(int id, String person, String openbisIdentifier,
      String openbisCode, String role) {
    super();
    this.id = id;
    this.person = person;
    this.openbisIdentifier = openbisIdentifier;
    this.openbisCode = openbisCode;
    this.role = role;
  }

  public int getExperimentID() {
    return id;
  }

  public String getPerson() {
    return person;
  }

  public void setType(String type) {
    this.openbisType = type;
  }

  public String getOpenbisType() {
    return openbisType;
  }

  public String getOpenbisCode() {
    return openbisCode;
  }

  public String getRole() {
    return role;
  }

  public String getOpenbisIdentifier() {
    return openbisIdentifier;
  }



}
