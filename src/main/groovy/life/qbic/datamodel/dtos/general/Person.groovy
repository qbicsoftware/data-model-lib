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
   * @deprecated: Please subclass the Person class instead of using this property.
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

  abstract static class Builder<T extends Builder<T>> {
    String firstName

    String lastName

    AcademicTitle title

    String eMailAddress

    List<Affiliation> affiliations

    Builder(String firstName, String lastName, String emailAddress) {
      this.firstName = Objects.requireNonNull(firstName, "First name must not be null")
      this.lastName = Objects.requireNonNull(lastName, "Last name must not be null")
      this.eMailAddress = Objects.requireNonNull(emailAddress, "Email must not be null")
      this.title = AcademicTitle.NONE
      this.affiliations = new ArrayList<>()
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
    firstName = builder.firstName
    lastName = builder.lastName
    eMailAddress = builder.eMailAddress
    title = builder.title
    affiliations = builder.affiliations
  }

  /**
   * Constructor for a person.
   *
   * @deprecated: Please use the {$link Person.Builder} instead.
   *
   * @param personType
   * @param firstName
   * @param lastName
   * @param title
   * @param eMailAddress
   * @param affiliations
   */
  Person(String personType,
         String firstName,
         String lastName,
         AcademicTitle title,
         String eMailAddress,
         List<Affiliation> affiliations) {
    this.personType = null
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
