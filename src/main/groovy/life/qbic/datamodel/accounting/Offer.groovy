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
    //final Date modificationDate
    //final Date expirationDate
    final Person customer
    final Person projectManager
    final String projectTitle
    final String projectDescription
    final List<CostItem> items
    final double totalPrice
    final String IDENTIFIER

    public void addItem(CostItem item){

    }

    public void removeItem(CostItem item){

    }
}


