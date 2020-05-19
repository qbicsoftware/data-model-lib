package life.qbic.datamodel.datasets

interface ExperimentFolder {

    /**
     * Returns the QBiC sample Id that is associated with this Experiment.
     *
     * The sample id currently is encoded within the root folder's file name
     */
    String getSampleCode()

}
