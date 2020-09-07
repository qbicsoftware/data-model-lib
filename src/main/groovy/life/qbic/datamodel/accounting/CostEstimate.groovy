package life.qbic.datamodel.accounting

import life.qbic.datamodel.persons.Person
import life.qbic.datamodel.projects.ProjectInfo

/**
 * A cost estimate for a project
 *
 * During project planning a cost estimate is often required to list expected costs.
 * This estimate is not intended to be legally binding. It provides an overview over the project
 * scope and the costs associated with it.
 *
 * @since: 1.9.0
 * @author: Tobias Koch
 *
 * * */
class CostEstimate {

    final Date date
    final Person customer
    final String projectTitle
    final String projectDescription
    final List<CostItem> items
    final double totalPrice
    final String identifier

}
