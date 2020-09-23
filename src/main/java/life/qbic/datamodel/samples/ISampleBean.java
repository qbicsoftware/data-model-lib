package life.qbic.datamodel.samples;

import java.util.List;
import java.util.Map;


public interface ISampleBean {

  String getSecondaryName();

  String getCode();

  List<String> getParentIDs();

  SampleType getType();

  boolean hasParents();

  String getProject();

  String getSpace();

  String getExperiment();

  void setProject(String project);

  void setSpace(String space);

  void setExperiment(String experiment);

  Map<String, Object> getMetadata();

  ISampleBean copy();

  /**
   * Given a vocabulary of terms for a propertyName, find if property value(s) of this sample do fit the vocabulary and return all the unknown values in a list
   * @param propertyName name under which the property using the provided vocabulary is stored, e.g. in the metadata property
   * @param vocabulary List of known vocabulary terms for a property
   * @return List of terms that do not fit the vocabulary
   */
  List<String> getUnknownMetadataValuesForVocabulary(String propertyName, List<String> vocabulary);

  /**
   * replace metadata values relating to a certain property
   * @param propertyName name under which the property is stored, e.g. in the metadata property
   * @param oldToNewMetadata map specifying a number of terms and the replacement terms, e.g. when replacing terms not fitting to a vocabulary after user input
   */
  void replaceMetadataValues(String propertyName, Map<String, String> oldToNewMetadata);
}
