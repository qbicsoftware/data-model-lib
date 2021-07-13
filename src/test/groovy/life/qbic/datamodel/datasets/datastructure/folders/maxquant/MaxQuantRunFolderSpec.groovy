package life.qbic.datamodel.datasets.datastructure.folders.maxquant

import life.qbic.datamodel.datasets.datastructure.files.maxquant.AllPeptides
import spock.lang.Specification

/**
 * Tests for the MaxQuantRunFolder Object
 *
 * @since 2.10.0
 */
class MaxQuantRunFolderSpec extends Specification {

    def "create MaxQuantRun folder"() {
        given:
        final String name = "maxquant_run"
        final String relativePath = "root/maxquant_run"
        final def children = []
        final AllPeptides allPeptides = AllPeptides.create("allPeptides.txt", "root/allPeptides.txt")
        children.add(allPeptides)

        when:
        final MaxQuantRunFolder maxQuantRunFolder = MaxQuantRunFolder.create(name, relativePath, children)
        maxQuantRunFolder.allPeptides = allPeptides

        then:
        assert maxQuantRunFolder.getChildren().get(0) instanceof AllPeptides
        assert maxQuantRunFolder.getAllPeptides() == allPeptides

    }

    def "naming schema violation should raise an IllegalArgumentException"() {
        given:
        final String name = "maxQuantRun"
        final String relativePath = "root/maxquant_run"
        final def children = []
        final AllPeptides datafile =  AllPeptides.create("allPeptides.txt", "root/allPeptides.txt")
        children.add(datafile)

        when:
        final MaxQuantRunFolder dataFolder = MaxQuantRunFolder.create(name, relativePath, children)

        then:
        thrown(IllegalArgumentException)

    }
}
