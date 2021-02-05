package life.qbic.datamodel.samples;

/**
 * The status of an sample in the context of <a href="https://github.com/qbicsoftware/sample-tracking-service">sample-tracking</a>
 */
public enum Status {
  SAMPLE_QC_FAIL,
  SAMPLE_QC_PASS,
  SEQUENCING,
  SEQUENCING_COMPLETE,
  DATA_AT_QBIC,
  METADATA_REGISTERED,
  WAITING,
  PROCESSING,
  FAILED_QC,
  PROCESSED
}
