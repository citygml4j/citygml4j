package org.citygml4j.binding.cityjson.extension;

import java.util.List;

public interface CityJSONExtension {
    List<CityJSONExtensionModule> getExtensionModules();
    CityJSONExtensionUnmarshaller getExtensionUnmarshaller();
    CityJSONExtensionMarshaller getExtensionMarshaller();
}
