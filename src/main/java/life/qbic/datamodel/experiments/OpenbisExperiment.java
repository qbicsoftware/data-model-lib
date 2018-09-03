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
package life.qbic.datamodel.experiments;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class representing an experiment with some metadata
 * 
 * @author Andreas Friedrich
 *
 */
public class OpenbisExperiment {

  private String experimentCode;
  private ExperimentType type;
  private String Q_SECONDARY_NAME;
  private String Q_ADDITIONAL_NOTES;
  private Map<String, Object> properties;
  private int personID;

  Logger logger = LogManager.getLogger(OpenbisExperiment.class);

  /**
   * Creates a new Openbis Experiment
   * 
   * @param code of the experiment
   * @param type Experiment type
   * @param props Map with experimental properties
   */
  public OpenbisExperiment(String code, ExperimentType type, Map<String, Object> props) {
    this.properties = props;
    this.experimentCode = code;
    this.type = type;
  }

  /**
   * Creates a new Openbis Experiment
   * 
   * @param code of the experiment
   * @param type Experiment type
   */
  public OpenbisExperiment(String code, ExperimentType type, int person, Map<String, Object> props) {
    this.properties = props;
    this.experimentCode = code;
    this.type = type;
    this.personID = person;
  }

  public String getExperimentCode() {
    return experimentCode;
  }

  public void setMetadata(Map<String, Object> properties) {
    this.properties = properties;
  }

  public ExperimentType getType() {
    return type;
  }

  public boolean containsProperties() {
    if (properties == null)
      return false;
    else
      return properties.size() > 0;
  }

  public int getPersonID() {
    return personID;
  }

  public Map<String, Object> getMetadata() {
    return properties;
  }

  public String getQ_SECONDARY_NAME() {
    return Q_SECONDARY_NAME;
  }

  public String getQ_ADDITIONAL_NOTES() {
    return Q_ADDITIONAL_NOTES;
  }
  
  public String toString() {
    return getPropertiesString();
  }

  private static String escapeSpecials(String s) {
    return s.replace("#", "%%%").replace("=", ">>>").replace("\n", ";");
  }

  public String getPropertiesString() {
    String res = "";
    for (String key : properties.keySet()) {
      Object val = properties.get(key);
      if (val instanceof List) {
        List<String> list = (List<String>) val;
        String listItems = "";
        for (String item : list)
          listItems += "#" + escapeSpecials(item);
        listItems = listItems.substring(1);
        res += "##" + key + "=" + listItems;
      } else {
        res += "##" + key + "=" + escapeSpecials(String.valueOf(val));
      }
    }
    if (!res.isEmpty())
      res = res.substring(2);
    return "#EXP " + experimentCode + ":" + type + ":{" + res + "}";
  }
}
