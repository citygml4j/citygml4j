Change Log
==========

### 2.8.0 - 2018-10-28

##### Breaking changes
* Removed method `getADEModule()` from the `ADEModelObject` interface
  * This method caused every `ADEModelObject` to be associated with one `ADEModule` and consequently with only one CityGML version. 
  *  With this change, an `ADEModelObject` can now be used for both CityGML 2.0 and 1.0.

##### Additions
* Added `java.io.Serializable` interface to model classes. This allows for serializing and deserializing the state of citygml4j object trees without the need for writing and reading XML datasets. See the sample program `serializing_model_classes/Serialization.java` for an example. #18

##### Fixes
* Fixed NPE in CityJSON appearance resolver
* Fixed LoD bug in CityJSON BuildingUnmarshaller