package life.qbic.datamodel.dtos.projectmanagement

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

    private static final def REGEX = ~'Q[A-X0-9]{4}'

    /**
     * Constructs a project code instance based on the given code string.
     * @param code The project code
     * @throws IllegalArgumentException If the code parameter does not match format requirements.
     */
    ProjectCode(String code) throws IllegalArgumentException {
        Objects.requireNonNull(code, "Code must not be null")
        this.code = code.trim()
        validateCode()
    }

    private void validateCode() {
        if(! REGEX.matcher(code).matches()) {
            throw new IllegalArgumentException("${code} is not a valid project code.")
        }
    }

    @Override
    String toString() {
        return this.code
    }
}
