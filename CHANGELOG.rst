==========
Changelog
==========

This project adheres to `Semantic Versioning <https://semver.org/>`_.


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


