package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode

/**
 * A DTO describing Product Identifiers
 *
 * The ProductId should be used as a general class describing identifiers like the {@link OfferId} and the {@link CostEstimateId}.
 * It consists of a fixed Part depending on the product category and an Integer based versioning
 *
 * @since: 2.0.0
 *
 */
@EqualsAndHashCode
class ProductId implements Comparable<ProductId>{

    /**
     * The type of the identifier is defined by the implementing identifier
     */
    final String type

    /**
     * Identifying number used in conjunction with the type
     */
    final long uniqueId

    /**
     * A builder for ProductId instances.
     */
    static class Builder {
        private String productType
        private long uniqueId

        /**
         *
         * @param productType
         * @param identifier the unique id - will be interpreted as unsigned long
         */
        Builder(String productType, String identifier) {
            this.productType = Objects.requireNonNull(productType)
            this.uniqueId = Objects.requireNonNull(Long.parseUnsignedLong(identifier))
        }

        /**
         *
         * @param productType
         * @param uniqueId the unique id - will be interpreted as unsigned long
         */
        Builder(String productType, long uniqueId) {
            this.productType = Objects.requireNonNull(productType)
            this.uniqueId = Objects.requireNonNull(uniqueId)
        }

        Builder productType(String productType) {
            this.productType = productType
            return this
        }

        Builder uniqueId(long identifier) {
            this.uniqueId = identifier
            return this
        }
        /**
         * Constructs a product identifier based on the configuration of the builder
         * @return
         */
        ProductId build() {
            return new ProductId(this)
        }
    }

    /**
     * Creates an identifier object with the
     *
     * @param type describing the type of the underlying identifier
     * @param identifier describes the identifying running number
     * @deprecated please use {@link ProductId.Builder}
     */
    @Deprecated
    ProductId(String type, String identifier){
        Builder builder = new Builder(type, identifier)
        this.type = builder.productType
        this.uniqueId = builder.uniqueId
    }

    private ProductId(Builder builder) {
        this.type = builder.productType
        this.uniqueId = builder.uniqueId
    }

    /**
     * Returns the identifying running number
     * @return the identifier
     * @deprecated please use {@link ProductId#getUniqueId()}
     */
    @Deprecated
    String getIdentifier() {
        return uniqueId.toString()
    }

    /**
     * Returns the identifying running number
     * @return the identifier
     */
    Long getUniqueId() {
        return uniqueId
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
        return "${type}_${uniqueId}"
    }

    @Override
    int compareTo(ProductId productId2) {
        //if the types are equal compare by uniqueId
        if(this.type.equals(productId2.type)) return this.uniqueId.compareTo(productId2.uniqueId)
        return this.type.compareTo(productId2.type)
    }
}
