package life.qbic.datamodel.instruments


/**
 * Represents the Nanopore instrument output data structure schema.
 *
 * The original schema is defined in as resource and is
 * referenced here, wrapped in a Groovy class for reference
 * in applications that want to validate the instrument
 * output structure against the schema.
 *
 * @author Sven Fillinger
 * @since 1.9.0
 */
class OxfordNanoporeInstrumentOutputV2 {

    private static final String SCHEMA_PATH = "/schemas/nanopore-instrument-output_v2.schema.json"

    static InputStream getSchemaAsStream() {
        return OxfordNanoporeInstrumentOutputV2.getResourceAsStream(SCHEMA_PATH)
    }
}
