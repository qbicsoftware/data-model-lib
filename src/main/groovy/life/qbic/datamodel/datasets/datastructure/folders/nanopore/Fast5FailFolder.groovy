package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * A special case of a DataFolder, its name is always fast5_fail.
 *
 * Its children field contains either a list of type List<Fast5Files> or List<Fast5Folder>
 *
 * @author: Sven Fillinger
 */
class Fast5FailFolder extends DataFolder {

    final private static String NAME = "fast5_fail"

    protected Fast5FailFolder() {}

    protected Fast5FailFolder(String relativePath, List<?> children) {
        super(NAME, relativePath, children)
    }

    static Fast5FailFolder create(String relativePath, List<?> children) {
        new Fast5FailFolder(relativePath, children)
    }

}
