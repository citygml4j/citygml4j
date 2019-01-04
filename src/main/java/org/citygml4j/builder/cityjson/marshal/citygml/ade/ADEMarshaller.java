package org.citygml4j.builder.cityjson.marshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionMarshaller;
import org.citygml4j.binding.cityjson.extension.ExtensionAttribute;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEGenericApplicationProperty;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.gml.feature.FeatureProperty;

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

    public void marshal(List<ADEComponent> src, AbstractCityObjectType parent, CityJSON cityJSON) {
        for (ADEComponent ade : src) {
            if (ade instanceof ADEGenericApplicationProperty<?> &&
                    ((ADEGenericApplicationProperty<?>) ade).getValue() instanceof FeatureProperty<?>) {
                FeatureProperty<?> property = (FeatureProperty<?>) ((ADEGenericApplicationProperty<?>) ade).getValue();
                AbstractCityObjectType cityObject = json.getGMLMarshaller().marshalFeatureProperty(property, cityJSON);
                if (cityObject != null) {
                    parent.addChild(cityObject);
                    cityJSON.addCityObject(cityObject);
                }
            }

            else if (ade instanceof ADEModelObject && marshallers != null) {
                CityJSONExtensionMarshaller marshaller = marshallers.get(ade.getClass().getPackage().getName());
                if (marshaller != null) {
                    ExtensionAttribute attribute = marshaller.marshalExtensionAttribute((ADEModelObject) ade);
                    if (attribute != null)
                        parent.getAttributes().addExtensionAttribute(attribute.getName(), attribute.getValue());
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
