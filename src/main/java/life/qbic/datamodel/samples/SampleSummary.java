package life.qbic.datamodel.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SampleSummary implements Comparable<SampleSummary> {

  private int id;
  private Set<Integer> parentIDs;
  private List<ISampleBean> samples;
  private List<String> codes;
  private Set<Integer> childIDs;
  private String name;
  private String source;
  private String factorValue;
  private String sampleType;
  private int measuredPercent;
  private int amount;
  private boolean leaf;

  public SampleSummary(int id, Set<Integer> parentIDs, List<ISampleBean> samples,
      String factorValue, String name, String sampleType, boolean isLeaf) {
    this.samples = samples;
    this.parentIDs = parentIDs;
    this.name = name;
    this.factorValue = factorValue;
    this.id = id;
    this.leaf = isLeaf;
    childIDs = new HashSet<Integer>();
    this.amount = samples.size();
    this.sampleType = sampleType;
    addCodes(samples);
  }

  private void addCodes(List<ISampleBean> samples) {
    if (codes == null)
      codes = new ArrayList<String>();
    for (ISampleBean s : samples)
      codes.add(s.getCode());
  }

  public void setLeaf(boolean isLeaf) {
    this.leaf = isLeaf;
  }

  public boolean getLeaf() {
    return leaf;
  }

  @Override
  public String toString() {
    String res = "id=" + id + " (" + amount + "*" + name + ")-->(";
    for (int c : childIDs)
      res += "id " + c + ",";
    if (childIDs.size() > 0)
      res = res.substring(0, res.length() - 1);
    return res + ")";
  }

  public Set<Integer> getChildIDs() {
    return childIDs;
  }

  public void setChildIDs(Set<Integer> childIDs) {
    this.childIDs = childIDs;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<ISampleBean> getSamples() {
    return samples;
  }

  public void setSamples(List<ISampleBean> samples) {
    this.samples = samples;
    this.amount = samples.size();
    codes = new ArrayList<String>();
    addCodes(samples);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getCodes() {
    return codes;
  }

  public void setCodes(List<String> codes) {
    this.codes = codes;
  }

  public int getMeasuredPercent() {
    return measuredPercent;
  }

  public void setMeasuredPercent(int measured) {
    this.measuredPercent = measured;
  }

  public int getAmount() {
    return amount;
  }

  public String getSampleType() {
    return sampleType;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public void addSample(ISampleBean sample) {
    amount++;
    samples.add(sample);
    addCodes(new ArrayList<ISampleBean>(Arrays.asList(sample)));
  }

  public void addChildID(int updated) {
    childIDs.add(updated);
  }

  public String getFactorValue() {
    return factorValue;
  }

  public String getSource() {
    return source;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((factorValue == null) ? 0 : factorValue.hashCode());
     result = prime * result + (leaf ? 1231 : 1237);
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((parentIDs == null) ? 0 : parentIDs.hashCode());
    result = prime * result + ((source == null) ? 0 : source.hashCode());
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
    SampleSummary other = (SampleSummary) obj;
    if (factorValue == null) {
      if (other.factorValue != null)
        return false;
    } else if (!factorValue.equals(other.factorValue))
      return false;
     if (leaf != other.leaf)
     return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (parentIDs == null) {
      if (other.parentIDs != null)
        return false;
    } else if (!parentIDs.equals(other.parentIDs))
      return false;
    if (source == null) {
      if (other.source != null)
        return false;
    } else if (!source.equals(other.source))
      return false;
    return true;
  }

  @Override
  public int compareTo(SampleSummary s) {
    return Integer.toString(this.id).compareTo(Integer.toString(s.id));
  }

}
