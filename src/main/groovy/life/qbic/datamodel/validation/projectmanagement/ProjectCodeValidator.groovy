package life.qbic.datamodel.validation.projectmanagement

import life.qbic.datamodel.validation.ValidationException

import java.util.function.Consumer
import java.util.function.Predicate
import java.util.regex.Pattern

/**
 * <b>Project Code Validator</b>
 *
 * <p>Consumes a project code and throws a {@link ValidationException} in case it is not valid.</p>
 *
 * @since 2.12.0
 */
class ProjectCodeValidator implements Consumer<String> {
    private static final Predicate<String> IS_VALID_PROJECT_CODE = Pattern.compile("Q[A-X0-9]{4}").asPredicate()

    /**
     * Consumes the project code and throws a {@link ValidationException} in case of invalidity.
     *
     * @param projectCode the project code to validate
     * @throws ValidationException in case of validation failure
     * @since 2.12.0
     */
    @Override
    void accept(String projectCode) throws ValidationException {
        ValidationException validationException = new ValidationException("'${projectCode}' is not a valid project code.")
        if (!projectCode) {
            throw validationException
        }
        if (!IS_VALID_PROJECT_CODE.test(projectCode)) {
            throw validationException
        }
    }

}
