package life.qbic.datamodel.datasets

/**
 * <add class description here>
 *
 * @author: Sven Fillinger
 */
class OxfordNanoporeMeasurement<T> {

    final private Map nanoporeMeasurementsFileTree

    private List<T> fast5PassedContent

    OxfordNanoporeMeasurement(Map fileTree) {
        this.nanoporeMeasurementsFileTree = fileTree
        createFast5PassedContent()
    }

    private createFast5PassedContent() {
        List content = (List) nanoporeMeasurementsFileTree."fast5_fail".content
        if (content.get(0) instanceof String) {
            fast5PassedContent = new ArrayList<>()
            content.each {fast5PassedContent.add(it as T)}
        } else if ((content.get(0) instanceof Map)){
            fast5PassedContent = new ArrayList<>()
            content.each {fast5PassedContent.add( new NanoporePooledFolder(it as Map) as T )}
        } else {
            throw new IllegalArgumentException("Only String.class or Map.class objects allowed.")
        }
    }

    /**
     *
     * @return
     */
    List<T> getFast5PassedContent() {
        return fast5PassedContent
    }

    List<T> get



}
