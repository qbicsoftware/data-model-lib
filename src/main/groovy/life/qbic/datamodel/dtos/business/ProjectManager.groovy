package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.general.Person

/**
 * A project manager specialisation.
 *
 * This class shall be used, when data for a project manager is to be referenced within an
 * application.
 *
 * @since 1.12.0
 */
@EqualsAndHashCode(callSuper = true)
class ProjectManager extends Person {

  static class Builder extends Person.Builder<Builder> {

    Builder(String firstName, String lastName, String emailAddress) {
      super(firstName, lastName, emailAddress)
    }

    @Override
    ProjectManager build() {
      return new ProjectManager(this)
    }

    @Override
    protected Builder self() {
      return this
    }
  }

  ProjectManager(Builder builder) {
    super(builder)
  }
}
