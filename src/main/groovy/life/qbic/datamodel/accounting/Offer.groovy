package life.qbic.datamodel.accounting

import life.qbic.datamodel.persons.Person
import life.qbic.datamodel.projects.ProjectInfo

/**
 * An offer for a project
 *
 * An offer describes a legally binding service proposal with associated costs.
 *
 * @since: 1.9.0
 * @author: Tobias Koch
 *
 * * */
class Offer {
    Date modificationDate
    Date expirationDate
    Person customer
    Person projectManager
    ProjectInfo projectInfo
    List<CostItem> items
    double totalPrice
    final String IDENTIFIER

    Offer(String IDENTIFIER) {
        this.IDENTIFIER = IDENTIFIER
    }
}


