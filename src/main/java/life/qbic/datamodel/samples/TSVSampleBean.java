package life.qbic.datamodel.samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class TSVSampleBean implements ISampleBean {

  private String code;
  private String experiment;
  private String project;
  private String space;
  private String sampleType;
  private String secondaryName;
  private List<String> parentIDs;
  private Map<String, Object> metadata;

  public TSVSampleBean(String code, String exp, String proj, String space, String sType,
      String secondaryName, List<String> parentIDs, Map<String, Object> metadata) {
    this.code = code;
    this.experiment = exp;
    this.project = proj;
    this.space = space;
    this.sampleType = sType;
    this.secondaryName = secondaryName;
    this.parentIDs = parentIDs;
    this.metadata = metadata;
  }

  public TSVSampleBean(String prelimCode, String sampleType, String secondaryName,
      Map<String, Object> metadata) {
    this.code = prelimCode;
    this.sampleType = sampleType;
    this.secondaryName = secondaryName;
    this.metadata = metadata;
    this.parentIDs = new ArrayList<String>();
  }

  public String toString() {
    return code + "\t" + experiment + "\t" + secondaryName + "\t" + sampleType + "\t"
        + getParentIDs() + "\t" + metadata;
  }

  public boolean hasParents() {
    return parentIDs.isEmpty();
  }

  public List<String> getParentIDs() {
    return parentIDs;
    // if (!hasParents())
    // return new ArrayList<String>();
    // else {
    // if (parents.contains(",")) {
    // ArrayList<String> res = new ArrayList<String>();
    // for (String p : Arrays.asList(getParents().split(","))) {
    // res.add(p.trim());
    // }
    // return res;
    // } else
    // return new ArrayList<String>(Arrays.asList(getParents()));
    // }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof TSVSampleBean) {
      TSVSampleBean b = (TSVSampleBean) o;
      return code.equals(b.getCode());
    } else
      return false;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String id) {
    this.code = id;
  }

  public String getExperiment() {
    return experiment;
  }

  public void setExperiment(String experiment) {
    this.experiment = experiment;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public String getSpace() {
    return space;
  }

  public void setSpace(String space) {
    this.space = space;
  }

  public String getType() {
    return sampleType;
  }

  public void setSampleType(String sampleType) {
    this.sampleType = sampleType;
  }

  public String getSecondaryName() {
    return secondaryName;
  }

  public void setSecondaryName(String secName) {
    this.secondaryName = secName;
  }

  public void setParents(List<ISampleBean> parents) {
    for (ISampleBean p : parents)
      addParent(p);
  }

  public Map<String, Object> getMetadata() {
    return metadata;
  }

  public void setMetadata(HashMap<String, Object> metadata) {
    this.metadata = metadata;
  }

  public void addParent(ISampleBean parent) {
    addParentID(parent.getCode());
  }

  public void addParentID(String id) {
    if (!hasParents())
      parentIDs = new ArrayList<String>();
    parentIDs.add(id);
  }

  @Override
  public int hashCode() {
    return code.hashCode();
  }

  public void addProperty(String key, Object val) {
    metadata.put(key, val);
  }

  @Override
  public ISampleBean copy() {
    TSVSampleBean res = new TSVSampleBean(code, experiment, project, space, sampleType,
        secondaryName, parentIDs, new HashMap<String, Object>(metadata));
    return res;
  }
}
