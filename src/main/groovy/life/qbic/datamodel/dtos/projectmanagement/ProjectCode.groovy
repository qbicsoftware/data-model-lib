package life.qbic.datamodel.dtos.projectmanagement

import life.qbic.datamodel.dtos.validation.ValidationException

/**
 * Describes the project code, that identifies the project within a project space.
 *
 * A project code is the unique identifier of a QBiC project within a project space.
 *
 * A project code can be validated with the following regular expression: "Q[A-X0-9]{4}".
 *
 * @since 2.3.0
 */
class ProjectCode {

    final String code

    private static final ProjectCodeValidator projectCodeValidator = new ProjectCodeValidator()

    /**
     * Constructs a project code instance based on the given code string.
     * @param code The project code
     * @throws IllegalArgumentException If the code parameter does not match format requirements.
     */
    ProjectCode(String code) throws IllegalArgumentException {
        Objects.requireNonNull(code, "Code must not be null")
        String projectCode = code.trim()
        try {
            projectCodeValidator.accept(code)
        } catch (ValidationException validationException) {
            throw new IllegalArgumentException(validationException.message)
        }
        this.code = projectCode
    }

    @Override
    String toString() {
        return this.code
    }

    @Override
    boolean equals(Object obj) {
        if (this.is(obj)) {
            return true
        }
        if (!obj instanceof ProjectCode) {
            return false
        }
        ProjectCode otherCode = (ProjectCode) obj
        return this.code.equals(otherCode.code)
    }
}
