package life.qbic.datamodel.instruments

import org.everit.json.schema.ValidationException
import org.json.JSONObject
import org.json.JSONTokener
import spock.lang.Specification

/**
 * Tests for the OxfordNanoporeInstrumentOutput.class
 *
 * The class shall provide access to the schema of the
 * Oxford Nanopore instrument output structure.
 *
 * @author Sven Fillinger
 * @since 1.9.0
 */
class OxfordNanoporeInstrumentOutputSpec extends Specification {

    def "Return the Json schema as stream and be parsable as JSON object"() {
        given:
        def stream = OxfordNanoporeInstrumentOutput.getSchemaAsStream()

        when:
        JSONObject json = new JSONObject(new JSONTokener(stream))

        then:
        assert !json.empty
    }
}
