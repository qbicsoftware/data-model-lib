package life.qbic.datamodel.dtos.imaging.properties

/**
 * DTO that describes the area of an image
 *
 * This class should be used to describe area information for imaging data
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
class Area {

    /**
     * The area is constructed as follows:
     * (x/y,y/z)
     * It is stored in µm
     */
    private final List<Integer> area
}
