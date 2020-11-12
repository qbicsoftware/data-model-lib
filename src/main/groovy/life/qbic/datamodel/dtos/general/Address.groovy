package life.qbic.datamodel.dtos.general

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.Affiliation

/**
 * This class serves as a simple DTO representing an Address
 *
 * @since 1.12.0
 */
@EqualsAndHashCode
final class Address {

    /**
     * DTO representing a customer affiliation @link{Affiliation}.
     */
    final Affiliation affiliation
    /**
     * The street corresponding to the address
     */
    final String street
    /**
     * The zipcode corresponding to the address
     */
    final Integer zipCode
    /**
     * The country associated with the address
     */
    final String country

    static class Builder {

        Affiliation affiliation

        String street

        Integer zipCode

        String country

        Builder(Affiliation affiliation, String street, Integer zipCode, String country) {
            this.affiliation = affiliation
            this.street = street
            this.zipCode = zipCode
            this.country = country
        }

        Address build() {
            return new Address(this)
        }

    }

    private Address(Builder builder) {
        this.affiliation = builder.affiliation
        this.street = builder.street
        this.zipCode = builder.zipCode
        this.country = builder.country
    }

    @Override
    String toString() {
        return "${affiliation.toString()} ${street} ${zipCode.toString()} ${country}"
    }

}

