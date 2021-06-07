==========
Changelog
==========

This project adheres to `Semantic Versioning <https://semver.org/>`_.


2.8.0-SNAPSHOT (2021-05-21)
---------------------------

**Added**

* Add new product unit types PER_RUN, PER_CYCLE, PER_GEL, PER_MG, PER_MEASUREMENT, PER_CHANNEL, PER_PEPTIDE_CHANNEL, PER_ML, PER_COMPARISON
to 'life.qbic.datamodel.dtos.business.services.ProductUnit' (`#215 <https://github.com/qbicsoftware/data-model-lib/pull/215>`_)

**Fixed**

**Dependencies**

**Deprecated**


2.7.0 (2021-05-21)
------------------

**Added**

* Make ``life.qbic.datamodel.dtos.business.ProductId`` comparable (`#211 <https://github.com/qbicsoftware/data-model-lib/pull/211>`_)

* Add file extensions to names in Json examples (`#204 <https://github.com/qbicsoftware/data-model-lib/pull/204>`_)

**Fixed**

* Remove @CompileStatic annotation from ProductId to enable builder pattern usage during compilation (`#186 <https://github.com/qbicsoftware/data-model-lib/issues/186>`_)

* Unspecified files will be ignored while creating the NfCorePipelineResult Object (`#212 <https://github.com/qbicsoftware/data-model-lib/pull/212>`_)

**Dependencies**

**Deprecated**


2.6.1 (2021-05-12)
------------------

**Added**

**Fixed**

* add missing leading slash to toString() method in ``life/qbic/datamodel/dtos/projectmanagement/ProjectIdentifier.groovy`` (`#207 <https://github.com/qbicsoftware/data-model-lib/pull/207>`_)

**Dependencies**

**Deprecated**


2.6.0 (2021-05-10)
------------------

**Added**

* Add json schema and wrapper for imaging data ``life.qbic.datamodel.datasets.imaging.ImageMetadata`` (`#199 <https://github.com/qbicsoftware/data-model-lib/pull/199>`_)

* Provide new classes that describe incoming nf-core bioinformatic pipeline data structures and contains it in a dedicated NfCorePipelineResult class (`#198 <https://github.com/qbicsoftware/data-model-lib/pull/198>`_)

**Fixed**

**Dependencies**

**Deprecated**


2.5.0 (2021-04-26)
------------------

**Added**

* New constructor using the new ``life.qbic.datamodel.dtos.business.ProductId`` constructor for ``life.qbic.datamodel.dtos.business.services.Sequencing``, ``life.qbic.datamodel.dtos.business.services.SecondaryAnalysis``,
  ``life.qbic.datamodel.dtos.business.services.ProteomicAnalysis``, ``life.qbic.datamodel.dtos.business.services.ProjectManagement``, ``life.qbic.datamodel.dtos.business.services.PrimaryAnalysis``,
  ``life.qbic.datamodel.dtos.business.services.MetabolomicAnalysis``, ``life.qbic.datamodel.dtos.business.services.DataStorage``

* Add Tests for ``life.qbic.datamodel.dtos.business.services.ProductUnitFactory#getForString(java.lang.String)`` (`#190 <https://github.com/qbicsoftware/data-model-lib/pull/190>`_)

* New EnumFactory ``life.qbic.datamodel.dtos.business.ProductCategoryFactory`` (`#192 <https://github.com/qbicsoftware/data-model-lib/pull/192>`_)

* New property experimentalDesign for ``life.qbic.datamodel.dtos.business.Offer``

* Introduce new Enum ``life.qbic.datamodel.dtos.business.AffiliationLabel`` and new EnumFactory ``life.qbic.datamodel.dtos.business.AffiliationLabelFactory`` (`#194 <https://github.com/qbicsoftware/data-model-lib/pull/194>`_)

**Fixed**

* Override ``equals()`` method for ``life.qbic.datamodel.dtos.business.OfferId`` and
  ``life.qbic.datamodel.dtos.business.TomatoId`` properly

* Override ``equals()`` method for ``life.qbic.datamodel.dtos.business.ProductId`` properly

**Dependencies**

**Deprecated**

* Constructor using the deprecated ``life.qbic.datamodel.dtos.business.ProductId`` constructor for ``life.qbic.datamodel.dtos.business.services.Sequencing``, ``life.qbic.datamodel.dtos.business.services.SecondaryAnalysis``,
  ``life.qbic.datamodel.dtos.business.services.ProteomicAnalysis``, ``life.qbic.datamodel.dtos.business.services.ProjectManagement``, ``life.qbic.datamodel.dtos.business.services.PrimaryAnalysis``,
  ``life.qbic.datamodel.dtos.business.services.MetabolomicAnalysis``, ``life.qbic.datamodel.dtos.business.services.DataStorage``
* Removed Deprecation for ``life.qbic.datamodel.people.*``


2.4.0 (2021-03-18)
------------------

**Added**

* Added ``life.qbic.datamodel.samples.Status.SAMPLE_RECEIVED``, ``life.qbic.datamodel.samples.Status.LIBRARY_PREP_FINISHED``, ``life.qbic.datamodel.samples.Status.DATA_AVAILABLE`` sample statuses (`#177 <https://github.com/qbicsoftware/data-model-lib/pull/177>`_)
* Added schema for sample entity codes (species/patient level) to ``life.qbic.datamodel.identifiers.SampleCodeFunctions`` (`#180 <https://github.com/qbicsoftware/data-model-lib/pull/180>`_)
* Added optional property ``associatedProject`` to ``life.qbic.datamodel.dtos.business.Offer`` (`#179 <https://github.com/qbicsoftware/data-model-lib/pull/179>`_)
* Added ``life.qbic.datamodel.dtos.business.ProductCategory.PROTEOMIC``, ``life.qbic.datamodel.dtos.business.ProductCategory.METABOLOMIC`` product categories (`#181 <https://github.com/qbicsoftware/data-model-lib/pull/181>`_)
* Added ``life.qbic.datamodel.dtos.business.services.ProductType.PROTEOMIC``, ``life.qbic.datamodel.dtos.business.services.ProductType.METABOLOMIC`` product types (`#181 <https://github.com/qbicsoftware/data-model-lib/pull/181>`_)
* Introduce ``life.qbic.datamodel.dtos.business.services.ProteomicAnalysis``, ``life.qbic.datamodel.dtos.business.services.MetabolomicAnalysis`` atomic products (`#181 <https://github.com/qbicsoftware/data-model-lib/pull/181>`_)

**Fixed**

* Equals method is now properly overridden for ``life.qbic.datamodel.dtos.business.ProductId`` (`#182 <https://github.com/qbicsoftware/data-model-lib/pull/182>`_)

* Correctly name and use respective sample code schemata for codes with check digits and entity codes (e.g. QABCDENTITY-2) (`#180 <https://github.com/qbicsoftware/data-model-lib/pull/180>`_)

**Dependencies**

**Deprecated**

* Deprecated ``life.qbic.datamodel.identifiers.SampleCodeFunctions#QBIC_SAMPLE_ID_SCHEMA``, please use ``life.qbic.datamodel.identifiers.SampleCodeFunctions#QBIC_SAMPLE_BARCODE_SCHEMA`` (`#180 <https://github.com/qbicsoftware/data-model-lib/pull/180>`_)
* Deprecated ``life.qbic.datamodel.samples.Status.DATA_AT_QBIC``, please use ``life.qbic.datamodel.samples.Status.DATA_AVAILABLE`` (`#180 <https://github.com/qbicsoftware/data-model-lib/pull/180>`_)

2.3.0 (2021-03-16)
------------------

**Added**

* overheadRatio property for ``life.qbic.datamodel.dtos.business.Offer``

* ``life.qbic.datamodel.dtos.projectmanagement.ProjectIdentifier``, ``life.qbic.datamodel.dtos.projectmanagement.ProjectCode``, ``life.qbic.datamodel.dtos.projectmanagement.ProjectSpace`` and ``life.qbic.datamodel.dtos.projectmanagement.Project`` to describe QBiC projects

* ``life.qbic.datamodel.dtos.business.ProjectApplication`` to describe a project application for registration at QBiC's data management platform

* Added uniqueId field to ``life.qbic.datamodel.dtos.business.ProductId`` (`#173 <https://github.com/qbicsoftware/data-model-lib/pull/173>`_)

* Add `Hour` ``life.qbic.datamodel.dtos.business.services.ProductUnit.PER_HOUR`` (`#175 <https://github.com/qbicsoftware/data-model-lib/pull/175>`_)

**Fixed**

**Dependencies**

**Deprecated**

* ``life.qbic.datamodel.dtos.business.ProductId#identifier`` is replaced by ``life.qbic.datamodel.dtos.business.ProductId#uniqueId`` (`#173 <https://github.com/qbicsoftware/data-model-lib/pull/173>`_)


2.2.0 (2021-03-02)
------------------

**Added**

* Checksum property for ``life.qbic.datamodel.dtos.business.Offer``

**Fixed**

**Dependencies**

**Deprecated**


2.1.0 (2021-02-24)
------------------

**Added**

* Introduce a schema resource for bioinformatic pipeline result sets validation via ``life.qbic.datamodel.pipelines.PipelineOutput`` (`#159 <https://github.com/qbicsoftware/data-model-lib/pull/159/>`_)
* Add field ``life.qbic.datamodel.dtos.business.Offer#projectObjective``, will replace ``life.qbic.datamodel.dtos.business.Offer#projectDescription`` (`#161 <https://github.com/qbicsoftware/data-model-lib/pull/161>`_)
* Add fields ``life.qbic.datamodel.dtos.business.Offer#itemsWithOverhead``, ``life.qbic.datamodel.dtos.business.Offer#itemsWithoutOverhead``,
  ``life.qbic.datamodel.dtos.business.Offer#itemsWithOverheadNetPrice`` and ``life.qbic.datamodel.dtos.business.Offer#itemsWithoutOverheadNetPrice`` to Offer DTO (`#160 <https://github.com/qbicsoftware/data-model-lib/pull/160/>`_)

**Fixed**

**Dependencies**

**Deprecated**

* ``life.qbic.datamodel.dtos.business.Offer#projectDescription``, replaced with ``life.qbic.datamodel.dtos.business.Offer#projectObjective``
* ``life.qbic.datamodel.dtos.general.Person#personType``, can be replaced by subclassing ``life.qbic.datamodel.dtos.general.Person``


2.0.0 (2021-02-15)
---------------------------

**Added**

* Introduce profiles to pom to differentiate between OSGI and non-OSGI packaging (`#122 <https://github.com/qbicsoftware/data-model-lib/pull/122>`_)
* Added a netPrice, taxes and overheads property to the offer DTO
* Add bnd.bnd file to enable OSGI bundling
* Add new possible sample statuses (`#149 <https://github.com/qbicsoftware/data-model-lib/pull/149>`_)
* Add price fields to ``life.qbic.datamodel.dtos.business.Offer`` (`#127 <https://github.com/qbicsoftware/data-model-lib/pull/127>`_)
* Add currency field to ``life.qbic.datamodel.dtos.business.services.Product`` (`#131 <https://github.com/qbicsoftware/data-model-lib/pull/131>`_)
* Add ``@EqualsAndHashCode`` to ``life.qbic.datamodel.dtos.business.services.*`` (`#129 <https://github.com/qbicsoftware/data-model-lib/pull/129>`_)
* Add a meaningful ``toString()`` method to ``life.qbic.datamodel.dtos.business.TomatoId`` (`#140 <https://github.com/qbicsoftware/data-model-lib/pull/140>`_)
* Add ``life.qbic.datamodel.dtos.business.AcademicTitle.PHD`` (`#144 <https://github.com/qbicsoftware/data-model-lib/pull/144>`_)
* Add ``life.qbic.datamodel.dtos.business.ProductId`` attribute to Product DTOs in ``life.qbic.datamodel.dtos.business.services`` (`#146 <https://github.com/qbicsoftware/data-model-lib/pull/146>`_)

**Fixed**

* ``life.qbic.datamodel.datasets.OxfordNanoporeMeasurement#extractLibraryKit(String)`` now throws
  ``MissingPropertyException`` instead of ``groovyjarjarcommonscli.MissingArgumentException``
* Change ``life.qbic.datamodel.dtos.business.services.ProductUnit.PER_GIGABYTE`` String representation to `Gigabyte` (`#125 <https://github.com/qbicsoftware/data-model-lib/pull/125>`_)
* Change ``life.qbic.datamodel.dtos.business.TomatoId`` and extending classes now provide the version as ``String`` (`#134 <https://github.com/qbicsoftware/data-model-lib/pull/134>`_)
* Add missing dependencies for report generation. Fix issue `#145 <https://github.com/qbicsoftware/data-model-lib/issues/145>`_ with PR `#147 <https://github.com/qbicsoftware/data-model-lib/pull/147>`_


**Dependencies**

* Add bnd-maven-plugin 5.1.2 to support OSGI packaging
* Add maven-jar-plugin 3.2.0 to support OSGI packaging
* Add ``org.osgi:osgi.core:jar:7.0.0``
* Remove ``parent-pom:3.1.3``
* Remove ``io.swagger.core.v3:swagger-annotations:jar:2.0.8``
* Upgrade  ``com.fasterxml.jackson.core:jackson-annotations:jar:2.9.9`` -> ``2.12.0``
* Upgrade ``info.picocli:picocli:jar:3.7.0`` -> ``4.0.1``
* Upgrade ``junit:junit:jar:4.12`` -> ``junit:junit:jar:4.13``
* Upgrade ``org.codehaus.groovy:groovy-all:pom:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-ant:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-cli-commons:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-cli-picocli:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-console:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-datetime:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-docgenerator:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-groovydoc:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-groovysh:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-jmx:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-json:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-jsr223:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-macro:jar:2.5.4`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-nio:jar:2.5.4`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-servlet:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-sql:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-swing:jar:2.5.7`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-templates:jar:2.5.4`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-test:jar:2.5.4`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy-xml:jar:2.5.4`` -> ``2.5.10``
* Upgrade ``org.codehaus.groovy:groovy:jar:2.5.4`` -> ``2.5.10``

**Deprecated**

* ``life.qbic.datamodel.dtos.business.TomatoId#getIdentifier`` is replaced by ``life.qbic.datamodel.dtos.business.TomatoId#toString``
* ``life.qbic.datamodel.dtos.general.Person#personType`` is deprecated. Please subclass this class instead of using this property.

**Removed**

* ``life.qbic.datamodel.workflows.*``


1.12.0 (2020-11-23)
-------------------

**Added**

* Add ``hashValue`` and ``equals`` to ``package life.qbic.datamodel.dtos`` classes
* Add ``EnumFactory``
* Add ``EnumFactory`` implementation for ``AffiliationCategory``, ``AcademicTitle``
* Support for QUBE template sync
* Introduce ``life/qbic/datamodel/dtos/general/Person.groovy`` DTO based on an abstract builder pattern
* Introduce ``life/qbic/datamodel/dtos/general/CommonPerson.groovy`` DTO as extension of Person DTO
* Introduce ``life/qbic/datamodel/dtos/business/Customer.groovy`` DTO as extension of Person DTO
* Introduce ``life/qbic/datamodel/dtos/business/ProjectManager.groovy`` DTO as extension of Person DTO
* Introduce ``life/qbic/datamodel/dtos/general/Address.groovy`` DTO
* Update ``life/qbic/datamodel/accounting/CostEstimate.groovy`` so it matches the properties of the Offer DTO
* ``life/qbic/datamodel/accounting/ProductItem.groovy`` no longer provides the ``computeTotalCost`` method
* Introduce ``life/qbic/datamodel/dtos/business/Offer.groovy`` DTO
* Update and introduce Builder Pattern to DTO classes for offer management
* Refactor ``life/qbic/datamodel/accounting/CostEstimate.groovy`` into Builder pattern
* Add diagram and description of DTO structure related to Offer management to README
* Add enum factory for product units
* Remove "Unknown" member from Affiliation Category Enum

**Fixed**

* Add default values to previous Address Implementation to avoid NullExceptions
* Increase gha-git-credentials version (`#108 <https://github.com/qbicsoftware/data-model-lib/pull/108/>`_)
* Customer ``hashCode()`` not working as expected (`#107 <https://github.com/qbicsoftware/data-model-lib/pull/107>`_)
* Refactor old accounting classes into DTOs (`#101 <https://github.com/qbicsoftware/data-model-lib/pull/101>`_)

**Dependencies**

**Deprecated**

* Deprecate ``life/qbic/datamodel/people/Person.groovy``
* Deprecate ``life/qbic/datamodel/people/Address.groovy``
* Deprecate "PersonType" property of ``life/qbic/datamodel/dtos/general/Person.groovy``
* Deprecate ``life/qbic/datamodel/accounting/Offer.groovy``


 
1.11.0 (2020-09-23)
-------------------

* Add DTOs for the offer management business process
* Reference parent pom 3.0.0

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.10.1 (2020-08-28)
-------------------

* Fix field accessibility for imaging metadata DTOs (`#51 <https://github.com/qbicsoftware/data-model-lib/issues/51>`_)

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.10.0 (2020-08-25)
-------------------

* Provide DTO classes for imaging metadata

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.9.4 (2021-02-12)
-------------------

* Fix implementation of ``containsAtLeastOneBarcodedFolder``, such that the method checks all child elements to contain at least one barcoded folder in order to flag the measurement as pooled measurement.

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.9.3 (2020-07-17)
-------------------

* Fix (`#31 <https://github.com/qbicsoftware/data-model-lib/issues/31>`_)

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.9.2 (2020-07-10)
-------------------

* Adds missing getter method for the measurement adapter

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.9.1 (2020-07-10)
-------------------

* Fix for ``getRawDataPerSample()``, which failed in the presence of unclassified folders.

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.9.0 (2020-07-08)
-------------------

* New class ``OxfordNanoporeInstrumentOutput`` that provides access to the instrument output JSON schema
* Support for unclassified reads

  * Two new folder classes ``UnclassifiedFast5Folder`` and ``UnclassifiedFastQFolder``

  * New API method ``getUnclassifiedData()`` for the ``OxfordNanoporeMeasurement`` class

* Bugfix for object comparison infinity crisis
* Bugfix for wrong data assignment on pooled sample data

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.8.3 (2020-05-26)
-------------------

* ``OxfordNanoporeMeasurement:getLogFiles`` now provides a list with all the log files

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.8.2 (0000-00-00)
-------------------

* Fix recursion error, when client code wants to access ``OxfordNanoporeMeasurement:getRelativePath``

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.8.1 (0000-00-00)
-------------------

* Provide JAR with all dependencies included for single deployment (i.e. ETL dropboxes, etc.)

**Added**

**Fixed**

**Dependencies**

**Deprecated**


1.8.0 (0000-00-00)
-------------------

* Provide new classes that describe incoming Oxford Nanopore instrument data structures
* Provide new classes that describe a Oxford Nanopore Experiment(``OxfordNanoporeExperiment.class``) and its containing Oxford Nanopre Measurements (OxfordNanoporeMeasurement.class)
* Provide a new method in the ``SampleCodeFunction.class`` ``public static List<String> findAllQbicSampleCodes(String text)`` that can be used to find all QBiC sample identifiers in a String object 

**Added**

**Fixed**

**Dependencies**

**Deprecated**
