package life.qbic.datamodel.dtos.business

/**
 * A DTO to describe the cost estimate identifier
 *
 * A cost estimate is a {@link TomatoId} and describes how the identifier of a cost estimate looks like. It helps to
 * differentiate between cost estimates
 *
 * @since: 1.12.0
 *
 */
class CostEstimateId extends TomatoId{
    /**
     * A cost estimate is identified by the type CE
     */
    private static final String type = "CE"


    CostEstimateId(String projectConservedPart, String randomPart, int version) {
        super(type,projectConservedPart,randomPart,version)
    }


    @Override
    String getType() {
        return type
    }

}
