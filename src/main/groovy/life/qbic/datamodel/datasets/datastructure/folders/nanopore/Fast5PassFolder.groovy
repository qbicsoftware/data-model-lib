package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class Fast5PassFolder extends DataFolder {

    final private static String NAME = "fast5_pass"

    protected Fast5PassFolder() {}

    protected Fast5PassFolder(String relativePath, List<?> children) {
        super(NAME, relativePath, children)
    }

    static Fast5PassFolder create(String relativePath, List<?> children) {
        new Fast5PassFolder(relativePath, children)
    }
}
