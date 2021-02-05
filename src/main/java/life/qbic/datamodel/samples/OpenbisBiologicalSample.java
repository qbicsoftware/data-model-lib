/*******************************************************************************
 * QBiC Project Wizard enables users to create hierarchical experiments including different study conditions using factorial design.
 * Copyright (C) "2016"  Andreas Friedrich
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package life.qbic.datamodel.samples;

import java.util.List;
import java.util.Map;

import life.qbic.xml.properties.Property;

/**
 * Class representing a sample created in a sample extraction experiment and from which test samples
 * may be prepared
 * 
 * @author Andreas Friedrich
 * 
 */
public class OpenbisBiologicalSample extends AOpenbisSample {

  String primaryTissue;
  String tissueDetailed;

  /**
   * Create a new Biological Sample
   * 
   * @param openbisName Code of the sample
   * @param experiment Experiment the sample is attached to
   * @param secondaryName Secondary name of the sample (e.g. humanly readable identifier)
   * @param additionalNotes Free text notes for the sample
   * @param factors A list of conditions for the sample
   * @param primaryTissue The primary tissue of this biological sample
   * @param tissueDetailed Detailed tissue information
   * @param parent Entity parent this sample was extracted from
   */
  public OpenbisBiologicalSample(String openbisName, String space, String experiment,
      String secondaryName, String additionalNotes, List<Property> factors, String primaryTissue,
      String tissueDetailed, String parent, String extID) {
    super(openbisName, space, experiment, secondaryName, additionalNotes, factors, parent, extID,
        "Q_BIOLOGICAL_SAMPLE");
    this.primaryTissue = primaryTissue;
    this.tissueDetailed = tissueDetailed;
  }

  public OpenbisBiologicalSample(int tempID, List<AOpenbisSample> parents, String primaryTissue,
      String tissueDetailed, String secondaryName, String externalID, List<Property> newFactors,
      String additionalNotes) {
    super(tempID, parents, "Q_BIOLOGICAL_SAMPLE", secondaryName, externalID, newFactors, additionalNotes);
    this.primaryTissue = primaryTissue;
    this.tissueDetailed = tissueDetailed;
  }

  public Map<String, String> getValueMap() {
    Map<String, String> res = super.getValueMap();
    res.put("Q_PRIMARY_TISSUE", primaryTissue);
    res.put("Q_TISSUE_DETAILED", tissueDetailed);
    return res;
  }
}
