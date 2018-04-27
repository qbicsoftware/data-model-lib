package life.qbic.datamodel.entities;

public class MSRunCollection {

  private LigandPrepRun ligandPrep;
  private String runDate;
  
  public MSRunCollection(LigandPrepRun ligandPrep, String runDate) {
    this.ligandPrep = ligandPrep;
    this.runDate = runDate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ligandPrep == null) ? 0 : ligandPrep.hashCode());
    result = prime * result + ((runDate == null) ? 0 : runDate.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MSRunCollection other = (MSRunCollection) obj;
    if (ligandPrep == null) {
      if (other.ligandPrep != null)
        return false;
    } else if (!ligandPrep.equals(other.ligandPrep))
      return false;
    if (runDate == null) {
      if (other.runDate != null)
        return false;
    } else if (!runDate.equals(other.runDate))
      return false;
    return true;
  }
  
  
  
}
