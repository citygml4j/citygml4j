# Changelog

## [Unreleased]
### Fixed
- Fixed integer overflow leading to incorrect coordinates when using `"transform"` for CityJSON output files.
  ([citygml-tools #31](https://github.com/citygml4j/citygml-tools/issues/31))

## [3.0.0-rc.5] - 2022-09-09
### Changed
- Completely revised object model for processing CityGML data based on the
  [CityGML 3.0 Conceptual Model](https://docs.ogc.org/is/20-010/20-010.html).
- Readers and writers supporting the GML/XML encoding of CityGML 3.0 (draft), 2.0 and 1.0 with optional features such
  as a feature-by-feature streaming API, feature-based filtering, applying XSLT stylesheets, resolving of XLink
  references, XML validation, and more.
- Readers and writers for [CityJSON](https://www.cityjson.org/) with support for CityJSON 1.1 and 1.0. In addition,
  the new `"CityJSONFeature"` object introduced in CityJSON 1.1 is supported for efficiently streaming large CityJSON
  files based on JSON Lines.
- Simplified API to extend the core object model with additional classes to support CityGML ADEs and CityJSON
  Extensions. A full implementation of the official CityGML 3.0 TestADE is included as example.
- Added a new `ObjectWalker` that uses the visitor pattern to let you process every feature and geometry in your
  CityGML tree with just a few lines of code. The previous walker classes have been removed.
- A new `ReferenceResolver` to easily resolve XLink references and optionally keep track of referees.
- A new `CopyBuilder` that lets you create shallow and deep copies of citygml4j objects and also copy values between
  instances of different classes using a common superclass as copy template.
- `DeprecatedProperties` attributes of object classes give access to CityGML 2.0 and 1.0 content not covered by the
  CityGML 3.0 Conceptual Model. This way, no information is lost when parsing CityGML 2.0 and 1.0 datasets.
- Updated collection of sample programs that demonstrate the use of citygml4j 3.0.
- citygml4j is now a Java module and requires Java 11 or higher.
- The library is split into a `citygml4j-core` base module and optional serialization modules adding support
  for parsing and writing different file formats.
- Replaced JAXB with [xml-objects](https://github.com/xmlobjects), a simple, lightweight and flexible XML-to-object
  mapping framework.

## [Before 3.0.0]
The changelog of previous citygml4j releases before version 3.0 is available
[here](https://github.com/citygml4j/citygml4j/blob/citygml4j-v2/CHANGES.md).

[Unreleased]: https://github.com/citygml4j/citygml4j/compare/v3.0.0-rc.5..HEAD
[3.0.0-rc.5]: https://github.com/citygml4j/citygml4j/releases/tag/v3.0.0-rc.5
[Before 3.0.0]: https://github.com/citygml4j/citygml4j/blob/citygml4j-v2/CHANGES.md