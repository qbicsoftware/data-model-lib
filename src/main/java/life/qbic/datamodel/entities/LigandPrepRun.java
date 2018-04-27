package life.qbic.datamodel.entities;

public class LigandPrepRun {

  private String sourceID;
  private String tissue;
  private String prepDate;
  private String sampleAmount;

  public LigandPrepRun(String sourceID, String tissue, String prepDate, String sampleAmount) {
    this.sourceID = sourceID;
    this.tissue = tissue;
    this.prepDate = prepDate;
    this.sampleAmount = sampleAmount;
  }

  @Override
  public String toString() {
    return sourceID + " (" + tissue + " " + sampleAmount + ") on " + prepDate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((prepDate == null) ? 0 : prepDate.hashCode());
    result = prime * result + ((sampleAmount == null) ? 0 : sampleAmount.hashCode());
    result = prime * result + ((sourceID == null) ? 0 : sourceID.hashCode());
    result = prime * result + ((tissue == null) ? 0 : tissue.hashCode());
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
    LigandPrepRun other = (LigandPrepRun) obj;
    if (prepDate == null) {
      if (other.prepDate != null)
        return false;
    } else if (!prepDate.equals(other.prepDate))
      return false;
    if (sampleAmount == null) {
      if (other.sampleAmount != null)
        return false;
    } else if (!sampleAmount.equals(other.sampleAmount))
      return false;
    if (sourceID == null) {
      if (other.sourceID != null)
        return false;
    } else if (!sourceID.equals(other.sourceID))
      return false;
    if (tissue == null) {
      if (other.tissue != null)
        return false;
    } else if (!tissue.equals(other.tissue))
      return false;
    return true;
  }


}
