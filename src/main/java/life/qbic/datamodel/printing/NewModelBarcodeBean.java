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
package life.qbic.datamodel.printing;

import java.util.List;

/**
 * Bean item representing identifier, secondary name, a list of parent samples and qbicobject type of samples to visualize in a table etc.
 * @author Andreas Friedrich
 *
 */
public class NewModelBarcodeBean implements IBarcodeBean {

  private String code;
  private String codedString;
  private String info1;
  private String info2;
  private List<String> parents;
  private String type;
  private String secondaryName;
  private String extID;

  public NewModelBarcodeBean(String code, String codedString, String info1, String info2, String type, List<String> parents, String secondaryName, String extID) {
    this.secondaryName = secondaryName;
    this.code = code;
    this.codedString = codedString;
    this.info1 = info1;
    this.info2 = info2;
    this.type = type;
    this.parents = parents;
    this.extID = extID;
  }
  
  @Override
  public String toString() {
    return code+" "+info1+" "+info2+" "+parents;
  }

  public String getCode() {
    return code;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public List<String> fetchParentIDs() {
    return parents;
  }

  @Override
  public boolean hasParents() {
    return parents.size() > 0;
  }

  @Override
  public String firstInfo() {
    return info1;
  }

  @Override
  public String altInfo() {
    return info2;
  }

  @Override
  public String getCodedString() {
    return codedString;
  }

  @Override
  public String getSecondaryName() {
    return secondaryName;
  }

  @Override
  public String getExtID() {
    return extID;
  }

}
