package life.qbic.datamodel.experiments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import life.qbic.datamodel.samples.AOpenbisSample;

public class ExperimentModel {

  private int tmpID;
  private String identifier;
  private List<AOpenbisSample> samples;
  private Map<String, Object> properties;

  public ExperimentModel(String identifier, List<AOpenbisSample> samples) {
    this.identifier = identifier;
    this.samples = samples;
    this.properties = new HashMap<String, Object>();
  }

  public ExperimentModel(String expID) {
    this.identifier = expID;
    this.samples = new ArrayList<AOpenbisSample>();
    this.properties = new HashMap<String, Object>();
  }

  public ExperimentModel(int tmpID, List<AOpenbisSample> samples) {
    this.tmpID = tmpID;
    this.samples = samples;
    this.properties = new HashMap<String, Object>();
  }

  public ExperimentModel(int tmpID) {
    this.tmpID = tmpID;
    this.samples = new ArrayList<AOpenbisSample>();
    this.properties = new HashMap<String, Object>();
  }

  public ExperimentModel(ExperimentModel m) {
    this.tmpID = m.tmpID;
    this.identifier = m.identifier;
    this.samples = new ArrayList<AOpenbisSample>(m.getSamples());
    this.properties = new HashMap<String, Object>(m.properties);
  }

  public Map<String, Object> getProperties() {
    return properties;
  }

  public String getID() {
    return identifier;
  }

  public void setID(String id) {
    this.identifier = id;
  }

  public int getTmpID() {
    return tmpID;
  }

  public List<AOpenbisSample> getSamples() {
    return samples;
  }

  public void addSample(AOpenbisSample s) {
    this.samples.add(s);
  }

  public void addProperty(String key, Object val) {
    this.properties.put(key, val);
  }

  public void setProperties(Map<String, Object> props) {
    this.properties = props;
  }

}
