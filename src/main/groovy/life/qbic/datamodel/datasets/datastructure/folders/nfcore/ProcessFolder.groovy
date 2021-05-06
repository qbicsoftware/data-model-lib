package life.qbic.datamodel.datasets.datastructure.folders.nfcore

import life.qbic.datamodel.datasets.datastructure.files.DataFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder,
 *
 * Its children field contains a list of type List<DataFile> or type List<DataFolder>
 *
 * @since 2.5.0
 */
class ProcessFolder extends DataFolder {

    protected ProcessFolder() {}

    protected ProcessFolder(String name, String relativePath, List<?> children) {
        super(name, relativePath, children)

    }

    /**
     * Creates a new instance of a ProcessFolder object
     *
     * @param name The folder name
     * @param relativePath The relative path of the folder
     * @param children A list with child elements of the folder
     * @return A new instance of a ProcessFolder object
     */
    static ProcessFolder create(String name, String relativePath, List<?> children) {
        new ProcessFolder(name, relativePath, children)
    }

}
