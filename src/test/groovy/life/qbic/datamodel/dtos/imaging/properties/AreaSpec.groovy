package life.qbic.datamodel.dtos.imaging.properties

import spock.lang.Specification

/**
 * <class short description - 1 Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @author Sven Fillinger
 * @since 1.10.0
 */
class AreaSpec extends Specification {

  def "Create an Area object successfully"() {
    given:
    Integer dimensionValueOne = 19
    Integer dimensionValueTwo = 20
    ImagePlane imagePlane = ImagePlane.XY

    when:
    Area area = new Area(dimensionValueOne,
        dimensionValueTwo,
        imagePlane)

    then:
    assert area.firstDimensionValue.equals(19)
  }

}
