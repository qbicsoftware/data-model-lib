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
    /**
     * A cost estimate is identified by the type CE
     */
    private static final String type = "CE"
    /**
     * Conserved part of a project
     */
    private String projectConserved
    /**
     * Random part of the identifier
     */
    private String random
    /**
     * Version of the identifier
     */
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
