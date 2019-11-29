/*******************************************************************************
 * QBiC User DB Tools enables users to add people and affiliations to our mysql user database.
 * Copyright (C) 2016 Andreas Friedrich
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

public class Affiliation {

  private int id;
  private String groupName;
  private String acronym;
  private String institute;
  private String organization;
  private String faculty;
  private int contactPersonID;
  private int headID;
  private String contactPerson;
  private String headName;
  private String street;
  private String zipCode;
  private String city;
  private String country;
  private String webpage;

  public Affiliation(String groupName, String acronym, String organization, String institute,
      String faculty, int contactID, int headID, String street, String zipCode, String city,
      String country, String webpage) {
    this.groupName = groupName;
    this.acronym = acronym;
    this.organization = organization;
    this.institute = institute;
    this.faculty = faculty;
    this.contactPersonID = contactID;
    this.headID = headID;
    this.street = street;
    this.zipCode = zipCode;
    this.city = city;
    this.country = country;
    this.webpage = webpage;
  }

  public Affiliation(int id, String groupName, String acronym, String organization,
      String institute, String faculty, String contact, String head, String street, String zipCode,
      String city, String country, String webpage) {
    this.id = id;
    this.groupName = groupName;
    this.acronym = acronym;
    this.organization = organization;
    this.institute = institute;
    this.faculty = faculty;
    this.contactPerson = contact;
    this.headName = head;
    this.street = street;
    this.zipCode = zipCode;
    this.city = city;
    this.country = country;
    this.webpage = webpage;
  }

  public int getID() {
    return id;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getAcronym() {
    return acronym;
  }

  public String getOrganization() {
    return organization;
  }

  public String getInstitute() {
    return institute;
  }

  public String getFaculty() {
    return faculty;
  }

  public int getContactPersonID() {
    return contactPersonID;
  }

  public int getHeadID() {
    return headID;
  }

  public String getContactPerson() {
    return contactPerson;
  }

  public String getStreet() {
    return street;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public String getWebpage() {
    return webpage;
  }

  public String getHeadName() {
    return headName;
  }

  public String getAddressString() {
    return street + ", " + zipCode + " " + city + ", " + country;
  }
}
