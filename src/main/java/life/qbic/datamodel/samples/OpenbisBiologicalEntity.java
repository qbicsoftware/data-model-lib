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
 * Class representing a biological entity that will be used in an experiment and will be the root of
 * the sample hierarchy
 * 
 * @author Andreas Friedrich
 *
 */
public class OpenbisBiologicalEntity extends AOpenbisSample {

  private String ncbiOrganism;
  private String speciesInfo;

  /**
   * Create a new Biological Entity
   * 
   * @param openbisName Code of the sample
   * @param experiment Experiment the sample is attached to
   * @param secondaryName Secondary name of the sample (e.g. humanly readable identifier)
   * @param additionalNotes Free text notes for the sample
   * @param factors A list of conditions of this sample
   * @param ncbiOrganism The organism the entity belongs to
   * @param specisInfo More information about the species
   * @param extID External database identifier
   */
  public OpenbisBiologicalEntity(String openbisName, String space, String experiment,
      String secondaryName, String additionalNotes, List<Property> factors, String ncbiOrganism,
      String speciesInfo, String extID) {
    super(openbisName, space, experiment, secondaryName, additionalNotes, factors, "", extID,
        "Q_BIOLOGICAL_ENTITY");
    this.ncbiOrganism = ncbiOrganism;
    this.speciesInfo = speciesInfo;
  }

  public Map<String, String> getValueMap() {
    Map<String, String> res = super.getValueMap();
    res.put("Q_NCBI_ORGANISM", ncbiOrganism);
    res.put("Q_ORGANISM_DETAILED", speciesInfo);
    return res;
  }
}
