package life.qbic.datamodel.identifiers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExperimentCodeFunctions {

  private static final Logger logger = LogManager.getLogger(ExperimentCodeFunctions.class);

  /**
   * returns -1 if code doesn't fit standard or integer can't be parsed
   * 
   * @param project
   * @param code
   * @return
   */
//  public static int getNumSuffixOfExperimentCode(String project, String code) {
//    String[] split = code.split(project + "E");
//    int num = -1;
//    if (code.startsWith(project + "E") && split.length > 1) {
//      try {
//        num = Integer.parseInt(split[1]);
//      } catch (Exception e2) {
//        logger.warn("could not parse id of experiment" + code);
//      }
//    }
//    return num;
//  }

  public static String getInfoExperimentID(String space, String project) {
    return "/" + space + "/" + project + "/" + project + "_INFO";
  }

  public static String getExperimentIdentifier(String space, String project, String exp) {
    return "/" + space + "/" + project + "/" + exp;
  }

  public static String getExperimentIdentifier(String space, String project, int expIndex) {
    return getExperimentIdentifier(space, project, project + Integer.toString(expIndex));
  }
}
