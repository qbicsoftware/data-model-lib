package life.qbic.datamodel.dtos.general

/**
 * A person without
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @author Sven Fillinger
 * @since <versiontag>
 */
class CommonPerson extends Person {

  static class Builder extends Person.Builder<Builder> {

    Builder(String firstName, String lastName, String emailAddress) {
      super(firstName, lastName, emailAddress)
    }

    @Override
    Person build() {
      return new CommonPerson(this)
    }

    @Override
    protected Builder self() {
      return this
    }
  }

  CommonPerson(Builder<?> builder) {
    super(builder)
  }
}
