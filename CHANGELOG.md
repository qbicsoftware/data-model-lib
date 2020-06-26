# Release Changelog for the data model library

## 1.8.3

* `OxfordNanoporeMeasurement:getLogFiles` now provides a list with all the log files

## 1.8.2

* Fix recursion error, when client code wants to access `OxfordNanoporeMeasurement:getRelativePath`

##  1.8.1

* Provide JAR with all dependencies included for single deployment (i.e. ETL dropboxes, etc.)

## 1.8.0

* Provide new classes that describe incoming Oxford Nanopore instrument data structures
* Provide new classes that describe a Oxford Nanopore Experiment(`OxfordNanoporeExperiment.class`) and its containing Oxford Nanopre Measurements (OxfordNanoporeMeasurement.class)
* Provide a new method in the `SampleCodeFunction.class` `public static List<String> findAllQbicSampleCodes(String text)` that can be used to find all QBiC sample identifiers in a String object 
