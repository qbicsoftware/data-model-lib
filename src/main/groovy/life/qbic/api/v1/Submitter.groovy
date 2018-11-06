package life.qbic.api.v1

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

    //TODO Enable async call-back implementation for query submission.
    // http://www.gpars.org/webapp/guide/index.html#_asynchronous_invocations

}
