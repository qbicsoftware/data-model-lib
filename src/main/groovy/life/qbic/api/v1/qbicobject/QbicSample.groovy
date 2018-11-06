package life.qbic.api.v1.qbicobject


import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.Sample
import life.qbic.api.v1.openbis.adapter.AttachmentAdapter
import life.qbic.api.v1.openbis.adapter.SampleAdapter

class QbicSample implements SampleAdapter{

    private final Sample openbisSample

    QbicSample(openbisSample){
        this.openbisSample = openbisSample
    }

    @Override
    List<AttachmentAdapter> getAttachments() {
        return null
    }

    @Override
    List<SampleAdapter> getChildren() {
        return this.openbisSample.children.collect { new QbicSample(it) }
    }

    @Override
    String getCode() {
        return this.openbisSample.getCode()
    }

    @Override
    List<QbicSample> getComponents() {
        return null
    }

    @Override
    QbicSample getContainer() {
        return null
    }

    @Override
    def getDataSets() {
        return null
    }

    @Override
    def getExperiment() {
        return null
    }

    @Override
    def getFetchOptions() {
        return null
    }

    @Override
    def getHistory() {
        return null
    }

    @Override
    def getIdentifier() {
        return null
    }

    @Override
    def getMaterialProperties() {
        return null
    }

    @Override
    def getMaterialProperty(Object propertyName) {
        return null
    }

    @Override
    def getModificationDate() {
        return null
    }

    @Override
    def getModifier() {
        return null
    }

    @Override
    def getParents() {
        return null
    }

    @Override
    def getPermId() {
        return null
    }

    @Override
    def getProject() {
        return null
    }

    @Override
    def getProperties() {
        return null
    }

    @Override
    def getProperty(Object propertyName) {
        return null
    }

    @Override
    def getRegistrationDate() {
        return null
    }

    @Override
    def getRegistrator() {
        return null
    }

    @Override
    def getSpace() {
        return null
    }

    @Override
    def getTags() {
        return null
    }

    @Override
    def getType() {
        return null
    }

    @Override
    def setChildren(List<SampleAdapter> children) {
        return null
    }
}
