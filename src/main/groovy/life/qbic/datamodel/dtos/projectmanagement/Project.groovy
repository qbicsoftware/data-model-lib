package life.qbic.datamodel.dtos.projectmanagement

import life.qbic.datamodel.dtos.business.OfferId

/**
 * A typical scientific QBiC project.
 *
 * Describes and provides information about a scientific project
 * at QBiC.
 *
 * @since 2.3.0
 */
class Project {

    /**
     * A short but descriptive project title
     */
    final String projectTitle

    /**
     * QBiC's internal project identifier
     */
    final ProjectIdentifier projectId

    /**
     * The associated offer
     */
    final OfferId linkedOffer

    Project(ProjectIdentifier projectIdentifier, String projectTitle, OfferId linkedOffer) {
        this.projectId = Objects.requireNonNull(projectIdentifier)
        this.projectTitle = Objects.requireNonNull(projectTitle)
        this.linkedOffer = Objects.requireNonNull(linkedOffer)
    }
}