package life.qbic.datamodel.dtos.projectmanagement

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.business.OfferId

/**
 * A typical scientific QBiC project.
 *
 * Describes and provides information about a scientific project
 * at QBiC.
 *
 * @since 2.3.0
 */
@EqualsAndHashCode
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

    private Project(Builder builder) {
        this.projectId = Objects.requireNonNull(builder.projectIdentifier)
        this.projectTitle = Objects.requireNonNull(builder.projectTitle)
        this.linkedOffer = builder.linkedOfferId
    }

    static class Builder {
        private ProjectIdentifier projectIdentifier
        private String projectTitle
        private OfferId linkedOfferId

        Builder(ProjectIdentifier projectIdentifier, String projectTitle) {
            this.projectIdentifier = projectIdentifier
            this.projectTitle = projectTitle
            this.linkedOfferId = null
        }

        Builder projectIdentifier(ProjectIdentifier projectIdentifier) {
            this.projectIdentifier = projectIdentifier
            return this
        }

        Builder projectTitle(String projectTitle) {
            this.projectTitle = projectTitle
            return this
        }

        Builder linkedOfferId(OfferId offerId) {
            this.linkedOfferId = offerId
            return this
        }

        Project build() {
            return new Project(this)
        }
    }
}
