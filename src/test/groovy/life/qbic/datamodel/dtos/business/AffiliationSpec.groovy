package life.qbic.datamodel.dtos.business

import spock.lang.Specification

/**
 * Simple test class to assert the correct behaviour of the Affiliation Builder.
 *
 * @author Sven Fillinger
 * @since 1.11.0
 */
class AffiliationSpec extends Specification{

  def "Fluent API shall create an affiliation object"() {
    when:
    Affiliation testAffiliation =
        new Affiliation.Builder("Universität Tübingen",
            "Auf der Morgenstelle 10",
            "72076",
            "Tübingen").
           .build()

    then:
    assert testAffiliation.getOrganisation().equals("Universität Tübingen")
    assert testAffiliation.getCategory().equals(AffiliationCategory.EXTERNAL)
    assert testAffiliation.getCountry().equals("Germany")
  }

}
