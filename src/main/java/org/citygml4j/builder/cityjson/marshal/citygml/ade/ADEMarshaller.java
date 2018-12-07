package org.citygml4j.builder.cityjson.marshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionMarshaller;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;

import java.util.HashMap;
import java.util.Map;

public class ADEMarshaller {
    private Map<String, CityJSONExtensionMarshaller> marshallers;

    public ADEMarshaller(CityJSONMarshaller json) {
        CityGMLContext context = CityGMLContext.getInstance();
        if (context.hasCityJSONExtensionContexts()) {
            marshallers = new HashMap<>();
            ADEMarshallerHelper helper = new ADEMarshallerHelper(json);

            for (ADEContext adeContext : context.getADEContexts()) {
                if (adeContext instanceof CityJSONExtensionContext) {
                    CityJSONExtensionMarshaller marshaller = ((CityJSONExtensionContext) adeContext).getCityJSONExtension().createExtensionMarshaller();
                    if (marshaller != null) {
                        marshaller.setADEMarshallerHelper(helper);
                        for (String packageName : adeContext.getModelPackageNames())
                            marshallers.put(packageName, marshaller);
                    }
                }
            }
        }
    }

    public AbstractCityObjectType marshalCityObject(ADEModelObject src, CityJSON cityJSON) {
        if (marshallers != null) {
            CityJSONExtensionMarshaller marshaller = marshallers.get(src.getClass().getPackage().getName());
            if (marshaller != null)
                return marshaller.marshalCityObject(src, cityJSON);
        }

        return null;
    }

    public SemanticsType marshalSemanticSurface(ADEModelObject src) {
        if (marshallers != null) {
            CityJSONExtensionMarshaller marshaller = marshallers.get(src.getClass().getPackage().getName());
            if (marshaller != null)
                return marshaller.marshalSemanticSurface(src);
        }

        return null;
    }

    public ExtensionAttribute unmarshalExtensionAttribute(ADEModelObject src) {
        if (marshallers != null) {
            CityJSONExtensionMarshaller marshaller = marshallers.get(src.getClass().getPackage().getName());
            if (marshaller != null)
                return marshaller.unmarshalExtensionAttribute(src);
        }

        return null;
    }

}
