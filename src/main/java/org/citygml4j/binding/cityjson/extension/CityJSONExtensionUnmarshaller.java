package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.citygml.ade.ADEUnmarshallerHelper;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.feature.AbstractFeature;

public interface CityJSONExtensionUnmarshaller {
    void setADEUnmarshallerHelper(ADEUnmarshallerHelper helper);
    AbstractFeature unmarshalCityObject(AbstractCityObjectType src, CityObjectContext context);
    AbstractCityObject unmarshalSemanticSurface(SemanticsType src, SemanticSurfaceContext context);
    boolean assignSemanticSurface(AbstractCityObject semanticSurface, SemanticSurfaceContext context);
    void unmarshalExtensionProperty(String name, ExtensionPropertyContext context);
}
