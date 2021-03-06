package life.qbic.datamodel.dtos.portal

import spock.lang.Specification

/**
 * Some basic tests for the PortalUser
 * @since 2.9.0
 */
class PortalUserSpec extends Specification{

    def "Given all necessary information, build the portal user successfully"() {
        given:
        String id = "1234"
        String authProviderId = "xxce22"
        String firstName = "Sven"
        String lastName = "Fillinger"
        String email = "sven.fillinger@qbic.uni-tuebingen.de"

        when:
        PortalUser user = new PortalUser.Builder(id, authProviderId, firstName, lastName, email).build()

        then:
        user.getUserId().equals("1234")
        assert user instanceof PortalUser
    }

}
