package life.qbic.datamodel.datasets


/**
 * Class that holds information about an Oxford Nanopore Experiment.
 *
 * @author: Sven Fillinger
 */
final class OxfordNanoporeExperiment {

    final private Map nanoPoreDatasetFileTree

    final private boolean containsPooledMeasurement

    private final List<OxfordNanoporeMeasurement> measurements

    private final String qbicId

    OxfordNanoporeExperiment(String qbicId, List<OxfordNanoporeMeasurement> measurements) {
        this.nanoPoreDatasetFileTree = nanoPoreDatasetFileTree
        this.containsPooledMeasurement = measurements.get(0).containsPooledSamples()
        this.measurements = measurements
        this.qbicId = qbicId
    }

    boolean containsPooledMeasurement() {
        return containsPooledMeasurement
    }




}
