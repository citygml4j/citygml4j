package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ADEMarshallerHelper;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ExtensionAttribute;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;

public interface CityJSONExtensionMarshaller {
    void setADEMarshallerHelper(ADEMarshallerHelper helper);
    AbstractCityObjectType marshalCityObject(ADEModelObject src, CityJSON cityJSON);
    SemanticsType marshalSemanticSurface(ADEModelObject src);
    ExtensionAttribute unmarshalExtensionAttribute(ADEModelObject src);
}
