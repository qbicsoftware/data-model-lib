package life.qbic.datamodel.samples;

/**
 * The status of an sample in the context of <a href="https://github.com/qbicsoftware/sample-tracking-service">sample-tracking</a>
 */
public enum Status {
  SAMPLE_QC_FAIL ("Sample QC Fail"),
  SAMPLE_QC_PASS ("Sample QC Pass"),
  SAMPLE_RECEIVED ("Sample Received"),
  LIBRARY_PREP_FINISHED ("Library Prep Finished"),
  /**
   * @deprecated this is deprecated since 2.16.0 please use {@link #SEQUENCING_COMPLETE} instead
   */
  @Deprecated
  SEQUENCING ("Sequencing"),
  SEQUENCING_COMPLETE ("Sequencing Complete"),
  METADATA_REGISTERED ("Metadata Registered"),
  /**
   * @deprecated this is deprecated since 2.16.0
   */
  @Deprecated
  WAITING ("Waiting"),
  /**
   * @deprecated this is deprecated since 2.16.0
   */
  @Deprecated
  PROCESSING ("Processing"),
  /**
   * @deprecated this is deprecated since 2.16.0 please use {@link #SAMPLE_QC_FAIL} instead
   */
  @Deprecated
  FAILED_QC ("Failed QC"),
  /**
   * @deprecated this is deprecated since 2.16.0
   */
  @Deprecated
  PROCESSED ("Processed"),
  DATA_AVAILABLE ("Data Available"),
  /** 
  * @deprecated this is deprecated since 2.4.0 please use {@link #DATA_AVAILABLE} instead
  */
  @Deprecated
  DATA_AT_QBIC ("Data at QBiC")

  private final displayName

  private Status(String displayName){
    this.displayName = displayName
  }

  /**
   * Returns to the enum item display name
   * @return
   */
  String getDisplayName() {
    return this.displayName
  }

}
