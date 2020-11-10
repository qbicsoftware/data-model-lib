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

  static class Builder extends Person.Builder {

    Builder(String firstName, String lastName, String emailAddress) {
      super(firstName, lastName, emailAddress)
    }

    @Override
    Person build() {
      return new ProjectManager(this)
    }

    @Override
    protected Person.Builder self() {
      return this
    }
  }


  ProjectManager(Builder<?> builder) {
    super(builder)
  }
}
