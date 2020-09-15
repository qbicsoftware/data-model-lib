package life.qbic.datamodel.dtos.business

import org.apache.tools.ant.taskdefs.condition.Not

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

/**
 * This class serves as a simple DTO for customer data
 *
 * A customer is a person to which QBiC has established
 * any kind of business relationship.
 *
 * @author Sven Fillinger
 * @since 1.11.0
 */
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
  final String title

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
           String title,
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

}
