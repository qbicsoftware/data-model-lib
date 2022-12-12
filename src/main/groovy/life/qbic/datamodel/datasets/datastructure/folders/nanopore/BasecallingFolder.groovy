package life.qbic.datamodel.datasets.datastructure.folders.nanopore

import life.qbic.datamodel.datasets.datastructure.folders.DataFolder

/**
 * <class short description - One Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 *
 */
class BasecallingFolder extends DataFolder {
  /**
   * The name schema of a basecalling folder contained within the nanopore dataset.
   *
   */
  final private static String NAME_SCHEMA = /basecalling/

  protected BasecallingFolder() {}

  protected BasecallingFolder(String name, String relativePath, List children) {
    super(name, relativePath, children)
    validateName()
  }

  /**
   * Creates a new instance of a BasecallingFolder object
   * @param relativePath The relative path of the folder
   * @param children A list with child elements of unknown type of the folder
   * @return A new instance of a BasecallingFolder object
   */
  static BasecallingFolder create(String name, String relativePath, List<?> children) {
    new BasecallingFolder(name, relativePath, children)
  }

  private void validateName() {
    if (!(this.name =~ NAME_SCHEMA)) {
      throw new IllegalArgumentException("Name must match the Nanopore Basecalling schema!")
    }
  }
}
