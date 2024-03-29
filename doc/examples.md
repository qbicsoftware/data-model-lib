# How to use

The data model library provides access to different sequencer and bioinformatic pipeline output schemas
in JSON that have been defined in collaboration with the labs.

Overview:

* [Create object](#create-object)
    * [Nanopore experiment output](#nanopore-experiment-output)
    * [Nf-Core dataset](#nf-core-dataset)
    * [MaxQuant dataset](#maxquant-dataset)
* [Validate data structure](#validate-data-structure)
* [Usage examples](#usage-examples)
    
## Create object

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

The [data model API](https://qbicsoftware.github.io/data-model-lib/reports/2.10.0/gapidocs/life/qbic/datamodel/datasets/OxfordNanoporeExperiment.html) outlines how to create an instance of `OxfordNanoporeExperiment`.


### Nf-Core dataset

In order to create an instance of type `NfCorePipelineResult`, you need to provide a map that provides content following the [Nfcore Pipeline Output Schema JSON](../src/main/resources/schemas/bioinformatics-analysis-result-set.schema.json).  

The [data model API](https://qbicsoftware.github.io/data-model-lib/reports/2.10.0/gapidocs/life/qbic/datamodel/datasets/NfCorePipelineResult.html) outlines how to create an instance of `NfCorePipelineResult`.

### MaxQuant dataset

In order to create an instance of type `MaxQuantRunResult`, you need to provide a map that provides content following the [MaxQuant Schema JSON](../src/main/resources/schemas/maxquant-result-set.schema.json).  

The [data model API](https://qbicsoftware.github.io/data-model-lib/reports/2.10.0/gapidocs/life/qbic/datamodel/datasets/MaxQuantRunResult.html) outlines how to create an instance of `MaxQuantRunResult`.


## Validate data structure

Each object contains a schema within which can be used to test if a parsed file tree conforms to the expected structure.  
The validation itself is performed via the `SchemaLoader` class provided by the [Everit](https://github.com/everit-org/json-schema) package.

## Usage examples 

`OxfordNanoporeExperiment` is used in the [core utils API](https://qbicsoftware.github.io/core-utils-lib/reports/1.8.0/gapidocs/life/qbic/utils/NanoporeParser.html). 
Usage examples can also be seen in the associated [unit test](../src/test/groovy/life/qbic/datamodel/datasets/datastructure/OxfordNanoporeExperimentSpec.groovy).

`NfCorePipelineResult` is used in the [core utils API](https://qbicsoftware.github.io/core-utils-lib/reports/1.8.0/gapidocs/life/qbic/utils/BioinformaticAnalysisParser.html). 
Usage examples can also be seen in the associated [unit test](../src/test/groovy/life/qbic/datamodel/datasets/datastructure/NfCorePipelineResultSpec.groovy).

`MaxQuantRunResult` is used in the [core utils API](https://qbicsoftware.github.io/core-utils-lib/reports/1.9.0/gapidocs/life/qbic/utils/MaxQuantParser.html). 
Usage examples can also be seen in the associated [unit test](../src/test/groovy/life/qbic/datamodel/datasets/datastructure/MaxQuantRunResultSpec.groovy).