package life.qbic.datamodel.dtos.projectmanagement

/**
 * <h1>Represents a QBiC project space</h1>
 *
 * <p>A space is a logical grouping of projects that have the same context.</p>
 *
 * <p>A project space has a name that follows this convention:</p>
 *
 * <ul>
 *  <li> No white space </li>
 *  <li> Capital letters only </li>
 *  <li> Inner white space is replaced by `_` </li>
 *  <li> Trailing and leading white space are trimmed </li>
 *  <li> Dashes are replaced by `_` </li>
 * </ul>
 * @since 2.3.0
 */
final class ProjectSpace {

    /**
     * The project space name
     */
    final String name

    private static final def REGEX = ~'[-\\w]+'

    ProjectSpace(String name) {
        final def space = Objects.requireNonNull(name, "Space name must not be null.")
        validateName(name)
        this.name = formatSpaceName(space)
    }

    private void validateName(String name) {
        // validation happens with the formatted name, but the input name must be returned so the user does not get confused
        if(! REGEX.matcher(formatSpaceName(name)).matches()) {
            throw new IllegalArgumentException("${name} is not a valid project code.")
        }
    }

    private static String formatSpaceName(String name) {
        def capitalizedName = name.trim().toUpperCase()
        def refactoredName = capitalizedName.replaceAll("\\s+", "_")
                .replaceAll("-", "_")
        return refactoredName
    }

    /**
     * Returns a string representation of the space name following the format conventions stated
     * in the class description.
     *
     * Example: "my example space  " -> "MY_EXAMPLE_SPACE"
     *
     * @return The project space name
     */
    @Override
    String toString() {
        return this.name
    }

    @Override
    boolean equals(Object obj) {
        if (this.is(obj)) {
            return true
        }
        if (!obj instanceof ProjectSpace) {
            return false
        }
        ProjectSpace otherSpace = (ProjectSpace) obj
        return this.name.equals(otherSpace.name)
    }
}
