package life.qbic.datamodel.dtos.imaging.properties

/**
 * DTO that describes a position on an image
 *
 * This class should be used to describe a position on an image
 *
 * @since: 1.10.0
 * @author: Jennifer Bödker
 *
 */
class Position {

    /**
     * Describes the position on the x-axis
     * This could be e.g 20 µm (depending on the defined unit)
     *
     * Always a positive number
     */
    final Float x

    /**
     * Describes the position on the y-axis
     * This could be e.g 60 µm (depending on the defined unit)
     *
     * Always a positive number
     */
    final Float y

    /**
     * Describes the position on the z-axis
     * This could be e.g 60 µm (depending on the defined unit)
     *
     * As default this value can be put to 0 if its not required
     *
     * Always a positive number
     */
    final Float z

    /**
     * DTO that describes a position on an image
     * @param x {@link Position#x}
     * @param y {@link Position#y}
     * @param z {@link Position#z}
     */
    Position(Float x, Float y, Float z) {
        this.x = x
        this.y = y
        this.z = z
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Position position = (Position) o

        if (x != position.x) return false
        if (y != position.y) return false
        if (z != position.z) return false

        return true
    }

    int hashCode() {
        int result
        result = (x != null ? x.hashCode() : 0)
        result = 31 * result + (y != null ? y.hashCode() : 0)
        result = 31 * result + (z != null ? z.hashCode() : 0)
        return result
    }
}
