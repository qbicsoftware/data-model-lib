package life.qbic.datamodel.dtos.projectmanagement

import groovy.transform.EqualsAndHashCode

/**
 * Global project identifier for QBiC projects
 *
 * Identifies a project by its project space and project code.
 *
 * @since 2.3.0
 */
@EqualsAndHashCode(excludes = ["id"])
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

    @Override
    boolean equals(Object obj) {
        if (obj == null) {
            return false
        }
        if (this.is(obj)) {
            return true
        }
        if (!obj instanceof ProjectIdentifier) {
            return false
        }
        ProjectIdentifier otherIdentifier = (ProjectIdentifier) obj
        return this.projectSpace.equals(otherIdentifier.getProjectSpace()) \
                && this.projectCode.equals(otherIdentifier.getProjectCode())
    }
}
