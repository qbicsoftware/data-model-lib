package life.qbic.datamodel.dtos.business

/**
 * A DTO describing the quotation identifier
 *
 * A quotation identifier helps to distinguish between offers. It is a {@link TomatoId}
 *
 * @since: 1.12.0
 *
 */
class QuotationId extends TomatoId{
    /**
     * A quotation is identified by the type Q
     */
    private static final String TYPE = "Q"


    QuotationId(String projectConservedPart, String randomPart, int version) {
        super(TYPE,projectConservedPart,randomPart,version)
    }

}
