package life.qbic.api.v1.qbicobject

import life.qbic.api.v1.openbis.adapter.AttachmentAdapter

class QbicAttachment implements AttachmentAdapter{


    @Override
    byte[] getContent() {
        return new byte[0]
    }

    @Override
    String getDescription() {
        return null
    }

    @Override
    QbicAttachmentFetchOptions getFetchOptions() {
        return null
    }

    @Override
    String getFileName() {
        return null
    }

    @Override
    String getLatestVersionPermlink() {
        return null
    }

    @Override
    String getPermlink() {
        return null
    }

    @Override
    QbicAttachment getPreviousVersion() {
        return null
    }

    @Override
    Date getRegistrationDate() {
        return null
    }

    @Override
    QbicPerson getRegistrator() {
        return null
    }

    @Override
    String getTitle() {
        return null
    }

    @Override
    Integer getVersion() {
        return null
    }
}
