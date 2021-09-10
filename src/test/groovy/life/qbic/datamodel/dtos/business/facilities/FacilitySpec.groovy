package life.qbic.datamodel.dtos.business.facilities

import spock.lang.Specification

/**
 * Tests for the {@link Facility} enum class
 *
 * @since 2.12.0
 */
class FacilitySpec extends Specification {

    def "given an enum, calling the label function returns the right label"() {

        when:
        String result = facility.label

        then:
        result == expectedLabel

        where:
        facility | expectedLabel
        Facility.CFMB | "CFMB"
        Facility.CFMB_PCT | "Proteomics Facility"
        Facility.IMGAG | "IMGAG"
        Facility.MGM | "MGM"
        Facility.QBIC | "QBIC"
    }

}
