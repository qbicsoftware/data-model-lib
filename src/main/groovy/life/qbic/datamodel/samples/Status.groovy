package life.qbic.datamodel.samples;

/**
 * The status of an sample in the context of <a href="https://github.com/qbicsoftware/sample-tracking-service">sample-tracking</a>
 */
public enum Status {
  SAMPLE_QC_FAIL,
  SAMPLE_QC_PASS,
  SAMPLE_RECEIVED,
  LIBRARY_PREP_FINISHED,
  SEQUENCING,
  SEQUENCING_COMPLETE,
  METADATA_REGISTERED,
  WAITING,
  PROCESSING,
  FAILED_QC,
  PROCESSED,
  DATA_AVAILABLE,
  @Deprecated
  //replaced by DATA_AVAILABLE
  DATA_AT_QBIC
}
