package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.model.module.ModuleVersion;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;

public interface CityJSONExtensionModule {
    String getIdentifier();
    String getSchemaURI();
    URL getSchemaResource();
    Map<String, Class<? extends AbstractCityObjectType>> getCityObjects();
    Map<String, Class<? extends SemanticsType>> getSemanticSurfaces();
    Map<Class<? extends AbstractCityObjectType>, Map<String, Type>> getExtensionAttributes();

    default ModuleVersion getVersion() {
        return new ExtensionModuleVersion();
    }
}
