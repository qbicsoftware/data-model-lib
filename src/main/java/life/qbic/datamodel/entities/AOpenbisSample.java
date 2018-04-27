package life.qbic.datamodel.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import life.qbic.xml.properties.Property;

/**
 * Abstract class to represent different samples and their metadata
 * 
 * @author Andreas Friedrich
 * 
 */
public abstract class AOpenbisSample {

  String sampleType;
  String code;
  String experiment;
  String Q_SECONDARY_NAME;
  List<Property> factors;
  String Q_ADDITIONAL_NOTES;
  String parent;

  /**
   * Constructor of an abstract openbis sample
   * 
   * @param code The sample code of the sample
   * @param experiment The experiment the sample is attached to
   * @param secondaryName A secondary name the sample might have
   * @param additionalNotes Free text additional notes
   * @param factors A list of conditions of this sample
   * @param parent A parent sample code this sample is attached to
   */
  AOpenbisSample(String code, String experiment, String secondaryName, String additionalNotes,
      List<Property> factors, String parent) {
    this.code = code;
    this.experiment = experiment;
    this.Q_ADDITIONAL_NOTES = additionalNotes;
    this.Q_SECONDARY_NAME = secondaryName;
    this.factors = factors;
    this.parent = parent;
  }

  public void setSampleType(String sampleType) {
    this.sampleType = sampleType;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setExperiment(String experiment) {
    this.experiment = experiment;
  }

  public void setQ_SECONDARY_NAME(String q_SECONDARY_NAME) {
    Q_SECONDARY_NAME = q_SECONDARY_NAME;
  }

  public void setFactors(List<Property> factors) {
    this.factors = factors;
  }

  public void setQ_ADDITIONAL_NOTES(String q_ADDITIONAL_NOTES) {
    Q_ADDITIONAL_NOTES = q_ADDITIONAL_NOTES;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  /**
   * Returns a map of all metadata fields and values of this sample
   * 
   * @return
   */
  public Map<String, String> getValueMap() {
    Map<String, String> res = new HashMap<String, String>();
    res.put("EXPERIMENT", experiment);
    res.put("SAMPLE TYPE", sampleType);
    res.put("code", code);
    res.put("Q_ADDITIONAL_INFO", Q_ADDITIONAL_NOTES);
    res.put("Q_SECONDARY_NAME", Q_SECONDARY_NAME);
    res.put("PARENT", parent);
    fillInFactors(res);
    return res;
  }

  /**
   * Parses XML properties to the right format
   * 
   * @param map
   */
  private void fillInFactors(Map<String, String> map) {
    String res = "";
    for (Property f : factors) {
      res += f.getLabel() + ": " + f.getValue(); // TODO null should be empty list
      if (f.hasUnit())
        res += ":" + f.getUnit();
      res += "; ";
    }
    res = res.substring(0, Math.max(res.length() - 2, 0));
    map.put("XML_FACTORS", res);
  }

  public List<String> getFactorStrings() {
    List<String> res = new ArrayList<String>();
    for (Property f : factors) {
      String cur = f.getLabel() + ": " + f.getValue(); // TODO null should be empty list
      if (f.hasUnit())
        cur += " " + f.getUnit();
      res.add(cur);
    }
    return res;
  }

  public String getCode() {
    return code;
  }

  public String getQ_SECONDARY_NAME() {
    return Q_SECONDARY_NAME;
  }

  public List<Property> getFactors() {
    return factors;
  }

  public String getQ_ADDITIONAL_NOTES() {
    return Q_ADDITIONAL_NOTES;
  }

  public String getParent() {
    return parent;
  }

  public String toString() {
    return sampleType + " " + code + " " + Q_SECONDARY_NAME;
  }
}
