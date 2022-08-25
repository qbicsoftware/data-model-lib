package life.qbic.datamodel.datasets.datastructure.folders.nfcore

import life.qbic.datamodel.datasets.datastructure.files.nfcore.ExecutionReport
import life.qbic.datamodel.datasets.datastructure.files.nfcore.PipelineReport
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
        final def executionReport = ExecutionReport.create("execution_report.txt", "root/execution_report.txt")
        final def pipelineReport = PipelineReport.create("pipeline_report.txt", "root/pipeline_report.txt")
        final def softwareVersions = SoftwareVersions.create("software_versions.csv", "root/software_versions.csv")
        when:
        final def pipelineInformationFolder = PipelineInformationFolder.create(name, relativePath, children)
        pipelineInformationFolder.executionReport = executionReport
        pipelineInformationFolder.pipelineReport = pipelineReport
        pipelineInformationFolder.softwareVersions = softwareVersions

        then:
        assert pipelineInformationFolder.getExecutionReport() == executionReport
        assert pipelineInformationFolder.getPipelineReport() == pipelineReport
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
