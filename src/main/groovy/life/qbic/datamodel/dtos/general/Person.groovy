package life.qbic.datamodel.dtos.general

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.AcademicTitle
import life.qbic.datamodel.dtos.business.Affiliation

/**
 * This class serves as simple DTO for common person data.
 *
 * @author Sven Fillinger
 * @since 1.11.0
 */
@EqualsAndHashCode
abstract class Person {

  /**
   * Person type.
   *
   * @deprecated Please subclass the Person class instead of using this property.
   */
  final String personType

  /**
   * The database id of a person.
   *
   * For example "1"
   */
  final int id

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
  final String emailAddress

  /**
   * Associated affiliations
   */
  final List<Affiliation> affiliations

  abstract static class Builder<T extends Builder<T>> {

    int id

    String firstName

    String lastName

    AcademicTitle title

    String emailAddress

    List<Affiliation> affiliations

    Builder(String firstName, String lastName, String emailAddress) {
      this.firstName = Objects.requireNonNull(firstName, "First name must not be null")
      this.lastName = Objects.requireNonNull(lastName, "Last name must not be null")
      this.emailAddress = Objects.requireNonNull(emailAddress, "Email must not be null")
      this.title = AcademicTitle.NONE
      this.affiliations = new ArrayList<>()
    }

    T id(int id) {
      this.id = id
      return self()
    }

    T title(AcademicTitle title) {
      this.title = title
      return self()
    }

    T affiliation(Affiliation affiliation) {
      this.affiliations.add(affiliation)
      return self()
    }

    T affiliations(List<Affiliation> affiliations) {
      this.affiliations.addAll(affiliations)
      return self()
    }

    abstract Person build()

    /**
     * Needs to be overridden my sub classes.
     * @return
     */
    protected abstract T self()

  }

  Person(Builder<?> builder) {
    id = builder.id
    firstName = builder.firstName
    lastName = builder.lastName
    emailAddress = builder.emailAddress
    title = builder.title
    affiliations = builder.affiliations
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
    return "${firstName} ${lastName} - ${emailAddress}"
  }

}
