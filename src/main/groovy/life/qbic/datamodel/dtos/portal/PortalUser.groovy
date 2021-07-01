package life.qbic.datamodel.dtos.portal

import groovy.transform.Immutable

/**
 * <p>A user within QBiC's data management platform.</p>
 *
 * <p>For example a user with the full name <strong>Max Maxwell Minestrone</strong> has
 * the first name <i>Max</i>, the middle name <i>Maxwell</i> and the last name <i>Minestrone</i>.</p>
 *
 * @since 2.9.0
 */
@Immutable
class PortalUser {

    /**
     * The portal system's user id
     * @since 2.9.0
     */
    String id

    /**
     * The full name of the user
     * @since 2.9.0
     */
    String fullName

    /**
     * The first name of the user
     * @since 2.9.0
     */
    String firstName

    /**
     * The middle name of the user
     * @since 2.9.0
     */
    String middleName

    /**
     * The last name of the user
     * @since 2.9.0
     */
    String lastName

}
