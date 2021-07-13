package life.qbic.datamodel.datasets.datastructure

import groovy.json.JsonSlurper
import life.qbic.datamodel.datasets.MaxQuantRunResult
import life.qbic.datamodel.datasets.NfCorePipelineResult
import life.qbic.datamodel.datasets.datastructure.files.maxquant.AllPeptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Evidence
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ExperimentalDesignTemplate
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Parameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Peptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ProteinGroups
import life.qbic.datamodel.datasets.datastructure.files.maxquant.RunParameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Summary
import life.qbic.datamodel.datasets.datastructure.files.nfcore.RunId
import life.qbic.datamodel.datasets.datastructure.files.nfcore.SampleIds
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.datasets.datastructure.folders.maxquant.MaxQuantRunFolder
import life.qbic.datamodel.datasets.datastructure.folders.nfcore.PipelineInformationFolder
import life.qbic.datamodel.datasets.datastructure.folders.nfcore.QualityControlFolder
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
        MaxQuantRunFolder maxQuantRunResultFolder = maxQuantRunResult.getMaxQuantRunInformation()
        AllPeptides allPeptides = maxQuantRunResultFolder.allPeptides
        Evidence evidence = maxQuantRunResultFolder.evidence
        ExperimentalDesignTemplate experimentalDesignTemplate = maxQuantRunResultFolder.experimentalDesignTemplate
        Parameters parameters = maxQuantRunResultFolder.parameters
        Peptides peptides = maxQuantRunResultFolder.peptides
        ProteinGroups proteinGroups = maxQuantRunResultFolder.proteinGroups
        RunParameters runParameters = maxQuantRunResultFolder.runParameters
        Summary summary = maxQuantRunResultFolder.summary
        then:

        allPeptides.name == "allPeptides.txt"
        evidence.name == "evidence.txt"
        experimentalDesignTemplate.name == "experimentalDesignTemplate.txt"
        parameters.name == "parameters.txt"
        peptides.name == "peptides.txt"
        proteinGroups.name == "proteinGroups.txt"
        runParameters.name == "mqpar.xml"
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
