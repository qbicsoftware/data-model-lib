package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode

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
final class Customer {

  /**
   * The customer's first name
   */
  final String firstName

  /**
   * The customer's last name
   */
  final String lastName

  /**
   * The customer's title
   */
  final AcademicTitle title

  /**
   * The customer's email address
   */
  final String eMailAddress

  /**
   * Associated affiliations
   */
  final List<Affiliation> affiliations

  Customer(String firstName,
           String lastName,
           AcademicTitle title,
           String eMailAddress,
           List<Affiliation> affiliations) {
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
