# citygml4j-xml

The `citygml4j-xml` module adds support for parsing and writing CityGML datasets encoded in GML/XML. The GML encoding
is considered the default encoding for CityGML datasets.

## Supported CityGML versions
`citygml4j-xml` supports the GML encodings of CityGML version [3.0](https://github.com/opengeospatial/CityGML-3.0Encodings),
[2.0](https://portal.ogc.org/files/?artifact_id=47842), and [1.0](https://portal.ogc.org/files/?artifact_id=28802).
You can easily parse a dataset in one of these versions and write it back using another version.

The Java classes of the `citygml4j-core` module implement the [CityGML 3.0 Conceptual Model](https://docs.ogc.org/is/20-010/20-010.html),
which is not fully backwards-compatible with CityGML 2.0 and 1.0. To not lose information when parsing CityGML 2.0
and 1.0 datasets, the model classes provide `DeprecatedProperties` objects that give access to CityGML 2.0
and 1.0 content not covered by the CityGML 3.0 Conceptual Model. This way, all CityGML versions are supported without
information loss. Check out the `citygml4j-samples` module for examples how to use `DeprecatedProperties`.

## Support for CityGML ADEs
CityGML ADEs encoded in GML/XML are supported by the `citygml4j-xml` module in two ways. Firstly, the citygml4j default
way is to implement explicit model classes for the ADE using the extension API of the `citygml4j-core` module and to
provide additional classes for serializing the model classes to and from GML/XML. A benefit of this approach is that
the ADE model classes seamlessly integrate with the core model classes and can be fed to your existing business code.

Alternatively, the `citygml4j-xml` module can parse unknown ADE XML content into generic `DOM` elements. This way,
an ADE extension is not required, but you have to write code to handle the `DOM` elements. The `SchemaHandler`
helper class provides programmatic access to the CityGML and ADE XML schemas and is meant to support you in parsing
and understanding the `DOM` elements, for instance, whether they represent a feature or a geometry.

The `citygml4j-samples` module contains examples for both ways to support ADEs, and you can use them in parallel
in your application code.