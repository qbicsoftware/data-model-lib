package life.qbic.datamodel.notes;

import java.io.File;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

public class HistoryReader {

  private static final String MODEL_NOTES_CONTEXT_PATH = "life.qbic.datamodel.model.notes";

  public static List<Note> parseXMLNotes(String value) {
    List<Note> notes = new ArrayList<Note>();
    try {
      JAXBElement<Notes> jaxbelem = HistoryReader.parseNotes(value);
      notes = jaxbelem.getValue().getNote();
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return notes;
  }

  /**
   * returns a {@link historybeans.Notes} instance.
   * 
   * @param notes a xml file that contains notes.
   * @return historybeans.Notes which is a bean representation of the notes saved in openbis
   * @throws JAXBException
   */
  public static JAXBElement<Notes> parseNotes(File notes) throws JAXBException {
    JAXBContext jaxbContext;
    jaxbContext = JAXBContext.newInstance(MODEL_NOTES_CONTEXT_PATH);
    javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    StreamSource source = new StreamSource(notes);
    JAXBElement<Notes> customerElement = unmarshaller.unmarshal(source, Notes.class);
    return customerElement;
  }

  /**
   * returns a {@link historybeans.Notes} instance.
   * 
   * @param notes a xml string that contains notes.
   * @return historybeans.Notes which is a bean representation of the notes saved in openbis
   * @throws JAXBException
   */
  public static JAXBElement<Notes> parseNotes(String notes) throws JAXBException {
    JAXBContext jaxbContext;
    jaxbContext = JAXBContext.newInstance(MODEL_NOTES_CONTEXT_PATH);
    javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

    StreamSource source = new StreamSource(new StringReader(notes));
    JAXBElement<Notes> customerElement = unmarshaller.unmarshal(source, Notes.class);
    return customerElement;
  }

  /**
   * Write the jaxbelem (contains the notes as beans) back as xml into the outputstream
   * 
   * @param jaxbelem
   * @param os
   * @throws JAXBException
   */
  public static void writeNotes(JAXBElement<Notes> jaxbelem, OutputStream os) throws JAXBException {
    JAXBContext jaxbContext;
    jaxbContext = JAXBContext.newInstance(MODEL_NOTES_CONTEXT_PATH);
    javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.marshal(jaxbelem, os);
  }

  /**
   * writes notes as a xml into the stringwriter. After that method the string can be retrieved with
   * stringwriter.tostring
   * 
   * @param jaxbelem
   * @param sw
   * @throws JAXBException
   */
  public static void writeNotes(JAXBElement<Notes> jaxbelem, StringWriter sw) throws JAXBException {
    JAXBContext jaxbContext;
    jaxbContext = JAXBContext.newInstance(MODEL_NOTES_CONTEXT_PATH);
    javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.marshal(jaxbelem, sw);
  }


}
