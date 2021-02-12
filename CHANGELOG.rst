==========
Changelog
==========

This project adheres to `Semantic Versioning <https://semver.org/>`_.


2.0.0-SNAPSHOT (2021-02-12)
---------------------------

**Added**

* Introduce profiles to pom to differentiate between OSGI and non-OSGI packaging (`#122 <https://github.com/qbicsoftware/data-model-lib/pull/122>`_)
* Added a netPrice, taxes and overheads property to the offer DTO
* Add bnd.bnd file to enable OSGI bundling
* Add new possible sample statuses (#149)

**Fixed**

* ``life.qbic.datamodel.datasets.OxfordNanoporeMeasurement#extractLibraryKit(String)`` now throws
  ``MissingPropertyException`` instead of ``groovyjarjarcommonscli.MissingArgumentException``
* Change ``life.qbic.datamodel.dtos.business.services.ProductUnit.PER_GIGABYTE`` String representation to `Gigabyte` (`#125 <https://github.com/qbicsoftware/data-model-lib/pull/125>`_)




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


1.12.0 (2020-11-20)
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
