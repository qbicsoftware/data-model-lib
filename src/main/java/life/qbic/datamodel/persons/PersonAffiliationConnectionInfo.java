/*******************************************************************************
 * QBiC User DB Tools enables users to add people and affiliations to our mysql user database.
 * Copyright (C) 2016  Andreas Friedrich
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
package life.qbic.datamodel.persons;

public class PersonAffiliationConnectionInfo {
  
  private int person_id;
  private int affiliation_id;
  private String role;
  
  public PersonAffiliationConnectionInfo(int person_id, int affiliation_id, String role) {
    super();
    this.person_id = person_id;
    this.affiliation_id = affiliation_id;
    this.role = role;
  }
  
  public int getPerson_id() {
    return person_id;
  }
  public int getAffiliation_id() {
    return affiliation_id;
  }
  public String getRole() {
    return role;
  }

}
