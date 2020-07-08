package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.files.nanopore.Fast5File
import life.qbic.datamodel.datasets.datastructure.files.nanopore.FastQFile
import life.qbic.datamodel.datasets.datastructure.files.nanopore.FastQZippedFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
/**
 * A data folder, which name contains `unclassified` read information and contains only fast5 files.
 *
 * This class should be used, when there is unclassified read information available in
 * an Oxford Nanopore sequencing measurement. Unclassified means, that the read barcode used to
 * determine the sample origin was unknown or missing.
 *
 * The children of this folder are always of type Fast5File.
 *
 * The name of an unclassified folder type must contain the substring `unclassified` in order
 * to get determined as such.
 *
 * @author Sven Fillinger
 * @since 1.9.0
 */
class UnclassifiedFast5Folder extends DataFolder {

    final private static String NAME_SCHEMA = /unclassified/

    protected UnclassifiedFast5Folder() {}

    protected UnclassifiedFast5Folder(String name, String relativePath, List children) {
        super(name, relativePath, children)
        validateName()
    }
    /**
     * Creates a new instance of a UnclassifiedFastQFolder object
     * @param relativePath The relative path of the folder
     * @param children A list with FastQFile elements of the folder
     * @return A new instance of a UnclassifiedFastQFolder object
     */
    static UnclassifiedFast5Folder create(String name, String relativePath, List<Fast5File> children) {
        if (children) {
            validateChildren(children)
        }
        new UnclassifiedFast5Folder(name, relativePath, children)
    }

    private static void validateChildren(List children) {
        children.each { validateChild(it) }
    }

    private static void validateChild(Object child) {
        if (!(child instanceof Fast5File)) {
            throw new IllegalArgumentException("Children must  match the Nanopore UnclassifiedFastQFolder directory schema!")
        }
    }

    private void validateName() {
        if (!(this.relativePath =~ /fast5/)) {
            throw new IllegalArgumentException("Unclassified Fast5 folder must have a parent with name \'fast5\'.")
        }
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore UnclassifiedFastQFolder directory schema!")
        }
    }
}
