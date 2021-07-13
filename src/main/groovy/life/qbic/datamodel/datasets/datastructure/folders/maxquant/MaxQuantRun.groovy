package life.qbic.datamodel.datasets.datastructure.folders.maxquant

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.files.maxquant.AllPeptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Evidence
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ExperimentalDesignTemplate
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Parameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Peptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ProteinGroups
import life.qbic.datamodel.datasets.datastructure.files.maxquant.RunParameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Summary

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name is always MaxQuantRun.
 *
 * Its children field contains a list of type List<DataFile>
 *
 * @since 2.10.0
 */
class MaxQuantRun extends DataFolder{

    private final static String NAME_SCHEMA = /maxquant_run/ //todo this was not specified in the ER diagram

    private AllPeptides allPeptides

    private Evidence evidence

    private ExperimentalDesignTemplate experimentalDesignTemplate

    private Parameters parameters

    private Peptides peptides

    private ProteinGroups proteinGroups

    private RunParameters runParameters

    private Summary summary

    protected MaxQuantRun() {}

    protected MaxQuantRun(String name, String relativePath, List<DataFile> children) {
        super(name, relativePath, children)
        validateName()
    }

    /**
     * Creates a new instance of a MaxQuantRun object
     *
     * @param name The folder name
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a MaxQuantRun object
     * @since 2.6.0
     */
    static MaxQuantRun create(String name, String relativePath, List<DataFile> children) {
        new MaxQuantRun(name, relativePath, children)
    }

    private void validateName() {
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the nf-core PipelineInformation directory schema!")
        }
    }

    /**
     * Provides access to the information stored in the AllPeptides file
     * @return an AllPeptides file generated by MaxQuant
     * @since 2.10.0
     */
    AllPeptides getAllPeptides() {
        return allPeptides
    }

    /**
     * Provides access to the information stored in the Evidence file
     * @return an Evidence file generated by MaxQuant
     * @since 2.10.0
     */
    Evidence getEvidence() {
        return evidence
    }

    /**
     * Provides access to the information stored in the ExperimentalDesignTemplate file
     * @return an ExperimentalDesignTemplate file generated by MaxQuant
     * @since 2.10.0
     */
    ExperimentalDesignTemplate getExperimentalDesignTemplate() {
        return experimentalDesignTemplate
    }

    /**
     * Provides access to the information stored in the Parameters file
     * @return a Parameters file generated by MaxQuant
     * @since 2.10.0
     */
    Parameters getParameters() {
        return parameters
    }

    /**
     * Provides access to the information stored in the Peptides file
     * @return a Peptides file generated by MaxQuant
     * @since 2.10.0
     */
    Peptides getPeptides() {
        return peptides
    }

    /**
     * Provides access to the information stored in the ProteinGroups file
     * @return a ProteinsGroups file generated by MaxQuant
     * @since 2.10.0
     */
    ProteinGroups getProteinGroups() {
        return proteinGroups
    }

    /**
     * Provides access to the information stored in the RunParameters file
     * @return a RunParameters file generated by MaxQuant
     * @since 2.10.0
     */
    RunParameters getRunParameters() {
        return runParameters
    }

    /**
     * Provides access to the information stored in the Summary file
     * @return a Summary file generated by MaxQuant
     * @since 2.10.0
     */
    Summary getSummary() {
        return summary
    }
}
