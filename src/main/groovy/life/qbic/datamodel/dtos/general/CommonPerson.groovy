package life.qbic.datamodel.dtos.general

import groovy.transform.EqualsAndHashCode

/**
 * A person without a specific context.
 *
 * Can be used, if the context or role is not relevant.
 *
 * @since 1.12.0
 */
@EqualsAndHashCode(excludes = ["id"], callSuper = true)
class CommonPerson extends Person {

  static class Builder extends Person.Builder<Builder> {

    Builder(String firstName, String lastName, String emailAddress) {
      super(firstName, lastName, emailAddress)
    }

    @Override
    CommonPerson build() {
      return new CommonPerson(this)
    }

    @Override
    protected Builder self() {
      return this
    }
  }

  CommonPerson(Builder builder) {
    super(builder)
  }
}
