package life.qbic.datamodel.pipelines

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

class PipelineOutputSpec {

    def "Return the JSON schema as stream and be parsable as JSON object"() {
        given:
        def stream = PipelineOutput.getSchemaAsStream()

        when:
        JSONObject json = new JSONObject(new JSONTokener(stream))

        then:
        assert  !json.empty
    }
}

