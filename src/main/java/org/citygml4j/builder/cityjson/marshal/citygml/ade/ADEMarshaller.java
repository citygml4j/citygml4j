package org.citygml4j.builder.cityjson.marshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.extension.ADEPropertyContext;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionMarshaller;
import org.citygml4j.binding.cityjson.extension.ExtensibleType;
import org.citygml4j.binding.cityjson.extension.Extension;
import org.citygml4j.binding.cityjson.extension.ExtensionAttribute;
import org.citygml4j.binding.cityjson.extension.ExtensionProperty;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ADEMarshaller {
    private final CityJSONMarshaller json;
    private Map<String, CityJSONExtensionMarshaller> marshallers;

    public ADEMarshaller(CityJSONMarshaller json) {
        this.json = json;

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

    public void marshal(List<ADEComponent> src, ExtensibleType parent, CityJSON cityJSON) {
        for (ADEComponent ade : src) {
            if (ade instanceof ADEModelObject && marshallers != null) {
                CityJSONExtensionMarshaller marshaller = marshallers.get(ade.getClass().getPackage().getName());
                if (marshaller != null) {
                    Extension extension = marshaller.marshalGenericApplicationProperty((ADEModelObject) ade, new ADEPropertyContext(parent, cityJSON));

                    if (extension instanceof AbstractCityObjectType) {
                        AbstractCityObjectType cityObject = (AbstractCityObjectType) extension;
                        parent.addChild(cityObject);
                        if (parent instanceof AbstractCityObjectType)
                            cityJSON.addCityObject(cityObject);
                    }

                    else if (extension instanceof ExtensionAttribute && parent instanceof AbstractCityObjectType) {
                        ExtensionAttribute attribute = (ExtensionAttribute) extension;
                        ((AbstractCityObjectType) parent).getAttributes().addExtensionAttribute(attribute.getName(), attribute.getValue());
                    }

                    else if (extension instanceof ExtensionProperty) {
                        ExtensionProperty property = (ExtensionProperty) extension;
                        if (parent instanceof AbstractCityObjectType)
                            ((AbstractCityObjectType) parent).addExtensionProperty(property.getName(), property.getValue());
                        else if (parent instanceof CityJSON)
                            ((CityJSON) parent).addExtensionProperty(property.getName(), property.getValue());
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

}
