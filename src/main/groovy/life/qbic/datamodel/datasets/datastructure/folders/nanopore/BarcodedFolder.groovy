package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
import life.qbic.datamodel.identifiers.SampleCodeFunctions

/**
 * Specialisation version of a Folder object.
 *
 * The folder name must contain the QBiC barcode.
 *
 * @author: Sven Fillinger
 */
class BarcodedFolder extends DataFolder {

    private String sampleId

    protected BarcodedFolder() {}

    protected BarcodedFolder(String name, String relativePath, List children) {
        super(name, relativePath, children)
        validateName()
    }

    private void validateName() {
        final def ids = SampleCodeFunctions.findAllQbicSampleIds(this.name)
        if ( ids.isEmpty()) {
            throw new IllegalArgumentException("Name must match the QBiC sample id schema!")
        }
        if ( ids.size() > 1 ) {
            throw new IllegalArgumentException("Name contained more than valid sample id!")
        }
        sampleId = ids.get(0)
    }

    /**
     * Returns the sample id of the barcoded folder
     * @return
     */
    String getSampleId() {
        return this.sampleId
    }
}
