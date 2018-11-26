package org.citygml4j.builder.cityjson.unmarshal.citygml.ade;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;

import java.util.List;

public class ADEUnmarshaller {

    public ADEUnmarshaller(CityJSONUnmarshaller json) {
        ADEUnmarshallerHelper helper = new ADEUnmarshallerHelper(json);
    }

    public AbstractFeature unmarshalCityObject(AbstractCityObjectType src, CityJSON cityJSON, AbstractFeature parent) {
        System.out.println("unmarshalling extension type " + src);
        return null;
    }

    public AbstractCityObject unmarshalSemanticSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent) {
        System.out.println("unmarshalling semantic surface " + src);
        return null;
    }

    public void unmarshalExtensionAttribute(String name, Object value, AbstractCityObject dest) {
        System.out.println("unmarshalling extension attribute " + name + " for " + dest);
    }

}
