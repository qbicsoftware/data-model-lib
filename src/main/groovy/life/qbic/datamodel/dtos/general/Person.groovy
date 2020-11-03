package life.qbic.datamodel.dtos.general

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.AcademicTitle
import life.qbic.datamodel.dtos.business.Affiliation

/**
 * This class serves as a simple DTO for customer data
 *
 * A customer is a person to which QBiC has established
 * any kind of business relationship.
 *
 * @author Sven Fillinger
 * @since 1.11.0
 */
@EqualsAndHashCode
abstract class Person {

  /**
   * The type of person e.g. customer, project manager
   */
  final String personType

  /**
   * The person's first name
   */
  final String firstName

  /**
   * The person's last name
   */
  final String lastName

  /**
   * The person's title
   */
  final AcademicTitle title

  /**
   * The person's email address
   */
  final String eMailAddress

  /**
   * Associated affiliations
   */
  final List<Affiliation> affiliations

  Person(String personType,
         String firstName,
         String lastName,
         AcademicTitle title,
         String eMailAddress,
         List<Affiliation> affiliations) {
    this.personType = Objects.requireNonNull(personType)
    this.firstName = Objects.requireNonNull(firstName)
    this.lastName = Objects.requireNonNull(lastName)
    this.title = Objects.requireNonNull(title)
    this.eMailAddress = Objects.requireNonNull(eMailAddress)
    this.affiliations = new ArrayList<>()
    copyAffiliations(affiliations)
  }

  private copyAffiliations(List<Affiliation> affiliations) {
    for (Affiliation affiliation : affiliations) {
      this.affiliations.add(affiliation)
    }
  }

/**
   * Returns a String representation of a customer:
   *
   * <first-name> <last-name> - <email>
   *
   * @return
   */
  @Override
  String toString(){
    return "${firstName} ${lastName} - ${eMailAddress}"
  }

}
