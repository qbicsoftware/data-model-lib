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
package life.qbic.datamodel.entities;

import java.util.List;

public abstract class AExperiment {
  
  private String space;
  private String project;
  private String code;
  
  private List<AOpenbisSample> samples;
  
  public AExperiment(String space, String project, String code) {
    this.space = space;
    this.project = project;
    this.code = code;
  }
  
  public String getID() {
    return "/"+space+"/"+project+"/"+code;
  }
  
  /**
   * Adds a single sample to the list of samples of this experiment
   */
  public void addSample(AOpenbisSample sample) {
    samples.add(sample);
  }
  
  /**
   * Sets the list of samples in this experiment
   */
  public void setSamples(List<AOpenbisSample> samples) {
    this.samples = samples;
  }
  
  public List<AOpenbisSample> getSamples() {
    return samples;
  }
  
}
