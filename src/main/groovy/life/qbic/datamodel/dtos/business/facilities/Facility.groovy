package life.qbic.datamodel.dtos.business.facilities

/**
 * <p>Controlled vocabulary for concise core facility labels.</p>
 *
 * <p>The following facilities are currently defined:</p>
 *
 * <ul>
 *     <li>CFMB: Core Facility for Medical Bioanalytics</li>
 *     <li>IMGAG: Institute for Medical Genetics and Applied Genomics</li>
 *     <li>MGM: Institute for Medical Microbiology and Hygiene</li>
 *     <li>QBIC: Quantitative Biology Center</li>
 *     <li>PCT: Proteome Center Tübingen</li>
 * </ul>
 *
 * @since 2.11.0
 */
enum Facility {

    CFMB("Core Facility for Medical Bioanalytics"),
    IMGAG("Institute for Medical Genetics and Applied Genomics"),
    MGM("Institute for Medical Microbiology and Hygiene"),
    QBIC("Quantitative Biology Center"),
    PCT("Proteome Center Tübingen")

    private final String value

    Facility(String value) {
        this.value = value
    }
    /**
     * Returns to the enum item value
     * @return
     */
    String getValue() {
        return this.value
    }

    /**
     * Returns a String representation of the enum item
     * @return
     */
    @Override
    String toString() {
        return this.getValue()
    }

}