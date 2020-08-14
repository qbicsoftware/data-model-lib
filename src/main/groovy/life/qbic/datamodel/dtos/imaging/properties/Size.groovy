package life.qbic.datamodel.dtos.imaging.properties

/**
 * DTO to describe the size of an object in context of imaging
 *
 * This class should be used whenever the size of an object needs to be described
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
class Size {

    /**
     * Describes the size of an object.
     */
    private final Float size

    /**
     * Describes the unit of the defined size
     * e.g µm
     */
    private final String unit
}
