# Usage examples

- [Instrument output schemas](#instrument-output-schemas)

## Instrument output schemas

The data model library provides access to different sequencer output schemas
in JSON that have been defined in collaboration with the labs.

### Oxford Nanopore output

#### Create Nanopore Experiment Object

In order to create an instance of type `OxfordNanoporeExperiment`, you need to provide a map that provides content following the [Nanopore Instrument Output Schema JSON](./src/main/resources/schemas/nanopore-instrument-output.schema.json).  
Every measurement folder also needs to be enriched with metadata, which itself is specified with another [JSON schema](./src/main/resources/schemas/ont-metadata.schema.json).

The final map contains an additional `metadata` property for each measurement, that for example can look like this:

```
{
    "name": "QABCD001AB_E12A345a01_PAE12345",
    "path": "./",
    "children": [
        {
            "name": "20200122_1217_1-A1-B1-PAE12345_1234567a",
            "metadata":  {
                "adapter": "flongle",
                "asic_temp": "32.631687",
                "base_caller": "Guppy",
                "base_caller_version": "3.2.8+bd67289",
                "device_type" : "promethion",
                "flow_cell_id": "PAE26306",
                "flow_cell_product_code": "FLO-PRO002",
                "flow_cell_position": "2-A3-D3",
                "hostname": "PCT0094",
                "protocol": "sequencing/sequencing_PRO002_DNA:FLO-PRO002:SQK-LSK109:True",
                "started": "2020-02-11T15:52:10.465982+01:00"
            },
            "path": "./20200122_1217_1-A1-B1-PAE12345_1234567a",
            ...
            ]
}
```

You can than use the data model API to create an `OxfordNanoporeExperiment` with this static factory method:

```groovy
import life.qbic.datamodel.datasets.OxfordNanoporeExperiment

// Replace with a real map that follows the schema
def outputMap = [:]

def onExperiment = OxfordNanoporeExperiment.create(outputMap)
```

#### Access Schema for Nanopore Data Structure

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

### Nf Core pipeline output

#### Create NfCore Experiment Object

In order to create an instance of type `NfCorePipelineResult`, you need to provide a map that provides content following the [Nfcore Pipeline Output Schema JSON](./src/main/resources/schemas/bioinformatics-analysis-result-set.schema.json).  

You can than use the data model API to create an `NfCorePipelineResult` with this static factory method:

```groovy
import life.qbic.datamodel.datasets.NfCorePipelineResult

// Replace with a real map that follows the schema
Map outputMap = [:]

def nfCorePipelineOutput = NfCorePipelineResult.create(outputMap)
```

#### Access Schema for NF-Core Data Structure 

The schema for the nf core pipeline output can be accessed via the
`NfCorePipelineResult` class:

```JAVA
import life.qbic.datamodel.instruments.*;

public class SchemaImport {
  public static void main(String[] args) {
    InputStream inputStream = PipelineOutput.getSchemaAsStream();
  }
}
```