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

    ProjectSpace(String name) {
        final def space = Objects.requireNonNull(name, "Space name must not be null.")
        this.name = formatSpaceName(space)
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
}
