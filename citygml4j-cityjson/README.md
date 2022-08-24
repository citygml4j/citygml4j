# citygml4j-cityjson

The `citygml4j-cityjson` module adds [CityJSON](https://www.cityjson.org/) as encoding for the citygml4j model
classes.

## Supported CityJSON versions
`citygml4j-cityjson` supports parsing and writing `"CityJSON"` JSON objects as specified by CityJSON version 1.1 and
1.0. In addition, the `"CityJSONFeature"` object introduced in CityJSON 1.1 for efficiently streaming large CityJSON
files based on [JSON Lines](https://jsonlines.org/) is supported.

CityJSON only encodes a subset of the CityGML conceptual model, and also provides extra content not available
in CityGML. Since `citygml4j-cityjson` is based on the `citygml4j-core` module, which implements the
[CityGML 3.0 Conceptual Model](https://docs.ogc.org/is/20-010/20-010.html), unsupported or extra content is skipped
when parsing and writing CityJSON datasets. For most datasets and use cases, this is not an issue. For all other
cases, you can implement an extension for the core model classes of citygml4j to not lose information.

## Support for CityJSON Extensions
CityJSON Extensions are supported by the `citygml4j-cityjson` module. The recommended way is to implement explicit
model classes for a CityJSON Extension using the extension API of the `citygml4j-core` module and to provide
additional classes for serializing the model classes to and from JSON.

Alternatively, the `citygml4j-cityjson` module can map unknown CityJSON `"CityObjects"` and attributes onto generic
city objects and generic attributes.
