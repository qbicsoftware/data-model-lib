package life.qbic.datamodel.datasets.datastructure.folders.nfcore

import life.qbic.datamodel.datasets.datastructure.files.nfcore.ExecutionReport
import life.qbic.datamodel.datasets.datastructure.files.nfcore.SoftwareVersions
import spock.lang.Specification

/**
 * Tests for the PipelineInformationFolder Object
 *
 * @since 2.6.0
 */
class PipelineInformationFolderSpec extends Specification {

    def "create pipelineInformation folder"() {
        given:
        final def name = "pipeline_info"
        final def relativePath = "root/pipeline_info"
        final def children = []
        final def executionReport = ExecutionReport.create("execution_report.html", "root/execution_report.html")
        final def softwareVersions = SoftwareVersions.create("software_versions.yml", "root/software_versions.yml")
        when:
        final def pipelineInformationFolder = PipelineInformationFolder.create(name, relativePath, children)
        pipelineInformationFolder.executionReport = executionReport
        pipelineInformationFolder.softwareVersions = softwareVersions

        then:
        assert pipelineInformationFolder.getExecutionReport() == executionReport
        assert pipelineInformationFolder.getSoftwareVersions() == softwareVersions

    }

    def "naming schema violation should raise an IllegalArgumentException"() {
        given:
        final def name = "pipeline_unsatisfied"
        final def relativePath = "root/pipeline_unsatisfied"
        final def children = []
        final def datafile =  ExecutionReport.create("execution_report_test.html", "root/execution_report_test.html")
        children.add(datafile)

        when:
        final def dataFolder = PipelineInformationFolder.create(name, relativePath, children)

        then:
        thrown(IllegalArgumentException)

    }
}
