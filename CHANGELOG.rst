==========
Changelog
==========

This project adheres to `Semantic Versioning <https://semver.org/>`_.


1.12.0 (2020-11-20)
-------------------

**Added**

* Add `hashValue` and `equals` to `package life.qbic.datamodel.dtos` classes
* Add `EnumFactory`
* Add `EnumFactory` implementation for `AffiliationCategory`, `AcademicTitle`
* Support for QUBE template sync
* Introduce life/qbic/datamodel/dtos/general/Person.groovy DTO based on an abstract builder pattern
* Introduce life/qbic/datamodel/dtos/general/CommonPerson.groovy DTO as extension of Person DTO
* Introduce life/qbic/datamodel/dtos/business/Customer.groovy DTO as extension of Person DTO
* Introduce life/qbic/datamodel/dtos/business/ProjectManager.groovy DTO as extension of Person DTO
* Introduce life/qbic/datamodel/dtos/general/Address.groovy DTO
* Update life/qbic/datamodel/accounting/CostEstimate.groovy so it matches the properties of the Offer DTO
* life/qbic/datamodel/accounting/ProductItem.groovy no longer provides the computeTotalCost method
* Deprecate life/qbic/datamodel/accounting/Offer.groovy
* Introduce life/qbic/datamodel/dtos/business/Offer.groovy DTO
* Deprecate "PersonType" property of life/qbic/datamodel/dtos/general/Person.groovy
* Deprecate life/qbic/datamodel/people/Person.groovy
* Deprecate life/qbic/datamodel/people/Address.groovy
* Refactor life/qbic/datamodel/accounting/CostEstimate.groovy into Builder pattern
* Add diagram and description of DTO structure related to Offer management to README
* Add enum factory for product units
* Remove "Unknown" member from Affiliation Category Enum
**Fixed**
* Add default values to previous Address Implementation to avoid NullExceptions

**Dependencies**

**Deprecated**
