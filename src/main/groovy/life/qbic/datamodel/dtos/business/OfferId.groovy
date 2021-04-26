package life.qbic.datamodel.dtos.business

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode

/**
 * A DTO describing the offer identifier
 *
 * An offer identifier helps to distinguish between offers. It is a {@link TomatoId}
 *
 * @since: 1.12.0
 *
 */
@CompileStatic
@EqualsAndHashCode(callSuper = true)
class OfferId extends TomatoId{
    /**
     * An Offer is identified by the type O
     */
    private static final String TYPE = "O"

    OfferId(String projectConservedPart, String randomPart, String version) {
        super(TYPE,projectConservedPart,randomPart,version)
    }

    @Override
    String toString() {
        return super.toString()
    }
}
