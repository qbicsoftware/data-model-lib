package life.qbic.datamodel.dtos.business

import groovy.transform.CompileStatic

/**
 * A DTO describing Product Identifiers
 *
 * The ProductId should be used as a general class describing identifiers like the {@link OfferId} and the {@link CostEstimateId}.
 * It consists of a fixed Part depending on the product category and an Integer based versioning
 *
 * @since: 1.13.0
 *
 */

@CompileStatic
class ProductId {

    /**
     * The type of the identifier is defined by the implementing identifier
     */
    final private String type

    /**
     * Version of the identifier
     */
    final private String version

    /**
     * Creates an identifier object with the
     *
     * @param type describing the type of the underlying identifier
     * @param version describes the version of the identifier
     */

    ProductId(String type, String version){
        this.type = Objects.requireNonNull(type, "type must not be null")
        this.version= Objects.requireNonNull(type, "version must not be null")

    }

    /**
     * Returns the version of the identifier
     * @return
     */
    String getVersion() {
        return version
    }
    /**
     * Returns the type of the identifier
     * @return
     */
    String getType() {
        return type
    }

    /**
     * Returns a String representation in the format:
     *
     *      [type]_[version]
     *
     * @return A String representation of the identifier
     */
    @Override
    String toString() {
        return type + "_" + version
    }
}