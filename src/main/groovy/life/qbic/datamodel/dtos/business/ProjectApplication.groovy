package life.qbic.datamodel.dtos.business

import groovy.transform.EqualsAndHashCode
import life.qbic.datamodel.dtos.projectmanagement.ProjectCode
import life.qbic.datamodel.dtos.projectmanagement.ProjectSpace

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
@EqualsAndHashCode
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
     * The requested project space the project shall be associated with
     */
    final ProjectSpace projectSpace

    /**
     * The desired project code
     */
    final ProjectCode projectCode

    ProjectApplication(OfferId linkedOffer,
                String projectTitle,
                String projectObjective,
                String experimentalDesign,
                ProjectManager projectManager,
                ProjectSpace projectSpace,
                Customer customer,
                ProjectCode code) {
            this.linkedOffer = Objects.requireNonNull(linkedOffer)
            this.projectTitle =  Objects.requireNonNull(projectTitle)
            this.projectObjective =  Objects.requireNonNull(projectObjective)
            this.experimentalDesign =  Objects.requireNonNull(experimentalDesign)
            this.projectManager =  Objects.requireNonNull(projectManager)
            this.customer =  Objects.requireNonNull(customer)
            this.projectSpace = Objects.requireNonNull(projectSpace)
            this.projectCode = Objects.requireNonNull(code)
    }
}
