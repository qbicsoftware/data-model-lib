package life.qbic.datamodel.attachments;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AttachmentInformation {

  private String name;
  private String secondary_name;
  private String user;
  private String barcode;
  private String type;
  private String timeStamp;

  public AttachmentInformation(String name, String secondary_name, String type, String user,
      String barcode, String timeStamp) {
    this.type = type;
    this.name = name;
    this.secondary_name = secondary_name;
    this.user = user;
    this.barcode = barcode;
    this.timeStamp = timeStamp;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getInfo() {
    return secondary_name;
  }

  public String getUser() {
    return user;
  }

  public String getBarcode() {
    return barcode;
  }

  /**
   * Returns the file name as it should be sent to the dropbox handler, including barcode, user name
   * and optional secondary name. Paths still need to be handled by a controller class.
   * 
   * @return
   */
//  public String getTargetFileName() {
//    String ext = "";
//    int i = name.lastIndexOf('.');
//    if (i > 0) {
//      ext = "." + name.substring(i + 1);
//    }
//    String res = barcode + "_" + name.replace(ext, "") + "_user_" + user;
//    if (secondary_name != null && !secondary_name.isEmpty())
//      res += "_secname_" + secondary_name;
//    res = res.replace(" ", "_").replace("up_", "") + ext;
//    try {
//      res = URLEncoder.encode(res, "UTF-8").replace("+", "%20"); // URL Encoder replaces whitespaces
//                                                                 // with '+' ...
//    } catch (UnsupportedEncodingException e) {
//      e.printStackTrace();
//    }
//    return res;
//  }

  /**
   * Returns a folder name (excluding slash suffix) based on a timestamp for this attachment file
   * and its metadata file
   * 
   * @return
   */
  public String getFolder() {
    return timeStamp;
  }

  public String getFileName() {
//    String res = name.replaceFirst("up_", "");
    String res = null;
    try {
      res = URLEncoder.encode(name, "UTF-8").replace("+", "%20"); // URL Encoder replaces whitespaces                                                                 // with '+' ...
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return res;
  }

}
