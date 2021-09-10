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

    CFMB("Core Facility for Medical Bioanalytics", "CFMB"),
    IMGAG("Institute for Medical Genetics and Applied Genomics", "IMGAG"),
    MGM("Institute for Medical Microbiology and Hygiene", "MGM"),
    QBIC("Quantitative Biology Center", "QBIC"),
    CFMB_PCT("Proteomics Facility Tübingen", "Proteomics Facility")

    private final String fullName
    private final String label

    /**
     * Creates an instance of a facility enum
     * @param fullName The full name representation of the facility
     */
    Facility(String fullName) {
        this.fullName = fullName
        this.label = ""
    }

    /**
     * Creates an instance of a facility enum with shorthand label
     * @param fullName The full name representation of the facility
     * @param label The shorthand label of the facility
     */
    Facility(String fullName, String label) {
        this(fullName)
        this.label = label
    }


    /**
     * Returns to the full name representation of the facility
     * @return
     */
    String getFullName() {
        return this.fullName
    }

    /**
     * Returns the short representation form of the facility
     * @return
     */
    String getLabel() {
       return this.label
    }

    /**
     * Returns a String representation of the facility enum.
     *
     * Is equivalent to {@link #getFullName()}.
     * @return
     */
    @Override
    String toString() {
        return this.getFullName()
    }
}
