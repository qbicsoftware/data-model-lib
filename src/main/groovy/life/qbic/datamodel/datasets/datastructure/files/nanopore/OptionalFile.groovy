package life.qbic.datamodel.datasets.datastructure.files.nanopore

import life.qbic.datamodel.datasets.datastructure.files.DataFile

/**
 * Unspecific OptionalFile used to store unexpected file in the nanopore registration
 *
 * The high variety of the nanopore datasets registered made an optional all-purpose Datafile structure necessary.
 *
 */
class OptionalFile extends DataFile {

  protected OptionalFile() {}

  protected OptionalFile(String name, String relativePath, String fileType) {
    super(name, relativePath, fileType)
  }

  /**
   * Creates a new instance of a OptionalFile object
   * @param name The name of the file
   * @param relativePath The relative path of the file
   * @param fileType The suffix specifying the file type of the file
   * @return A new instance of a OptionalFile object
   */
  static OptionalFile create(String name, String relativePath, String fileType) {
    return new OptionalFile(name, relativePath, fileType)
  }
}
