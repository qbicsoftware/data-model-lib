package life.qbic.datamodel.pipelines

class PipelineOutput {

    private static final String SCHEMA_PATH = "/schemas/bioinformatics-analysis-output.schema.json"

    static InputStream getSchemaAsStream() {
        return PipelineOutput.getResourceAsStream(SCHEMA_PATH)
    }
}
