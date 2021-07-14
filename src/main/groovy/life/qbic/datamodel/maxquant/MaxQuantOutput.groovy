package life.qbic.datamodel.maxquant

class MaxQuantOutput {

    private static final String SCHEMA_PATH = "/schemas/maxquant-result-set.schema.json"

    static InputStream getSchemaAsStream() {
        return MaxQuantOutput.getResourceAsStream(SCHEMA_PATH)
    }
}

