package life.qbic.datamodel.datasets

/**
 * Class that holds information about an Oxford Nanopore Experiment.
 *
 * @author: Sven Fillinger
 */
final class OxfordNanoporeDataset {

    final private Map nanoPoreDatasetFileTree

    final private boolean containsPooledMeasurement

    private List<OxfordNanoporeMeasurement> measurements

    OxfordNanoporeDataset(Map nanoPoreDatasetFileTree) {
        this.nanoPoreDatasetFileTree = nanoPoreDatasetFileTree
        containsPooledMeasurement = (nanoPoreDatasetFileTree.name as String).endsWith("_pooled")
        createNanoporeRuns()
    }

    private void createNanoporeRuns(){
        final def measurements = nanoPoreDatasetFileTree.measurements as List
        measurements.each { measurements.add(new OxfordNanoporeMeasurement(it as Map)) }
    }

    boolean containsPooledMeasurement() {
        return containsPooledMeasurement
    }




}
