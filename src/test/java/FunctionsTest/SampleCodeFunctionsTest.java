package FunctionsTest;

import org.junit.Test;

import life.qbic.datamodel.identifiers.SampleCodeFunctions;

import static org.junit.Assert.assertEquals;

public class SampleCodeFunctionsTest {

  @Test
  public void entityCodeIsNotSampleCode() {
    assertEquals(false, SampleCodeFunctions.isQbicBarcode("QABCDENTITY-12"));
  }
  
  @Test
  public void entityCodeIsValid() {
    assertEquals(true, SampleCodeFunctions.isQbicEntityCode("QABCDENTITY-12"));
    assertEquals(true, SampleCodeFunctions.isQbicEntityCode("QABCDENTITY-12123132"));
    //leading zero
    assertEquals(false, SampleCodeFunctions.isQbicEntityCode("QABCDENTITY-02"));
  }
  
  @Test
  public void sampleCodeIsValid() {
    //wrong checksum
    assertEquals(false, SampleCodeFunctions.isQbicBarcode("QABCD002AC"));
    assertEquals(true, SampleCodeFunctions.isQbicBarcode("QABCD002A8"));
  }
  
  @Test
  public void sampleCodeIsNotEntityCode() {
    assertEquals(false, SampleCodeFunctions.isQbicEntityCode("QABCD002A8"));
  }

}
