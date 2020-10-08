package life.qbic.datamodel.dtos.business

/**
 * A DTO describing Tomato identifiers
 *
 * The TomatoId should be used as a general class describing identifiers like the {@link QuotationId} and the {@link CostEstimateId}.
 * It consists of a random part, a project conserved part and a version. Furthermore, the type is also part of the identifier.
 *
 * @since: 1.12.0
 *
 */
abstract class TomatoId {
    /**
     * The type of the identifier is defined by the implementing identifier
     */
    private final String type
    /**
     * Conserved part of a project which is the name of the customer
     */
    private String projectConserved
    /**
     * Random part of the identifier which should follow the Regex [a-x0-9]{4}
     */
    private String random
    /**
     * Version of the identifier which is a number between 0 and 9
     */
    private int version

    /**
     * Creates an identifier object with the
     *
     * @param type describing the type of the underlying identifier
     * @param projectConservedPart describes the project conserved part of the identifier
     * @param randomPart describes the random part of the identifier
     * @param version describes the version of the identifier
     */
    TomatoId(String type, String projectConservedPart, String randomPart, int version){
        this.type = type
        this.projectConserved = projectConservedPart
        this.random = randomPart
        this.version = version
    }

    /**
     * Assembles the identifier from the class attributes. This method determines how the identifier
     * looks like for all implementing classes to provide a uniform identifier format
     *
     * @return a String containing the type, project conserved part, random part and the version
     */
    String getIdentifier(){
        return getType() + "_" + getProjectConservedPart() + "_" + getRandomPart() + "_" + "v" + getVersion()
    }

    /**
     * Returns the type of the identifier
     *
     * @return
     */
    abstract String getType()

    /**
     * Returns the project conserved part of the identifier
     *
     * @return
     */
    abstract String getProjectConservedPart()

    /**
     * Returns the random part of the identifier
     *
     * @return
     */
    abstract String getRandomPart()

    /**
     * Returns the version of the identifier
     * @return
     */
    abstract int getVersion()
}
