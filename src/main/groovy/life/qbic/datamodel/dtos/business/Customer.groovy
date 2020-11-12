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

  static class Builder extends Person.Builder<Builder> {

    Builder(String firstName, String lastName, String emailAddress) {
      super(firstName, lastName, emailAddress)
    }

    @Override
    Customer build() {
      return new Customer(this)
    }

    @Override
    protected Builder self() {
      return this
    }
  }

  Customer(Builder builder) {
    super(builder)
  }
}
