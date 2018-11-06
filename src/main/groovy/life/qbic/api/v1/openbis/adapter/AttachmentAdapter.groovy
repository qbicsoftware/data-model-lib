package life.qbic.api.v1.openbis.adapter

import life.qbic.api.v1.qbicobject.QbicAttachment
import life.qbic.api.v1.qbicobject.QbicAttachmentFetchOptions
import life.qbic.api.v1.qbicobject.QbicPerson

interface AttachmentAdapter {

    byte[] getContent()

    String getDescription()

    QbicAttachmentFetchOptions getFetchOptions()

    String getFileName()

    String getLatestVersionPermlink()

    String getPermlink()

    QbicAttachment getPreviousVersion()

    Date getRegistrationDate()

    QbicPerson getRegistrator()

    String getTitle()

    Integer getVersion()

}
