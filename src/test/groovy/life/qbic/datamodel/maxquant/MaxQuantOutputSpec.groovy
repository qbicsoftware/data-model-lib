package life.qbic.datamodel.maxquant

import groovy.json.JsonSlurper
import org.everit.json.schema.Schema
import org.everit.json.schema.ValidationException
import org.everit.json.schema.loader.SchemaClient
import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener
import spock.lang.Specification

/**
 * Tests for the MaxQuantOutput.class
 *
 * The class shall provide access to the schema of the
 * MaxQuant output structure.
 *
 * @since 2.10.0
 */
class MaxQuantOutputSpec extends Specification {

    def "Return the JSON schema as stream and be parseable as JSON object"() {
        given:
        def stream = MaxQuantOutput.getSchemaAsStream()

        when:
        JSONObject json = new JSONObject(new JSONTokener(stream))

        then:
        assert !json.empty
    }

    def "Validation of an example valid pipeline output shall pass and not throw any exception"() {
        given:
        def stream = MaxQuantOutput.getSchemaAsStream()

        and:
        String validMaxQuantOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/maxquant/valid-resultset-example_latest.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(validMaxQuantOutput))

        then:
        noExceptionThrown()

    }

    def "Validation of an invalid pipeline output shall raise pass an validation exception"() {
        given:
        def stream = MaxQuantOutput.getSchemaAsStream()

        and:
        String validMaxQuantOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/maxquant/invalid-resultset-example.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(validMaxQuantOutput))

        then:
        thrown(ValidationException)
    }

    def "A missing property shall raise a validation exception"() {
        given:
        def stream = MaxQuantOutput.getSchemaAsStream()

        and:
        String missingMaxQuantOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/maxquant/no-sampleid-resultset-example.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(missingMaxQuantOutput))

        then:
        thrown(ValidationException)
    }

    def "Validating the outdated schema v2 shall raise a validation exception"() {
        given:
        def stream = MaxQuantOutput.getSchemaAsStream()

        and:
        String wrongMaxQuantOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/maxquant/old_valid-resultset-example.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(wrongMaxQuantOutput))

        then:
        thrown(ValidationException)
    }

    def "An invalid project code in the sample ids file shall raise a validation exception"() {
        given:
        def stream = MaxQuantOutput.getSchemaAsStream()

        and:
        String missingMaxQuantOutput = this.class.getClassLoader()
                .getResourceAsStream("examples/resultset/maxquant/invalid-project-resultset-example.json")
                .text

        and:
        SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
        Schema schema = schemaLoader.load().build()

        when:
        schema.validate(new JSONObject(missingMaxQuantOutput))

        then:
        thrown(ValidationException)
    }
}
