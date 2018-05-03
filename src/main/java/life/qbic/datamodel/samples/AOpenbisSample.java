/*******************************************************************************
 * QBiC Project Wizard enables users to create hierarchical experiments including different study
 * conditions using factorial design. Copyright (C) "2016" Andreas Friedrich
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package life.qbic.datamodel.samples;

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

  private int tempID;
  private List<Integer> tempParentIDs;
  private String space;
  private String sampleType;
  private String code;
  private String experiment;
  private String Q_SECONDARY_NAME;
  private List<Property> factors;
  private String Q_ADDITIONAL_NOTES;
  private String parent;
  private String Q_EXTERNALDB_ID;
  private List<AOpenbisSample> parents;

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
  AOpenbisSample(String code, String space, String experiment, String secondaryName,
      String additionalNotes, List<Property> factors, String parent, String externalID,
      String sampleType) {
    this.code = code;
    this.space = space;
    this.experiment = experiment;
    this.sampleType = sampleType;
    this.Q_ADDITIONAL_NOTES = additionalNotes;
    this.Q_SECONDARY_NAME = secondaryName;
    this.factors = factors;
    this.parent = parent;
    this.Q_EXTERNALDB_ID = externalID;
  }

  // this is the new version for entities
  AOpenbisSample(int tempID, String secondaryName, String additionalNotes, List<Property> factors,
      String externalID, List<Integer> tempParentIDs, String sampleType) {
    this.tempID = tempID;
    this.sampleType = sampleType;
    this.Q_SECONDARY_NAME = secondaryName;
    this.Q_ADDITIONAL_NOTES = additionalNotes;
    this.Q_EXTERNALDB_ID = externalID;
    this.factors = factors;
    this.tempParentIDs = tempParentIDs;
  }

  // this is the new version for all child samples
  AOpenbisSample(int tempID, List<AOpenbisSample> parents, String sampleType, String secondaryName,
      String externalID, List<Property> newFactors, String additionalNotes) {
    this.parents = parents;
    this.tempID = tempID;
    this.sampleType = sampleType;
    this.Q_SECONDARY_NAME = secondaryName;
    this.Q_ADDITIONAL_NOTES = additionalNotes;
    this.Q_EXTERNALDB_ID = externalID;
    Map<String, Property> oldFactors = new HashMap<String, Property>();
    this.tempParentIDs = new ArrayList<Integer>();
    this.parent = "";
    for (AOpenbisSample s : parents) {
      this.tempParentIDs.add(s.getTempID());
      if (s.getCode() != null)
        parent += s.getCode() + " ";
      for (Property f : s.getFactors()) {
        String lab = f.getLabel();
        if (oldFactors.containsKey(lab)) {
          Property old = oldFactors.get(lab);
          String value = old.getValue() + old.getUnit();
          String newValue = f.getValue() + f.getUnit();
          if (!value.equals(newValue))
            oldFactors.put(lab, new Property(lab, "mixed", old.getType()));
        } else
          oldFactors.put(lab, f);
      }
    }
    this.parent = parent.trim();
    this.factors = new ArrayList<Property>();
    if (parents.size() > 0) {
      for (String lab : parents.get(0).getFactorLabels())
        this.factors.add(oldFactors.get(lab));
    }
    this.factors.addAll(newFactors);
  }

  public List<AOpenbisSample> getParents() {
    return parents;
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

  public void setSpace(String space) {
    this.space = space;
  }

  public String getSpace() {
    return space;
  }

  /**
   * Returns a map of all metadata fields and values of this sample
   * 
   * @return
   */
  public Map<String, String> getValueMap() {
    Map<String, String> res = new HashMap<String, String>();
    res.put("EXPERIMENT", experiment);
    res.put("SPACE", space);
    res.put("SAMPLE TYPE", sampleType);
    res.put("code", code);
    res.put("Q_ADDITIONAL_INFO", Q_ADDITIONAL_NOTES);
    res.put("Q_SECONDARY_NAME", Q_SECONDARY_NAME);
    res.put("Q_EXTERNALDB_ID", Q_EXTERNALDB_ID);
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

  public List<String> getFactorStringsWithoutLabel() {
    List<String> res = new ArrayList<String>();
    for (Property f : factors) {
      String cur = f.getValue(); // TODO null should be empty list
      if (f.hasUnit())
        cur += " " + f.getUnit();
      res.add(cur);
    }
    return res;
  }

  public List<String> getFactorLabels() {
    List<String> res = new ArrayList<String>();
    for (Property f : factors) {
      res.add(f.getLabel());
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

  public String getQ_EXTERNALDB_ID() {
    return Q_EXTERNALDB_ID;
  }

  public void setQ_EXTERNALDB_ID(String extID) {
    this.Q_EXTERNALDB_ID = extID;
  }

  public String getQ_ADDITIONAL_NOTES() {
    return Q_ADDITIONAL_NOTES;
  }

  public String getParent() {
    return parent;
  }

  public String toString() {
    return "<" + sampleType + " " + code + " " + Q_SECONDARY_NAME + ">";
  }

  public Integer getTempID() {
    return tempID;
  }

  public List<Integer> getTempParentIDs() {
    return tempParentIDs;
  }

  public void addFactor(Property factor) {
    this.factors.add(factor);
  }
}
