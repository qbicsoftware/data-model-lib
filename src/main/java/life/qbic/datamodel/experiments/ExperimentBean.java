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

/**
 * Bean item representing context with their ID, type and the number of numOfSamples they contain
 * 
 * @author Andreas Friedrich
 *
 */
public class ExperimentBean {

  private String code;
  private String ID;
  private String experiment_type;
  private String numOfSamples;
  private String registrationDate;
  private boolean pilot;

  /**
   * Creates a new ExperimentBean
   * 
   * @param id of experiment
   * @param experimentTypeCode the type code of the experiment
   * @param numOfSamples number of samples in this experiment
   * @param date
   */
  public ExperimentBean(String ID, String experimentTypeCode, String numOfSamples, String date, boolean pilot) {
    this.code = ID.split("/")[3];
    this.ID = ID;
    this.experiment_type = experimentTypeCode;
    this.numOfSamples = numOfSamples;
    this.registrationDate = date;
    this.pilot = pilot;
  }

  public String getDate() {
    return registrationDate;
  }

  public void setDate(String date) {
    this.registrationDate = date;
  }

  public String getID() {
    return ID;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getExperiment_type() {
    return experiment_type;
  }

  public void setExperiment_type(String experiment_type) {
    this.experiment_type = experiment_type;
  }

  public String getSamples() {
    return numOfSamples;
  }

  public void setSamples(String samples) {
    this.numOfSamples = samples;
  }

  public boolean isPilot() {
    return pilot;
  }

}
