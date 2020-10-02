package life.qbic.datamodel.printing;

import java.util.List;

/**
 * Interface for openBIS sample models. This can be used to hold, register or visualize sample
 * metadata
 * 
 * @author Andreas Friedrich
 * 
 */
public interface IBarcodeBean {

  // help:
  // NewModelBarcodeBean(s.getCode(), view.getCodedString(s), view.getInfo1(s),
  // view.getInfo2(s), bioType, parentMap.get(s), s.getProperties().get(
  // "Q_SECONDARY_NAME")));

  String getCode();

  String getCodedString();//shows up on top of tube barcodes, is one of the other infos

  String firstInfo();
  
  String altInfo();

  String getSecondaryName();

  String getType();
  
  String getExtID();

  List<String> fetchParentIDs();

  boolean hasParents();

}
