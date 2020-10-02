package life.qbic.datamodel.dtos.business

/**
 * A DTO describing the quotation identifier
 *
 * A quotation identifier helps to distinguish between offers. It is a {@link TomatoId}
 *
 * @since: 1.11.0
 *
 */
class QuotationId extends TomatoId{
    /**
     * A quotation is identified by the type Q
     */
    private final String type = "Q"
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


    QuotationId(String projectConservedPart, String randomPart, int version) {
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
        return random
    }

    @Override
    int getVersion() {
        return version
    }
}
