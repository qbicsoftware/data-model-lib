package life.qbic.datamodel.dtos.imaging.parameters

import life.qbic.datamodel.dtos.imaging.parameters.srm.SRMHardware
import life.qbic.datamodel.dtos.imaging.properties.Detector
import life.qbic.datamodel.dtos.imaging.properties.IlluminationMode
import spock.lang.Specification

/**
 * <class short description - 1 Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @author Sven Fillinger
 * @since <versiontag>
 */
class SRMHardwareSpec extends Specification {

  def "create SRMHardwareSpec successfully"() {
    given:
    SRMHardware.Builder builder = new SRMHardware.Builder("Test Objective", new Detector())

    when:
    builder.laserLinesPulsed = 2
    SRMHardware hardware = builder.build()

    then:
    assert hardware.laserLinesPulsed.equals(2)
    assert hardware.illuminationMode.equals(IlluminationMode.UNKNOWN)
  }



}
