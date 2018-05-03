package life.qbic.datamodel.attachments;


public class AttachmentConfig {
  
  private int maxSize;
  private String uri;
  private String user;
  private String pass;
  
  public AttachmentConfig(int size, String uri, String user, String pass) {
    this.maxSize = size;
    this.uri = uri;
    this.user = user;
    this.pass = pass;
  }

  public int getMaxSize() {
    return maxSize;
  }

  public String getUri() {
    return uri;
  }

  public String getUser() {
    return user;
  }

  public String getPass() {
    return pass;
  }

}
