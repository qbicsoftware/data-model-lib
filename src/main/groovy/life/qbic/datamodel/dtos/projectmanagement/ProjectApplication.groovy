package life.qbic.datamodel.dtos.projectmanagement

import life.qbic.datamodel.dtos.business.Customer
import life.qbic.datamodel.dtos.business.OfferId
import life.qbic.datamodel.dtos.business.ProjectManager

/**
 * Information about a desired project registration in QBiC's project management system.
 *
 * Instances of this class describe a request to register a new project at QBiC.
 *
 * Beside the mandatory fields required to be passed to the constructor, there are two optional
 * fields:
 *   1: projectSpace
 *   2: projectCode
 * If any of these are not defined, then either of it will be created randomly.
 *
 * @since 2.3.0
 */
class ProjectApplication {

    /**
     * The associated offer
     */
    final OfferId linkedOffer

    /**
     * A short and precise project title
     */
    final String projectTitle

    /**
     * A descriptive project objective
     */
    final String projectObjective

    /**
     * A description about the experimental design
     */
    final String experimentalDesign

    /**
     * The associated project manager
     */
    final ProjectManager projectManager

    /**
     * The associated customer
     */
    final Customer customer

    /**
     * The requested project space the project shall be associated with (optional)
     */
    final Optional<ProjectSpace> projectSpace

    /**
     * The desired project code (optional)
     */
    final Optional<ProjectCode> projectCode

    class Builder {

        OfferId linkedOffer
        String projectTitle
        String projectObjective
        String experimentalDesign
        ProjectManager projectManager
        Customer customer
        Optional<ProjectSpace> projectSpace
        Optional<ProjectCode> projectCode

        Builder(OfferId linkedOffer,
                String projectTitle,
                String projectObjective,
                String experimentalDesign,
                ProjectManager projectManager,
                Customer customer) {
            this.linkedOffer = Objects.requireNonNull(linkedOffer)
            this.projectTitle =  Objects.requireNonNull(projectTitle)
            this.projectObjective =  Objects.requireNonNull(projectObjective)
            this.experimentalDesign =  Objects.requireNonNull(experimentalDesign)
            this.projectManager =  Objects.requireNonNull(projectManager)
            this.customer =  Objects.requireNonNull(customer)
            this.projectSpace = Optional.empty()
            this.projectCode = Optional.empty()
        }

        Builder projectSpace(ProjectSpace space) {
            this.projectSpace = Optional.of(space)
            return this
        }

        Builder projectCode(ProjectCode code) {
            this.projectCode = Optional.of(code)
            return this
        }

        ProjectApplication build() {
            return new ProjectApplication(this)
        }
    }

    private ProjectApplication(Builder builder) {
        this.projectTitle = builder.projectTitle
        this.linkedOffer = builder.linkedOffer
        this.projectObjective = builder.projectObjective
        this.experimentalDesign = builder.experimentalDesign
        this.projectManager = builder.projectManager
        this.customer = builder.customer
        this.projectSpace = builder.projectSpace
        this.projectCode = builder.projectCode
    }
}
