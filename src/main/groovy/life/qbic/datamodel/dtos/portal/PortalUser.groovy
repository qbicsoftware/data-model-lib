package life.qbic.datamodel.dtos.portal

import life.qbic.datamodel.dtos.general.Person

/**
 * <p>A user within QBiC's data management platform.</p>
 *
 * <p>For example a user with the full name <strong>Max Maxwell Minestrone</strong> has
 * the first name <i>Max</i>, the middle name <i>Maxwell</i> and the last name <i>Minestrone</i>.</p>
 *
 * @since 2.9.0
 */
class PortalUser extends Person {

    /**
     * The user id, which uniquely identifies the
     * user in the portal.
     *
     * @since 2.9.0
     */
    final String userId

    static class Builder extends Person.Builder<Builder> {

        private String userId

        Builder(String userId, String firstName, String lastName, String emailAddress) {
            super(firstName, lastName, emailAddress)
            this.userId = userId
        }

        @Override
        PortalUser build() {
            return new PortalUser(this)
        }

        @Override
        protected Builder self() {
            return this
        }
    }

    private PortalUser(Builder builder) {
        super(builder)
        this.userId = builder.userId
    }
}
