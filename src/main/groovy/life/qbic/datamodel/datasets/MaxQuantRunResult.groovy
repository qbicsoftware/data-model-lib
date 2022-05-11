package life.qbic.datamodel.datasets

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.files.maxquant.AllPeptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Evidence
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ExperimentalDesignTemplate
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Parameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Peptides
import life.qbic.datamodel.datasets.datastructure.files.maxquant.ProteinGroups
import life.qbic.datamodel.datasets.datastructure.files.maxquant.RunParameters
import life.qbic.datamodel.datasets.datastructure.files.maxquant.Summary
import life.qbic.datamodel.datasets.datastructure.files.general.SampleIds

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Class that holds information about the output of a maxQuantRun
 *
 * @since 2.10.0
 */
final class MaxQuantRunResult {

    // Fully qualified domain name of the maxQuant file structure package
    private final static String FQDN_FILES = "life.qbic.datamodel.datasets.datastructure.files.maxquant"
    // Fully qualified domain name of the general file structure package
    private final static String GENERAL_FILES = "life.qbic.datamodel.datasets.datastructure.files.general"

    private final static Set maxQuantFileTypes = [
            FQDN_FILES + ".AllPeptides",
            FQDN_FILES + ".Evidence",
            FQDN_FILES + ".Parameters",
            FQDN_FILES + ".Peptides",
            FQDN_FILES + ".ProteinGroups",
            FQDN_FILES + ".RunParameters",
            GENERAL_FILES + ".SampleIds",
    ]

    private final AllPeptides allPeptides

    private final Evidence evidence

    private final Parameters parameters

    private final Peptides peptides

    private final ProteinGroups proteinGroups

    private final RunParameters runParameters

    private final SampleIds sampleIds

    MaxQuantRunResult(AllPeptides allPeptides, Evidence evidence, Parameters parameters, Peptides peptides, ProteinGroups proteinGroups, RunParameters runParameters, SampleIds sampleIds) {
        this.allPeptides = Objects.requireNonNull(allPeptides, "allPeptides must not be null.")
        this.evidence = Objects.requireNonNull(evidence, "evidence must not be null.")
        this.parameters = Objects.requireNonNull(parameters, "parameters must not be null.")
        this.peptides = Objects.requireNonNull(peptides, "peptides must not be null.")
        this.proteinGroups = Objects.requireNonNull(proteinGroups, "proteinGroups must not be null.")
        this.runParameters = Objects.requireNonNull(runParameters, "runParameters must not be null.")
        this.sampleIds = Objects.requireNonNull(sampleIds, "sampleIds must not be null.")
    }

    /**
     * Static factory method that creates a new maxQuantRunResult instance from the bioinformatic pipeline output.
     * See this @{link <a href="https://github.com/qbicsoftware/data-model-lib/blob/master/src/test/resources/examples/resultset/maxquant/valid-resultset-example_latest.json">example</a>}
     * for a JSON representation of a valid map structure
     *
     * @param Map maxQuantRunOutput
     * @return MaxQuantRunResult A new instance of a maxQuantRunResult object.
     * @since 2.10.0
     */
    static MaxQuantRunResult createFrom(Map maxQuantRunOutput) {

        //Check if the required folders are in the root directory
        Objects.requireNonNull(maxQuantRunOutput.get("allPeptides"), "The provided directory must contain a allPeptides.txt file.")
        Objects.requireNonNull(maxQuantRunOutput.get("evidence"), "The provided directory must contain a evidence.txt file.")
        Objects.requireNonNull(maxQuantRunOutput.get("parameters"), "The provided directory must contain a parameters.txt file.")
        Objects.requireNonNull(maxQuantRunOutput.get("peptides"), "The provided directory must contain a peptides.txt file.")
        Objects.requireNonNull(maxQuantRunOutput.get("proteinGroups"), "The provided directory must contain a proteinGroups.txt file.")
        Objects.requireNonNull(maxQuantRunOutput.get("runParameters"), "The provided director must contain a runParameters.xml file.")
        Objects.requireNonNull(maxQuantRunOutput.get("sampleIds"), "The provided directory must contain a sampleIds.txt file.")

        //Get Files from Root Directory
        AllPeptides allPeptides = parseFile(maxQuantRunOutput.get("allPeptides") as Map) as AllPeptides
        Evidence evidence  = parseFile(maxQuantRunOutput.get("evidence") as Map) as Evidence
        Parameters parameters = parseFile(maxQuantRunOutput.get("parameters") as Map) as Parameters
        Peptides peptides = parseFile(maxQuantRunOutput.get("peptides") as Map) as Peptides
        ProteinGroups proteinGroups = parseFile(maxQuantRunOutput.get("proteinGroups") as Map) as ProteinGroups
        RunParameters runParameters = parseFile(maxQuantRunOutput.get("runParameters") as Map) as RunParameters
        SampleIds sampleIds = parseFile(maxQuantRunOutput.get("sampleIds") as Map) as SampleIds

        //Create new MaxQuantRunResult object with parsed information
        return new MaxQuantRunResult(allPeptides, evidence, parameters, peptides, proteinGroups, runParameters, sampleIds)
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
     * Provides access to the information stored in the sampleIds file
     * @return SampleIds
     * @since 2.10.0
     */
    SampleIds getSampleIds() {
        return sampleIds
    }

    /*
     * Helper method that creates a DataFile instance from a map
     */
    private static DataFile parseFile(Map fileTree) throws IllegalArgumentException {
        String name = fileTree.get("name")
        String path = fileTree.get("path")
        
        for (String maxQuantFileType : maxQuantFileTypes) {
            Class<?> c = Class.forName(maxQuantFileType)
            Method method = c.getDeclaredMethod("create", String.class, String.class)
            try {
                DataFile dataFile = method.invoke(null, name, path) as DataFile
                return dataFile
            } catch (InvocationTargetException e) {
                // Do nothing as we need to try out all specialisations that extend the
                // DataFile class

            }
        }

        // If we cannot create a DataFile object at all, throw an exception
        throw new IllegalArgumentException("File $name with path $path is of unknown maxQuant file type.")
    }
}
