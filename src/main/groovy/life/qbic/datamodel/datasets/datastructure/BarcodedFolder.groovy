package life.qbic.datamodel.datasets.datastructure

/**
 * Specialisation version of a Folder object.
 * 
 * The folder name must contain the QBiC barcode.
 *
 * @author: Sven Fillinger
 */
class BarcodedFolder extends DataFolder {

    final private static String PATTERN = $/Q\w{4}\d{3}[A-X][A-X0-9].*/$

    protected BarcodedFolder() {}

    protected BarcodedFolder(String name, String path, List children) {
        super(name, path, children)
        validateName()
    }

    static BarcodedFolder create(String name, String path, List children) {
        new BarcodedFolder(name, path, children)
    }

    private void validateName() {
        if (!(this.name =~ PATTERN)) {
            throw new IllegalArgumentException("Name must match the QBiC barcode regex!")
        }
    }
}
