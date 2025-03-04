# Changelog

## [Unreleased]

## [3.2.4] - 2025-03-04
### Fixed
- Fixed parsing of `TimePosition` values to support more ISO 8601 compliant representations.
- Fixed `include` method of `Envelope` to correctly handle empty envelopes.

## [3.2.3] - 2025-01-19
### Added
- Added `updateGeometryInfo` method to `ADEProperty`. This method can be overridden to avoid exposing your subclasses
  of `ADEProperty` to the `org.citygml4j.core` module for reflection.

### Fixed
- Fixed conversion of `GenericThematicSurface` to CityJSON depending on whether it is used as space boundary
  or as top-level feature.
- Computing envelopes is more robust against invalid input.

### Changed
- Updated gml-objects to 1.1.4.
- Updated xal-objects to 1.1.4.
- Updated xml-objects to 1.1.4.

## [3.2.2] - 2024-12-01
### Changed
- Updated jackson-databind to 2.18.2.
- Updated gml-objects to 1.1.2.
- Updated xal-objects to 1.1.2.
- Updated xml-objects to 1.1.2.

## [3.2.1] - 2024-07-15
### Changed
- CityGML `Section` and `Intersection` features are no longer converted to CityJSON due to missing support
  in CityJSON.

### Fixed
- `LandUse` features were not converted to CityJSON.
- Fixed mapping of closure surfaces to CityJSON.
- Fixed reading and writing of CityJSON storeys and building units.
- Fixed NPE when writing traffic spaces lacking a `granularity` attribute.
- Fixed writing of LoD4 multi-surfaces of `LandUse` features.
- Fixed `TimeseriesComponentProperty` to contain a `TimeseriesComponent`.

## [3.2.0] - 2024-01-29
### Changed
- **Breaking:** Java 17 is now the minimum required version for using citygml4j.
- Improved performance when resolving global references in CityJSON writers.

### Fixed
- Unknown XML content was mapped to DOM elements even if `createGenericADEContent` was set to false on the
  `CityGMLInputFactory`.
- When writing as CityJSON, surface data sharing identical properties was combined regardless of the appearance theme.

## [3.1.0] - 2023-11-03
### Added
- Added support for [CityJSON 2.0](https://www.cityjson.org/specs/2.0.0/). ([citygml-tools #50](https://github.com/citygml4j/citygml-tools/issues/50))
- Added mapping of CityGML 2.0 LoD0 point geometries to the `lod0Point` property of `AbstractSpace`.
- Added `getEncoding` method to `CityGMLReader`, which returns the input encoding if known or null if unknown.
- Added possibility to store local properties for `CityGMLChunk` objects.
- Added support for geometry templates when parsing and writing CityJSON files in JSON Lines format. The
  `"geometry-templates"` property must be placed in the `"CityJSON"` object in the first line.

### Fixed
- Fixed CityGML writer to output the `pointCloud` property of `AbstractPhysicalSpace` objects.
- Fixed the `computeEnvelope` method to also include interior nested features.
- Fixed reading of `"address"` properties for CityJSON bridges and building units.
- When parsing CityJSON, appearances of geometry templates were only mapped for the first `ImplicitGeometry` object.
  Subsequent `ImplicitGeometry` objects now correctly reference the appearances.

## [3.0.0] - 2023-04-04
### Added
- Added support for providing an XML factory when creating an instance of `CityGMLInputFactory`,
  `CityGMLSchemaHandler`, and `TransformerPipeline`.

### Changed
- **Breaking:** Removed the `@SingletonADEProperty` annotation. A singleton is now automatically created in case the
  `ObjectBuilder` for the ADE property uses the `@XMLElements` annotation with more than one target XML element.
- The `module-info.java` of the `citygml-xml` module now uses `requires transitive` for implied readability
  of the `citygml-core` module.
- Updated jackson-databind to 2.14.2.
- Updated gml-objects to 1.0.3.
- Updated xal-objects to 1.0.3.
- Updated xml-objects to 1.0.3.

### Fixed
- **Breaking:** Fixed the multiplicity of the `class` attribute of `ClearanceSpace`.
- Fixed integer overflow leading to incorrect coordinates when using `"transform"` for CityJSON output files.
  ([citygml-tools #31](https://github.com/citygml4j/citygml-tools/issues/31))
- Fixed mapping of CityGML 2.0 `ExternalReference` elements onto the internal data model.
- Avoid localization issues when internally converting strings to lower or upper case.
- Fixed class loader used in `ADERegistry` to load ADE loaders.
- Added type checks to `getDeprecatedProperties` methods to avoid class cast exceptions.

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

[Unreleased]: https://github.com/citygml4j/citygml4j/compare/v3.2.3..HEAD
[3.2.3]: https://github.com/citygml4j/citygml4j/releases/tag/v3.2.3
[3.2.2]: https://github.com/citygml4j/citygml4j/releases/tag/v3.2.2
[3.2.1]: https://github.com/citygml4j/citygml4j/releases/tag/v3.2.1
[3.2.0]: https://github.com/citygml4j/citygml4j/releases/tag/v3.2.0
[3.1.0]: https://github.com/citygml4j/citygml4j/releases/tag/v3.1.0
[3.0.0]: https://github.com/citygml4j/citygml4j/releases/tag/v3.0.0
[3.0.0-rc.5]: https://github.com/citygml4j/citygml4j/releases/tag/v3.0.0-rc.5
[Before 3.0.0]: https://github.com/citygml4j/citygml4j/blob/citygml4j-v2/CHANGES.md
