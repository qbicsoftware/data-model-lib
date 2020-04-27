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

    protected Fast5PassFolder(String path, List<?> children) {
        super(NAME, path, children)
    }

    static Fast5PassFolder create(String path, List<?> children) {
        new Fast5PassFolder(path, children)
    }
}
