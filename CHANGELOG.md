# Release Changelog for the data model library

## 1.9.4

* Fix implementation of `containsAtLeastOneBarcodedFolder`, such that the method checks all child elements to contain at least one barcoded folder in order to flag the measurement as pooled measurement.

## 1.9.3

* Fix #31

## 1.9.2

* Adds missing getter method for the measurement adapter

## 1.9.1

* Fix for `getRawDataPerSample()`, which failed in the presence of unclassified folders.

## 1.9.0

* New class `OxfordNanoporeInstrumentOutput` that provides access to the instrument output JSON schema
* Support for unclassified reads
  * Two new folder classes `UnclassifiedFast5Folder` and `UnclassifiedFastQFolder`
  * New API method `getUnclassifiedData()` for the `OxfordNanoporeMeasurement` class
* Bugfix for object comparison infinity crisis
* Bugfix for wrong data assignment on pooled sample data

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
