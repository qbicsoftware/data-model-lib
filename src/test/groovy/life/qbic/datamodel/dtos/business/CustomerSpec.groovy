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
    new Customer.Builder(null, "", "a.b@c.de").build()

    then:
    thrown(NullPointerException)
  }

  def "missing last name shall raise a NullPointerException"() {
    when:
    new Customer.Builder("Max", null, "a.b@c.de").build()

    then:
    thrown(NullPointerException)
  }

  def "missing email name shall raise a NullPointerException"() {
    when:
    new Customer.Builder("Max", "Mustermann", null).build()

    then:
    thrown(NullPointerException)
  }

  def "missing affiliation list shall cause the customer to contain an empty list"() {
    when:
    def customer = new Customer.Builder("Max", "Mustermann", "max@example.com").build()

    then:
    assert customer.affiliations.isEmpty()
  }

}
