package life.qbic.datamodel.dtos.business

import life.qbic.datamodel.dtos.general.Person

/**
 * This class serves as a simple DTO representing a ProjectManager
 *
 * A projectManager is a person which is responsible for managing
 * projects in a business relationship
 *
 * @since 1.12.0
 */
class ProjectManager extends Person {

    ProjectManager(String firstName,
             String lastName,
             AcademicTitle title,
             String eMailAddress,
             List<Affiliation> affiliations) {
        super(firstName,lastName,title,eMailAddress,affiliations)
    }
}
