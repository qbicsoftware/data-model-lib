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

import java.util.List;
import java.util.Map;

import life.qbic.xml.properties.Property;

/**
 * Class representing a sample created in a sample preparation that will be used to measure data
 * 
 * @author Andreas Friedrich
 *
 */
public class OpenbisTestSample extends AOpenbisSample {

  String Q_SAMPLE_TYPE;

  /**
   * Create a new Test Sample
   * 
   * @param openbisName Code of the sample
   * @param experiment Experiment the sample is attached to
   * @param secondaryName Secondary Name of the sample (e.g. humanly readable identifier)
   * @param additionalNotes Free text notes for the sample
   * @param factors A list of conditions of this sample
   * @param sampleType Measurement type of this sample (e.g. protein)
   * @param parent Extract parent of this sample
   */
  public OpenbisTestSample(String openbisName, String space, String experiment,
      String secondaryName, String additionalNotes, List<Property> factors, String sampleType,
      String parent, String extID) {
    super(openbisName, space, experiment, secondaryName, additionalNotes, factors, parent, extID,
        "Q_TEST_SAMPLE");
    this.Q_SAMPLE_TYPE = sampleType;
  }

  public OpenbisTestSample(int tempID, List<AOpenbisSample> parents, String sampleType,
      String secondaryName, String externalID, List<Property> newFactors, String additionalNotes) {
    super(tempID, parents, "Q_TEST_SAMPLE", secondaryName, externalID, newFactors, additionalNotes);
    this.Q_SAMPLE_TYPE = sampleType;
  }

  public Map<String, String> getValueMap() {
    Map<String, String> res = super.getValueMap();
    res.put("Q_SAMPLE_TYPE", Q_SAMPLE_TYPE);
    return res;
  }

}
