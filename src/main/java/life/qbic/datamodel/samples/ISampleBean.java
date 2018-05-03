package life.qbic.datamodel.samples;

import java.util.ArrayList;
import java.util.Map;


public interface ISampleBean {

  String getSecondaryName();

  String getCode();

  ArrayList<String> fetchParentIDs();

  String getType();

  boolean hasParents();
  
  String getProject();

  String getSpace();

  String getExperiment();
  
  void setProject(String project);
  
  void setSpace(String space);
  
  void setExperiment(String experiment);

  Map<String, Object> getMetadata();

  ISampleBean copy();

}
