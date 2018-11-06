package life.qbic.api.v1

import life.qbic.api.v1.conversion.Converter

/**
 * Provides a submitter interface to send queries to the openBIS
 * application server.
 *
 * It makes sure, that the original return types from the openBIS
 * API are automatically provided via QBiC adapters, which
 * makes implementation in QBiC modules more stable towards openBIS
 * API changes in the future.
 *
 * @author: Sven Fillinger
 */
class Submitter {

    private final Converter converter

    Submitter() {
        this.converter = new Converter()
    }

    //TODO Enable async call-back implementation for query submission.
    // http://www.gpars.org/webapp/guide/index.html#_asynchronous_invocations
    Object submit(Closure query) {
        convertResult(query())
    }

    private Object convertResult(Object obj) {
        def convertedResult
        if( obj instanceof List ) {
            convertedResult = obj.each {
                converter.convert(it)
            }
        } else {
            convertedResult = converter.convert(obj)
        }
        return convertedResult
    }


}
