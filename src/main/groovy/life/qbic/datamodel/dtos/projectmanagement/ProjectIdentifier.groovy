package life.qbic.datamodel.dtos.projectmanagement

/**
 * Global project identifier for QBiC projects
 *
 * Identifies a project by its project space and project code.
 *
 * @since 2.3.0
 */
class ProjectIdentifier {

    /**
     * The associated project space
     */
    final ProjectSpace projectSpace

    /**
     * The associated project code within the project space
     */
    final ProjectCode projectCode

    /**
     * Constructor for a project identifier.
     * @param projectSpace The project space the project is associated with
     * @param projectCode The project code, identifying the project within the project space
     */
    ProjectIdentifier(ProjectSpace projectSpace, ProjectCode projectCode) {
        this.projectSpace = Objects.requireNonNull(projectSpace)
        this.projectCode = Objects.requireNonNull(projectCode)
    }

    @Override
    String toString() {
        return "/${projectSpace.toString()}/${projectCode.toString()}"
    }
}
