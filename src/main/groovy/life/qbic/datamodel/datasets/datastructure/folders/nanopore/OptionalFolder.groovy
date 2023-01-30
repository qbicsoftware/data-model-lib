package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * Unspecific Optional Folder used to store unexpected folders in the nanopore registration
 *
 * The high variety of the nanopore datasets registered made an optional all-purpose Datafolder structure necessary.
 *
 */
class OptionalFolder extends DataFolder {

  protected OptionalFolder() {}

  protected OptionalFolder(String name, String relativePath, List children) {
    super(name, relativePath, children)
  }

  /**
   * Creates a new instance of a OptionalFolder object
   * @param relativePath The relative path of the folder
   * @param children A list with child elements of unknown type of the folder
   * @return A new instance of a OptionalFolder object
   */
  static OptionalFolder create(String name, String relativePath, List<?> children) {
    new OptionalFolder(name, relativePath, children)
  }

}
