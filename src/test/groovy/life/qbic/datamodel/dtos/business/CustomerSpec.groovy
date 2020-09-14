package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Simple tests for the customer dto class
 *
 * @author Sven Fillinger
 * @since 1.11.0
 */
class CustomerSpec extends Specification{

  def "wrong email shall raisa a validation exception"() {
    when:
    def customer = new Customer(null,"","","test",[])

    then:
    thrown(NullPointerException)
  }

}
