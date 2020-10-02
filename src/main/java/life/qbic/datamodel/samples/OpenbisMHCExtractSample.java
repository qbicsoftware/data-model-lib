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

public class OpenbisMHCExtractSample extends AOpenbisSample {

  private String Q_MHC_CLASS;
  private String Q_MHC_ANTIBODY;

  public OpenbisMHCExtractSample(String openbisName, String space, String experiment,
      String secondaryName, String additionalNotes, List<Property> factors, String antibody,
      String mhcClass, String parent, String extID) {
    super(openbisName, space, experiment, secondaryName, additionalNotes, factors, parent, extID,
        "Q_MHC_LIGAND_EXTRACT");
    this.Q_MHC_CLASS = mhcClass;
    this.Q_MHC_ANTIBODY = antibody;
  }

  public OpenbisMHCExtractSample(int tempID, List<AOpenbisSample> parents, String mhcClass,
      String secondaryName, String externalID, List<Property> newFactors, String additionalNotes) {
    super(tempID, parents, "Q_MHC_LIGAND_EXTRACT", secondaryName, externalID, newFactors,
        additionalNotes);
    this.Q_MHC_CLASS = mhcClass;
  }

  public Map<String, String> getValueMap() {
    Map<String, String> res = super.getValueMap();
    res.put("Q_MHC_CLASS", Q_MHC_CLASS);
    res.put("Q_ANTIBODY", Q_MHC_ANTIBODY);
    return res;
  }

}
