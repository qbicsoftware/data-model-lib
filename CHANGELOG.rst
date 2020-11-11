==========
Changelog
==========

This project adheres to `Semantic Versioning <https://semver.org/>`_.


1.12.0-SNAPSHOT (2020-10-07)
----------------------------

**Added**

* Add `hashValue` and `equals` to `package life.qbic.datamodel.dtos` classes
* Add `EnumFactory`
* Add `EnumFactory` implementation for `AffiliationCategory`, `AcademicTitle`
* Support for QUBE template sync
* Introduce abstract Builder pattern for a new Person DTO
* Introduce CommonPerson, Customer and ProjectManager DTOs as extension of Person DTO
* Introduce new Address DTO
* Update CostEstimate so it matches the properties of the Offer DTO
* ProductItem no longer provides the computeTotalCost method
* Deprecate Offer and introduce new Offer DTO
* Deprecate PersonType property of new Person DTO
* Deprecate old Person implementation
* Deprecate old Address implementation
* Move CostEstimate Class to Builder Pattern so it matches the Offer Class and add description to OfferClass Test

**Fixed**
* Add default values to previous Address Implementation to avoid NullExceptions

**Dependencies**

**Deprecated**
