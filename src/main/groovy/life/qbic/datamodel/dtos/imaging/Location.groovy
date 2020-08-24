package life.qbic.datamodel.dtos.imaging

import life.qbic.datamodel.people.Address

/**
 * DTO that describes the location of an instrument.
 *
 * This class shall be used whenever location information
 *
 * @author Sven Fillinger
 * @since 1.10.0
 */
class Location {

  /**
   * An identifier for a room an instrument is located at.
   */
  private final String roomId

  /**
   * An address that describes the location of an instrument.
   *
   * @see: #life.qbic.datamodel.people.Address
   */
  private final Address address

  /**
   * DTO that describes the location of an instrument.
   * @param roomId {@link Location#roomId}
   * @param address {@link Location#address}
   */
  Location(String roomId, Address address) {
    this.roomId = roomId
    this.address = address
  }
}
