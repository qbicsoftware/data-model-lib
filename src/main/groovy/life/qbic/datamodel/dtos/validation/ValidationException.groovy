package life.qbic.datamodel.dtos.validation

/**
 * <p>Should be thrown in case a validation failed</p>
 *
 * @since 2.12.0
 */
class ValidationException extends RuntimeException {
    /** Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     * @since 2.12.0
     */
    ValidationException(String message) {
        super(message)
    }
}
