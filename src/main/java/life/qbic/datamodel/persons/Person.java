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
package life.qbic.datamodel.persons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Person {
  private String firstName;
  private String lastName;
  private String email;
  private int instituteID;
  private String username;
  private String title;
  private String phone;
  private Map<Integer, RoleAt> affiliationInfo; // ids and roles
  private List<Affiliation> affiliations;

  public Person(String username, String title, String first, String last, String eMail,
      String phone, int affiliationID, String affiliationName, String affRole,
      List<Affiliation> affiliations) {
    super();
    this.username = username;
    this.title = title;
    this.firstName = first;
    this.lastName = last;
    this.email = eMail;
    this.phone = phone;
    this.affiliations = affiliations;
    affiliationInfo = new HashMap<Integer, RoleAt>();
    affiliationInfo.put(affiliationID, new RoleAt(affiliationName, affRole));
  }

  public Person(String username, String title, String first, String last, String eMail,
      String phone, int affiliationID, String affiliationName, String affRole) {
    super();
    this.username = username;
    this.title = title;
    this.firstName = first;
    this.lastName = last;
    this.email = eMail;
    this.phone = phone;
    this.affiliations = new ArrayList<Affiliation>();
    affiliationInfo = new HashMap<Integer, RoleAt>();
    affiliationInfo.put(affiliationID, new RoleAt(affiliationName, affRole));
  }

  public Person(String title, String first, String last, String email) {
    this.title = title;
    this.firstName = first;
    this.lastName = last;
    this.email = email;
    affiliationInfo = new HashMap<Integer, RoleAt>();
  }

  
  

  public Person(String zdvID, String firstName, String lastName, String email, String telephone,
      int instituteID) {
    super();
    this.username = zdvID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = telephone;
    this.instituteID = instituteID;
  }

  public String getUsername() {
    return username;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }
  
  public String getTitle() {
    return title;
  }

  public String getPhone() {
    return phone;
  }

  public int getInstituteID() {
    return instituteID;
  }

  public Map<Integer, RoleAt> getAffiliationInfos() {
    return affiliationInfo;
  }

  public void addAffiliationInfo(int id, String name, String role) {
    affiliationInfo.put(id, new RoleAt(name, role));
  }
  //
  // public int getID() {
  // return id;
  // }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (affiliationInfo == null) {
      if (other.affiliationInfo != null)
        return false;
    } else if (!affiliationInfo.equals(other.affiliationInfo))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (phone == null) {
      if (other.phone != null)
        return false;
    } else if (!phone.equals(other.phone))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    return true;
  }

  public void setAffiliationID(int affiID) {
    RoleAt affi = affiliationInfo.get(-1);
    affiliationInfo.remove(-1);
    affiliationInfo.put(affiID, affi);
  }

  public List<Affiliation> getAffiliations() {
    return affiliations;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName + " (" + email + ")";
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  /**
   * returns a random affiliation with its role for this user
   * 
   * @return
   */
  public RoleAt getOneAffiliationWithRole() {
    Random random = new Random();
    List<Integer> keys = new ArrayList<Integer>(affiliationInfo.keySet());
    Integer randomKey = keys.get(random.nextInt(keys.size()));
    return affiliationInfo.get(randomKey);
  }

}
