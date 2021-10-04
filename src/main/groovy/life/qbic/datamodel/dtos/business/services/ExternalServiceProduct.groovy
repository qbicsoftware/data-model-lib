package life.qbic.datamodel.dtos.business.services

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.ProductId
import life.qbic.datamodel.dtos.business.facilities.Facility

/**
 * <p>External service product</p>
 *
 * <p>Represents a service product that is offered through QBiC by an external partner.</p>
 *
 * @since 2.13.0
 */
@EqualsAndHashCode(callSuper = true)
class ExternalServiceProduct extends PartialProduct {
    /**
     * Creates an instance of an {@link ExternalServiceProduct}.
     * @param name The name of the product
     * @param description A product description
     * @param internalUnitPrice The net internal unit price of the product
     * @param externalUnitPrice The net external unit price of the product
     * @param unit The unit of the product
     * @param productId A product id, uniquely identifying the product in the offer environment
     * @param serviceProvider The service provider
     */
    ExternalServiceProduct(String name, String description, double internalUnitPrice, double externalUnitPrice, ProductUnit unit, long runningNumber, Facility serviceProvider) {
       ProductId externalProductId = new ProductId.Builder(ProductType.EXTERNAL_SERVICE.toString(), runningNumber).build()
        super(name, description, internalUnitPrice, externalUnitPrice, unit, externalProductId, serviceProvider)
    }
}
