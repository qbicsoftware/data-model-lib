package life.qbic.datamodel.datasets.imaging

/**
 * Represents the schema for the imaging metadata model.
 *
 * The original schema is defined in as resource and is
 * referenced here, wrapped in a Groovy class for reference
 * in applications that want to validate the instrument
 * output structure against the schema.
 *
 * @author Luis Kuhn
 * @since 2.6.0
 */
class ImageMetadata {

    private static final String SCHEMA_PATH = "/schemas/img-metadata.schema.json"

    /**
     * Returns the json imaging schema based on the path defined in {@link ImageMetadata}
     * @return InputStream containing the schema json content
     */
    static InputStream getSchemaAsStream() {
        return ImageMetadata.getResourceAsStream(SCHEMA_PATH)
    }
}
