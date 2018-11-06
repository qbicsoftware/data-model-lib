package life.qbic.api.v1.openbis.adapter

import life.qbic.api.v1.qbicobject.QbicSample

/**
 * Provides an access interface for `QbicSample` objects.
 *
 * @author: Sven Fillinger, QBiC
 */
interface SampleAdapter {

    List<QbicAttachment> getAttachments()

    List<QbicSample> getChildren()

    def getCode()

    def getComponents()

    def getContainer()

    def getDataSets()

    def getExperiment()

    def getFetchOptions()

    def getHistory()

    def getIdentifier()

    def getMaterialProperties()

    def getMaterialProperty(propertyName)

    def getModificationDate()

    def getModifier()

    def getParents()

    def getPermId()

    def getProject()

    def getProperties()

    def getProperty(propertyName)

    def getRegistrationDate()

    def getRegistrator()

    def getSpace()

    def getTags()

    def getType()

    def setChildren(List<SampleAdapter> children)
}
