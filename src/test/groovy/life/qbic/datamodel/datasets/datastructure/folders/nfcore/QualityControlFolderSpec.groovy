package life.qbic.datamodel.datasets.datastructure.folders.nfcore

import life.qbic.datamodel.datasets.datastructure.files.nfcore.ExecutionReport
import spock.lang.Specification

/**
 * Tests for the PipelineInformationFolder Object
 *
 * @since 2.6.0
 */
class QualityControlFolderSpec extends Specification {

    def "create QualityControl folder"() {
        given:
        final def name = "multiqc"
        final def relativePath = "root/multiqc"
        final def children = []
        final def datafile = ExecutionReport.create("execution_report_test.txt", "root/execution_report_test.txt")
        children.add(datafile)

        when:
        final def dataFolder = QualityControlFolder.create(name, relativePath, children)

        then:
        assert dataFolder.getChildren().get(0) instanceof ExecutionReport

    }

    def "naming schema violation should raise an IllegalArgumentException"() {
        given:
        final def name = "simpleqc"
        final def relativePath = "root/simpleqc"
        final def children = []
        final def datafile =  ExecutionReport.create("execution_report_test.txt", "root/execution_report_test.txt")
        children.add(datafile)

        when:
        final def dataFolder = QualityControlFolder.create(name, relativePath, children)

        then:
        thrown(IllegalArgumentException)

    }
}
