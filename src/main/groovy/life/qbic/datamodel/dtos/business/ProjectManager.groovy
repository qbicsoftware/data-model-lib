package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.general.Person

/**
 * <class short description - 1 Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <versiontag>
 */
class ProjectManager extends Person {

  ProjectManager(String personType, String firstName, String lastName, AcademicTitle title, String eMailAddress, List<Affiliation> affiliations) {
    super(personType, firstName, lastName, title, eMailAddress, affiliations)
  }
}
