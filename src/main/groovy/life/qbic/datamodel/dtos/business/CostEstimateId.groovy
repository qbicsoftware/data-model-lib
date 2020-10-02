package life.qbic.datamodel.dtos.business

/**
 * A DTO to describe the cost estimate identifier
 *
 * A cost estimate is a {@link TomatoId} and describes how the identifier of a cost estimate looks like. It helps to
 * differentiate between cost estimates
 *
 * @since: 1.11.0
 *
 */
class CostEstimateId extends TomatoId{
    private final String type = "CE"
    private String projectConserved
    private String random
    private int version


    CostEstimateId(String projectConservedPart, String randomPart, int version) {
        super(type,projectConservedPart,randomPart,version)

        this.projectConserved = projectConservedPart
        this.random = randomPart
        this.version = version
    }


    @Override
    String getType() {
        return type
    }

    @Override
    String getProjectConservedPart() {
        return projectConserved
    }

    @Override
    String getRandomPart() {
        return randomPart
    }

    @Override
    int getVersion() {
        return version
    }
}
