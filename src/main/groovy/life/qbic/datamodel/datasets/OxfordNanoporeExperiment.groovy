package life.qbic.datamodel.datasets

/**
 * Class that holds information about an Oxford Nanopore Experiment.
 *
 * @author: Sven Fillinger
 */
final class OxfordNanoporeExperiment {

    private final List<OxfordNanoporeMeasurement> measurements

    private final String qbicId

    private OxfordNanoporeExperiment(String qbicId, List<OxfordNanoporeMeasurement> measurements) {
        this.measurements = measurements
        this.qbicId = qbicId
    }

    /**
     * Static factory method that creates a new instance from a Oxford Nanopore sequencer output.
     * @param nanoPoreSequencerOutput
     * @return OxfordNanoporeExperiment A new instance of a nanopore experiment.
     */
    static OxfordNanoporeExperiment create(Map nanoPoreSequencerOutput) {
        final String qbicId = parseQbicIdFromRootFolder(nanoPoreSequencerOutput)
        final List<OxfordNanoporeMeasurement> measurements = parseMeasurements(nanoPoreSequencerOutput)
        return new OxfordNanoporeExperiment(qbicId, measurements)
    }

    /*
    Helper method that parses the QBiC identifier from the root folder name
     */
    private static String parseQbicIdFromRootFolder(Map nanoPoreSequencerOutput) {
        return ""
    }

    /*
    Helper method that creates the measurements from the sequencer output
     */
    private static List<OxfordNanoporeMeasurement> parseMeasurements(Map nanoPoreSequencerOutput) {
        final List measurements = []

        return measurements
    }
}
