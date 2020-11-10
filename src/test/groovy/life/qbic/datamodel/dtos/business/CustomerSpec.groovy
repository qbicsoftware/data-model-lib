package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Simple tests for the customer dto class
 *
 * @author Sven Fillinger
 * @since 1.11.0
 */
class CustomerSpec extends Specification{

  def "missing first name shall raise a NullPointerException"() {
    when:
    def customer = new Customer(null, "", AcademicTitle.NONE, "a.b@c.de", [])

    then:
    thrown(NullPointerException)
  }

  def "missing last name shall raise a NullPointerException"() {
    when:
    def customer = new Customer("", null, AcademicTitle.NONE, "a.b@c.de", [])

    then:
    thrown(NullPointerException)
  }

  def "missing email name shall raise a NullPointerException"() {
    when:
    def customer = new Customer("", "", AcademicTitle.NONE, null, [])

    then:
    thrown(NullPointerException)
  }

  def "missing affiliation list shall cause the customer to contain an empty list"() {
    when:
    def customer = new Customer( "", "", AcademicTitle.NONE, "a.b@c.de", null)
    then:
    customer.affiliations != null
    customer.affiliations.isEmpty()
  }

}
