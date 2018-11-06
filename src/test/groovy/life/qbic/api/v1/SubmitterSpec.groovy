package life.qbic.api.v1

import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.Sample
import life.qbic.api.v1.qbicobject.QbicSample
import spock.lang.Specification

class SubmitterSpec extends Specification{

    def final tCode = 'QHIPP001AE'

    def final openBisSample = new Sample().tap {
        code = tCode
    }

    def "check successful sample conversion"() {
        given:
        def submitter = new Submitter()
        def exampleQuery = {
            def list = [openBisSample]
        }

        when:
        def result = submitter.submit(exampleQuery)

        then:
        result instanceof List
        result.each {
            it instanceof QbicSample
        }



    }



}
