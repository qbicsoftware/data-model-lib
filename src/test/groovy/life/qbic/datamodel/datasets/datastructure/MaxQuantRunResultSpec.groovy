package life.qbic.datamodel.datasets.datastructure

import groovy.json.JsonSlurper
import life.qbic.datamodel.datasets.MaxQuantRunResult
import life.qbic.datamodel.datasets.datastructure.files.maxquant.AllPeptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Evidence
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ExperimentalDesignTemplate
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Parameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Peptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ProteinGroups
import life.qbic.datamodel.datasets.datastructure.files.maxquant.RunParameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Summary
import life.qbic.datamodel.datasets.datastructure.files.general.SampleIds
import spock.lang.Shared
import spock.lang.Specification

/**
 * Tests for the MaxQuantRunResult class
 *
 * @since 2.10.0
 */
class MaxQuantRunResultSpec extends Specification {
    /**
     * Map that stores the MaxQuantRun folder structure
     * according to the schema
     */
    @Shared
    Map validDataStructure

    @Shared
    Map invalidDataStructure

    def setupSpec() {
        InputStream validStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("examples/resultset/maxquant/valid-resultset-example.json")
        validDataStructure = (Map) new JsonSlurper().parse(validStream)
        validStream.close()

        InputStream invalidStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("examples/resultset/maxquant/invalid-resultset-example.json")
        invalidDataStructure = (Map) new JsonSlurper().parse(invalidStream)
        invalidStream.close()
    }

    def "Create MaxQuantRunResult from Map successfully"() {
        given:
        final Map validExample = validDataStructure

        when:
        final MaxQuantRunResult maxQuantRunResult = MaxQuantRunResult.createFrom(validExample)
        AllPeptides allPeptides = maxQuantRunResult.allPeptides
        Evidence evidence = maxQuantRunResult.evidence
        ExperimentalDesignTemplate experimentalDesignTemplate = maxQuantRunResult.experimentalDesignTemplate
        Parameters parameters = maxQuantRunResult.parameters
        Peptides peptides = maxQuantRunResult.peptides
        ProteinGroups proteinGroups = maxQuantRunResult.proteinGroups
        RunParameters runParameters = maxQuantRunResult.runParameters
        SampleIds sampleIds = maxQuantRunResult.sampleIds
        Summary summary = maxQuantRunResult.summary
        then:

        allPeptides.name == "allPeptides.txt"
        evidence.name == "evidence.txt"
        experimentalDesignTemplate.name == "experimentalDesignTemplate.txt"
        parameters.name == "parameters.txt"
        peptides.name == "peptides.txt"
        proteinGroups.name == "proteinGroups.txt"
        runParameters.name == "mqpar.xml"
        sampleIds.name == "sample_ids.txt"
        summary.name == "summary_1234.pdf"
    }

    def "Invalid fileTree will return a NullPointerException"() {
        given:
        final Map invalidExample = invalidDataStructure

        when:
        final MaxQuantRunResult invalidMaxQuantResult = MaxQuantRunResult.createFrom(invalidExample)

        then:
        thrown(NullPointerException)
    }
}