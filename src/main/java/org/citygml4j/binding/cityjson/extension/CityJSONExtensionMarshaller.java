package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ADEMarshallerHelper;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ExtensionAttribute;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;

import java.util.List;

public interface CityJSONExtensionMarshaller {
    void setADEMarshallerHelper(ADEMarshallerHelper helper);
    List<AbstractCityObjectType> marshalCityObject(ADEModelObject src);
    SemanticsType marshalSemanticSurface(ADEModelObject src);
    ExtensionAttribute unmarshalExtensionAttribute(ADEModelObject src);
}
