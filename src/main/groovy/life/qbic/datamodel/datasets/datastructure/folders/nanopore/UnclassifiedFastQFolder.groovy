package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.files.nanopore.FastQFile
import life.qbic.datamodel.datasets.datastructure.files.nanopore.FastQZippedFile
import life.qbic.datamodel.datasets.datastructure.folders.DataFolder
/**
 * A data folder, which name contains `unclassified` read information and contains only fastq files.
 *
 * This class should be used, when there is unclassified read information available in
 * an Oxford Nanopore sequencing measurement. Unclassified means, that the read barcode used to
 * determine the sample origin was unknown or missing.
 *
 * The children of this folder are always of type FastQFile.
 *
 * The name of an unclassified folder type must contain the substring `unclassified` in order
 * to get determined as such.
 *
 * @author Sven Fillinger
 * @since 1.9.0
 */
class UnclassifiedFastQFolder extends DataFolder {

    final private static String NAME_SCHEMA = /unclassified/

    protected UnclassifiedFastQFolder() {}

    protected UnclassifiedFastQFolder(String name, String relativePath, List children) {
        super(name, relativePath, children)
        validateName()
    }
    /**
     * Creates a new instance of a UnclassifiedFastQFolder object
     * @param relativePath The relative path of the folder
     * @param children A list with FastQFile or FastQZipped elements of the folder
     * @return A new instance of a UnclassifiedFastQFolder object
     */
    static UnclassifiedFastQFolder create(String name, String relativePath, List<?> children) {
        if (children) {
            validateChildren(children)
        }
        new UnclassifiedFastQFolder(name, relativePath, children)
    }

    private static void validateChildren(List children) {
        children.each { validateChild(it) }
    }

    private static void validateChild(Object child) {
        if (!((child instanceof FastQFile) || (child instanceof FastQZippedFile))) {
            throw new IllegalArgumentException("Children must  match the Nanopore UnclassifiedFastQFolder directory schema!")
        }
    }

    private void validateName() {
        if (!(this.relativePath =~ /fastq/)) {
            throw new IllegalArgumentException("Unclassified FastQ folder must have a parent with name \'fastq\'.")
        }
        if (!(this.name =~ NAME_SCHEMA)) {
            throw new IllegalArgumentException("Name must match the Nanopore UnclassifiedFastQFolder directory schema!")
        }
    }
}
