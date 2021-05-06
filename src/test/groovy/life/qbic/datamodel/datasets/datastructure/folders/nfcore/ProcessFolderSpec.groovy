package life.qbic.datamodel.datasets.datastructure.folders.nfcore

import life.qbic.datamodel.datasets.datastructure.files.nfcore.ExecutionReport
import spock.lang.Specification

/**
 * Tests for the ProcessFolder Object
 *
 * @since 2.5.0
 */
class ProcessFolderSpec extends Specification {

    def "create Process folder"() {
        given:
        final def name = "processtest"
        final def relativePath = "root/process"
        final def children = []
        final def datafile = ExecutionReport.create("execution_report_test.txt", "root/execution_report_test.txt")
        children.add(datafile)

        when:
        final def dataFolder = ProcessFolder.create(name, relativePath, children)

        then:
        assert dataFolder.getChildren().get(0) instanceof ExecutionReport

    }

}
