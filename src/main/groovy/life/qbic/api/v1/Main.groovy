package life.qbic.api.v1

import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.Sample
/**
 * Example entry point for a showcase of the openBIS object adapter usage.
 */
class Main {

    static void main(String[] args){

        def submitter = new Submitter()

        def fakeQuery = {
            def result = []
            result << new Sample().tap {
                code = "QHIPP000A3"
            }
            result << new Sample().tap {
                code = "QHIPP001B1"
            }
        }

        def result = submitter.submit fakeQuery
        println result.class
        println result.code

    }

}

