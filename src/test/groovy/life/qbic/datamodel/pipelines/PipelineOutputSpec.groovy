package life.qbic.datamodel.pipelines

import org.everit.json.schema.Schema
import org.everit.json.schema.ValidationException
import org.everit.json.schema.loader.SchemaClient
import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener
import spock.lang.Specification

/**
 * Tests for the PipelineOutput.class
 *
 * The class shall provide access to the schema of the
 * Pipeline output structure.
 *
 * @author Sven Fillinger, Kevin Menden
 * @since 1.9.0
 */
class PipelineOutputSpec extends Specification {

    def "Return the JSON schema as stream and be parseable as JSON object"() {
        given:
        def stream = PipelineOutput.getSchemaAsStream()

        when:
        JSONObject json = new JSONObject(new JSONTokener(stream))

        then:
        assert !json.empty
    }

    def "Validation of an example valid pipeline output shall pass and not throw any exception"() {
        given:
        def stream = PipelineOutput.getSchemaAsStream()

        and:
        String validPipelineOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/valid-resultset-example.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(validPipelineOutput))

        then:
        noExceptionThrown()

    }

    def "Validation of an invalid pipeline output shall not pass an validation exception"() {
        given:
        def stream = PipelineOutput.getSchemaAsStream()

        and:
        String validPipelineOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/invalid-resultset-example.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(validPipelineOutput))

        then:
        thrown(ValidationException)
    }

    def "Missing pipeline info property shall raise a validation exception"() {
        given:
        def stream = PipelineOutput.getSchemaAsStream()

        and:
        String validPipelineOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/missing-pipeline-info-resultset-example.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(validPipelineOutput))

        then:
        thrown(ValidationException)
    }

    def "Missing quality control property shall raise a validation exception"() {
        given:
        def stream = PipelineOutput.getSchemaAsStream()

        and:
        String validPipelineOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/missing-quality-control-resultset" +
                        "-example.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(validPipelineOutput))

        then:
        thrown(ValidationException)
    }

    def "Missing process folders property shall raise a validation exception"() {
        given:
        def stream = PipelineOutput.getSchemaAsStream()

        and:
        String validPipelineOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/missing-process-folders-resultset" +
                        "-example.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(validPipelineOutput))

        then:
        thrown(ValidationException)
    }
}

