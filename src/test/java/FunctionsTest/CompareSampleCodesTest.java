package FunctionsTest;

import org.junit.Test;

import life.qbic.datamodel.identifiers.SampleCodeFunctions;

import static org.junit.Assert.assertEquals;

public class CompareSampleCodesTest {

  @Test
  public void twoEqualSampleCodes() {
    assertEquals(0, SampleCodeFunctions.compareSampleCodes("QABCD002AC", "QABCD002AC"));
  }

  @Test
  public void twoDifferentSampleCodes() {
    assertEquals(1, SampleCodeFunctions.compareSampleCodes("QABCD003AB", "QABCD002AC"));
  }
}
