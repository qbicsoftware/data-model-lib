package life.qbic.datamodel.ms;

import java.util.HashMap;
import java.util.Map;

public class MSProperties {

  private String lcmsMethod;
  private String device;
  private String lcmsDescription;
  private String chromatographyType;

  public MSProperties(String lcmsMethod, String device, String lcmsDescription,
      String chromatographyType) {
    super();
    this.lcmsMethod = lcmsMethod;
    this.device = device;
    this.lcmsDescription = lcmsDescription;
    this.chromatographyType = chromatographyType;
  }

  public String getLcmsMethod() {
    return lcmsMethod;
  }

  public String getDevice() {
    return device;
  }

  public String getLcmsDescription() {
    return lcmsDescription;
  }

  public String getChromatographyType() {
    return chromatographyType;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((chromatographyType == null) ? 0 : chromatographyType.hashCode());
    result = prime * result + ((device == null) ? 0 : device.hashCode());
    result = prime * result + ((lcmsDescription == null) ? 0 : lcmsDescription.hashCode());
    result = prime * result + ((lcmsMethod == null) ? 0 : lcmsMethod.hashCode());
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
    MSProperties other = (MSProperties) obj;
    if (chromatographyType == null) {
      if (other.chromatographyType != null)
        return false;
    } else if (!chromatographyType.equals(other.chromatographyType))
      return false;
    if (device == null) {
      if (other.device != null)
        return false;
    } else if (!device.equals(other.device))
      return false;
    if (lcmsDescription == null) {
      if (other.lcmsDescription != null)
        return false;
    } else if (!lcmsDescription.equals(other.lcmsDescription))
      return false;
    if (lcmsMethod == null) {
      if (other.lcmsMethod != null)
        return false;
    } else if (!lcmsMethod.equals(other.lcmsMethod))
      return false;
    return true;
  }

  public Map<String, Object> getPropertyMap() {
    Map<String, Object> res = new HashMap<String, Object>();
    if (device != null)
      res.put("Q_MS_DEVICE", device);
    if (lcmsMethod != null)
      res.put("Q_MS_LCMS_METHOD", lcmsMethod);
    if (chromatographyType != null)
      res.put("Q_CHROMATOGRAPHY_TYPE", chromatographyType);
    if (!lcmsDescription.isEmpty())
      res.put("Q_MS_LCMS_METHOD_INFO", lcmsDescription);
    return res;
  }

}
