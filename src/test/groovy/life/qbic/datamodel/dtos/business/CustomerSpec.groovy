package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Simple tests for the customer dto class
 *
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

  def "different customers result in different objects"() {
    when: "two different customers are created"
    Customer customer1 = new Customer.Builder("Andrew", "Customer", "a.c@d.ef").build()
    Customer customer2 = new Customer.Builder("Betty", "Customer", "b.c@d.ef").build()

    then: "the customers and their hash code are not equal"
    customer1.hashCode() != customer2.hashCode()
    customer1 != customer2
  }

}
