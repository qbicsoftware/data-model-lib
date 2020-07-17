# Usage examples

- [Instrument output schemas](#instrument-output-schemas)

## Instrument output schemas

The data model library provides access to different sequencer output schemas
in JSON that have been defined in collaboration with the labs.

**Oxford Nanopore output**

The schema for the Oxford Nanopore instrument output can be accessed via the
`OxfordNanoporeInstrumentOutput` class:

```JAVA
import life.qbic.datamodel.instruments.*;

public class SchemaImport {
  public static void main(String[] args) {
    InputStream inputStream = OxfordNanoporeInstrumentOutput.getSchemaAsStream();
  }
}
```