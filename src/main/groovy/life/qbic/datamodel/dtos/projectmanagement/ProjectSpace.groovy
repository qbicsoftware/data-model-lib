package life.qbic.datamodel.dtos.projectmanagement

/**
 * Represents a QBiC project space.
 *
 * A space is a logical grouping of projects that have the same context.
 *
 * A project space has a name that follows this convention:
 *
 *  1. No white space
 *  2. Capital letters only
 *  3. Inner white space is replaced by `_`
 *  4. Trailing and leading white space are trimmed
 *
 * @since 2.3.0
 */
final class ProjectSpace {

    /**
     * The project space name
     */
    final String name

    ProjectSpace(String name) {
        final def space = Objects.requireNonNull(name, "Space name must not be null.")
        this.name = formatSpaceName(space)
    }

    private static String formatSpaceName(String name) {
        def capitalizedName = name.trim().toUpperCase()
        def replacedWhiteSpace = capitalizedName.replaceAll("\\s+", "_")
        return replacedWhiteSpace
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
}
