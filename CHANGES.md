Change Log
==========

### 2.9.0 - tbd

##### Breaking changes
* Changed `ADEContext` API
  * `getJAXBPackageNames()` has been moved to `ADEModule` to be able to associate JAXB classes with CityGML versions
  * `getADEMarshaller()` and `getADEUnmarshaller()` have been renamed to `createADEMarshaller()` and `createADEUnmarshaller()`
* Added `Module` information to `AbstractFeature` which is set automatically during unmarshalling
  * This allows for easily querying the CityGML version of every feature (both CityGML and ADE) in a dataset
  * Breaking: `getCityGMLModule()` has been removed from `CityGMLModuleComponent` for this reason

##### Additions
* Added support for CityJSON v0.9
  * This required reworking the Gson binding classes for CityJSON in `org.citygml4j.binding.cityjson` and a lof of changes
   to the CityJSON marshalling and unmarshalling process in `org.citygml4j.builder.cityjson`
  * Previous versions of CityJSON are no longer supported
* Added support for CityJSON extensions
  * An `ADEContext` can now additionally implement the `CityJSONExtension` interface to facilitate a full mapping 
  between CityGML ADE content and CityJSON extensions
  * The [NoiseADE citygml4j module](https://github.com/citygml4j/noise-ade-citygml4j) v2.4 is a first implementation
  of the `CityJSONExtension` interface  
  * Unknown CityJSON extensions can be mapped to CityGML generic city objects and attributes if no `CityJSONExtension`
  is available
  * Added examples in `cityjson/handling_extensions` to demonstrate the new capabilities
* Added support for LoD0 curves for CityJSON transportation objects
* Improved mapping of CityJSON attributes to and from generic attributes

##### Fixes
* Remove temporary information from citygml4j objects after CityJSON marshalling
* Fixed unmarshalling ADE properties of `AbstractTextureParameterization`
* Fixed CityJSON `"date-time"` adapter
* Avoid invalid `gml:id` prefixes in `DefaultGMLIdManager`
* Fixed Gson exception when writing empty JSON documents

##### Miscellaneous
* Switched to JAXB 2.3.2
* Removed `SMIL` from generated JAXB sources (never saw a GML dataset using it...)
* Replaced `com.sun.xsom:xsom` library with `org.glassfish.jaxb:xsom`

### 2.8.1 - 2018-11-13

##### Miscellaneous
* Switched to JAXB 2.3.1 to avoid the following warning when running on Java 11: `WARNING: Illegal reflective access by com.sun.xml.bind.v2.runtime.reflect.opt.Injector`

##### Fixes
* Fixed missing namespace declarations in `SAXWriter`

### 2.8.0 - 2018-10-28

##### Breaking changes
* Removed method `getADEModule()` from the `ADEModelObject` interface
  * This method caused every `ADEModelObject` to be associated with one `ADEModule` and consequently with only one CityGML version. 
  *  With this change, an `ADEModelObject` can now be used for both CityGML 2.0 and 1.0.

##### Additions
* Added `java.io.Serializable` interface to model classes. This allows for serializing and deserializing the state of citygml4j object trees without the need for writing and reading XML datasets. [#18](https://github.com/citygml4j/citygml4j/issues/18)
  * See the sample program `serializing_model_classes/Serialization.java` for an example.

##### Fixes
* Fixed NPE in CityJSON appearance resolver
* Fixed LoD bug in CityJSON BuildingUnmarshaller
