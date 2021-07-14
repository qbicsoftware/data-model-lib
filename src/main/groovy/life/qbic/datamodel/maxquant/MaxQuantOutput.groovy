package life.qbic.datamodel.maxquant

/**
 * Represents the maxQuant output data structure schema.
 *
 * The original schema is defined in as resource and is
 * referenced here, wrapped in a Groovy class for reference
 * in applications that want to validate the maxQuant
 * output structure against the schema.
 *
 * @since 2.10.0
 */

class MaxQuantOutput {

    private static final String SCHEMA_PATH = "/schemas/maxquant-result-set.schema.json"

    static InputStream getSchemaAsStream() {
        return MaxQuantOutput.getResourceAsStream(SCHEMA_PATH)
    }
}

