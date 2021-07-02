# Usage examples

The data model library provides access to different sequencer and bioinformatic pipeline output schemas
in JSON that have been defined in collaboration with the labs.

Overview:

* [Create experiment object](#create-experiment-object)
    * [Nanopore experiment output](#nanopore-experiment-output)
    * [Nf-Core dataset](#nf-core-dataset)
* [Validate data structure](#validate-data-structure)
* [Implementation examples](#implementation-examples)
    
## Create Experiment Object

### Nanopore experiment output

In order to create an instance of type `OxfordNanoporeExperiment`, you need to provide a map that provides content following the [Nanopore Instrument Output Schema JSON](../src/main/resources/schemas/nanopore-instrument-output.schema.json).  
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

The [data model API](../src/main/groovy/life/qbic/datamodel/datasets/OxfordNanoporeExperiment.groovy) outlines how to create an instance of `OxfordNanoporeExperiment`.


### Nf-Core dataset

In order to create an instance of type `NfCorePipelineResult`, you need to provide a map that provides content following the [Nfcore Pipeline Output Schema JSON](./src/main/resources/schemas/bioinformatics-analysis-result-set.schema.json).  

The [data model API](../src/main/groovy/life/qbic/datamodel/datasets/NfCorePipelineResult.groovy) outlines how to create an instance of `NfCorePipelineResult`.

## Validate data structure

Each object contains a schema within which can be used to test if a parsed file tree conforms to the expected structure.  
The validation itself is performed via the `SchemaLoader` class provided by the [Everit](https://github.com/everit-org/json-schema) package.

## Implementation examples 

The Nanopore experiment object is implemented in the [core utils API](https://github.com/qbicsoftware/core-utils-lib/blob/master/src/main/groovy/life/qbic/utils/NanoporeParser.groovy). 
Usage examples can also be seen in the associated [unit test](../src/test/groovy/life/qbic/datamodel/datasets/datastructure/OxfordNanoporeExperimentSpec.groovy).

The NfCore experiment object is implemented in the [core utils API](https://github.com/qbicsoftware/core-utils-lib/blob/master/src/main/groovy/life/qbic/utils/BioinformaticAnalysisParser.groovy). 
Usage examples can also be seen in the associated [unit test](../src/test/groovy/life/qbic/datamodel/datasets/datastructure/NfCorePipelineResultSpec.groovy).
