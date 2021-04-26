package life.qbic.datamodel.dtos.business

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode

/**
 * A DTO describing Tomato identifiers
 *
 * The TomatoId should be used as a general class describing identifiers like the {@link OfferId} and the {@link CostEstimateId}.
 * It consists of a random part, a project conserved part and a version. Furthermore, the type is also part of the identifier.
 *
 * @since: 1.12.0
 *
 */
@CompileStatic
@EqualsAndHashCode(includeFields = true)
abstract class TomatoId {
    /**
     * The type of the identifier is defined by the implementing identifier
     */
    final private String type
    /**
     * Conserved part of a project which is the name of the customer
     */
    final private String projectConserved
    /**
     * Random part of the identifier which should follow the Regex [a-x0-9]{4}
     */
    final private String random
    /**
     * Version of the identifier
     */
    final private String version

    /**
     * Creates an identifier object with the
     *
     * @param type describing the type of the underlying identifier
     * @param projectConservedPart describes the project conserved part of the identifier
     * @param randomPart describes the random part of the identifier
     * @param version describes the version of the identifier
     */
    TomatoId(String type, String projectConservedPart, String randomPart, String version){
        this.type = Objects.requireNonNull(type, "type must not be null")
        this.projectConserved = Objects.requireNonNull(projectConservedPart, "projectConservedPart must not be null")
        this.random = Objects.requireNonNull(randomPart, "randomPart must not be null")
        this.version = Objects.requireNonNull(version, "version must not be null")
    }

    /**
     * Assembles the identifier from the class attributes. This method determines how the identifier
     * looks like for all implementing classes to provide a uniform identifier format
     *
     * @return a String containing the type, project conserved part, random part and the version
     * @deprecated As of release 2.0.0, please use the {@link #toString()} method
     */
    @Deprecated
    String getIdentifier(){
        return type + "_" + projectConserved + "_" + randomPart + "_" + "v" + version
    }

    /**
     * Returns the project conserved part of the identifier
     *
     * @return
     */
    String getProjectConservedPart() {
        return projectConserved
    }

    /**
     * Returns the random part of the identifier
     *
     * @return
     */
    String getRandomPart() {
        return random
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
     *      [type]_[project conserved part]_[random id]_[version]
     *
     * @return A String representation of the identifier
     */
    @Override
    String toString() {
        return type + "_" + projectConserved + "_" + randomPart + "_" + version
    }
}
