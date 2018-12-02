package org.citygml4j.builder.cityjson.marshal.citygml.ade;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;

import java.util.List;

public class ADEMarshaller {

    public ADEMarshaller(CityJSONMarshaller json) {
        ADEMarshallerHelper helper = new ADEMarshallerHelper(json);
    }

    public List<AbstractCityObjectType> marshalCityObject(ADEModelObject src) {
        System.out.println("marshalling ADE city object type " + src);
        return null;
    }

    public SemanticsType marshalSemanticSurface(ADEModelObject src) {
        System.out.println("marshalling ADE semantic surface type " + src);
        return null;
    }

    public ExtensionAttribute unmarshalExtensionAttribute(ADEModelObject src) {
        System.out.println("marshalling ADE property " + src);
        return null;
    }

}
