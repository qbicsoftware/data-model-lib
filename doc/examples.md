# Usage examples

The data model library provides access to different sequencer and bioinformatic pipeline output schemas
in JSON that have been defined in collaboration with the labs.

Overview:

- [Oxford Nanopore output](#oxford-nanopore-output)

    * [Create Nanopore experiment object](#create-nanopore-experiment-object)
    * [Validate Nanopore data structure](#validate-nanopore-data-structure)
    * [Nanopore experiment object implementation example](#nanopore-experiment-object-implementation-example)
    
- [Nf Core pipeline output](#data-models)

    * [Create NfCore experiment object](#create-nfcore-experiment-object)
    * [Validate NF-Core data structure](#validate-nf-core-data-structure)
    * [NfCore experiment object implementation example](#nf-core-experiment-object-implementation-example)

## Oxford Nanopore output

### Create Nanopore Experiment object

In order to create an instance of type `OxfordNanoporeExperiment`, you need to provide a map that provides content following the [Nanopore Instrument Output Schema JSON](./src/main/resources/schemas/nanopore-instrument-output.schema.json).  
Every measurement folder also needs to be enriched with metadata, which itself is specified with another [JSON schema](../src/main/resources/schemas/ont-metadata.schema.json).

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

You can than use the [data model API](../src/main/groovy/life/qbic/datamodel/datasets/OxfordNanoporeExperiment.groovy) to create an `OxfordNanoporeExperiment` with this static factory method:

```groovy
import life.qbic.datamodel.datasets.OxfordNanoporeExperiment

// Replace with a real map that follows the schema
def outputMap = [:]

def onExperiment = OxfordNanoporeExperiment.create(outputMap)
```

### Validate Nanopore data structure

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

To validate the Nanopore instrument output, the schema can be loaded by the [Everit](https://github.com/everit-org/json-schema)
`SchemaLoader` class:

```java
InputStream schemaStream = OxfordNanoporeInstrumentOutput.getSchemaAsStream()
JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream))
Schema jsonSchema = SchemaLoader.load(rawSchema)
```

### Nanopore experiment object implementation example

The Nanopore experiment object is currently implemented in the [core utils API](../src/main/groovy/life/qbic/datamodel/datasets/datastructure/OxfordNanoporeExperimentSpec.groovy). 
Usage examples can also be seen in the associated [unit test](../src/test/groovy/life/qbic/datamodel/datasets/datastructure/OxfordNanoporeExperimentSpec.groovy)

## Nf Core pipeline output

### Create NfCore experiment object

In order to create an instance of type `NfCorePipelineResult`, you need to provide a map that provides content following the [Nfcore Pipeline Output Schema JSON](./src/main/resources/schemas/bioinformatics-analysis-result-set.schema.json).  

You can than use the [data model API](../src/main/groovy/life/qbic/datamodel/datasets/NfCorePipelineResult.groovy) to create an `NfCorePipelineResult` with this static factory method:

```groovy
import life.qbic.datamodel.datasets.NfCorePipelineResult

// Replace with a real map that follows the schema
Map outputMap = [:]

def nfCorePipelineOutput = NfCorePipelineResult.create(outputMap)
```

### Validate NF-Core data structure 

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

To validate the nf core pipeline output, the schema can be loaded via its classpath by the [Everit](https://github.com/everit-org/json-schema)
`SchemaLoader` class:

```java
InputStream stream = PipelineOutput.getSchemaAsStream()
SchemaLoader schemaLoader = SchemaLoader.builder()
                .schemaClient(SchemaClient.classPathAwareClient())
                .schemaJson(new JSONObject(new JSONTokener(stream)))
                .resolutionScope("classpath://schemas/")
                .build()
```

### NF-Core experiment object implementation example

The NfCore experiment object is currently implemented in the [core utils API](https://github.com/qbicsoftware/core-utils-lib/blob/master/src/main/groovy/life/qbic/utils/BioinformaticAnalysisParser.groovy). 
Usage examples can also be seen in the associated [unit test](../src/test/groovy/life/qbic/datamodel/datasets/datastructure/NfCorePipelineResultSpec.groovy)

