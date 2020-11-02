package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.general.Person

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
final class Customer extends Person{

  private static final String TYPE = "customer"

  Customer(String firstName,
           String lastName,
           AcademicTitle title,
           String eMailAddress,
           List<Affiliation> affiliations) {
    super(TYPE,firstName,lastName,title,eMailAddress,affiliations)
  }

}
