package life.qbic.datamodel.instruments


/**
 * Represents the Nanopore instrument output data structure schema.
 *
 * The original schema is defined in as resource and is
 * referenced here, wrapped in a Groovy class for reference
 * in applications that want to validate the instrument
 * output structure against the schema.
 */
class OxfordNanoporeInstrumentOutputMinimal {

  private static final String SCHEMA_PATH = "/schemas/nanopore-instrument-output_minimal.schema.json"

  static InputStream getSchemaAsStream() {
    return OxfordNanoporeInstrumentOutputMinimal.getResourceAsStream(SCHEMA_PATH)
  }
}
