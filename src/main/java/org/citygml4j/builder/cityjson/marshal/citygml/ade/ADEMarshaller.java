package org.citygml4j.builder.cityjson.marshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.extension.CityJSONExtension;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.module.ade.ADEModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ADEMarshaller {
    private Map<String, CityJSONExtension> extensions;

    public ADEMarshaller(CityJSONMarshaller json) {
        CityGMLContext context = CityGMLContext.getInstance();
        if (context.hasCityJSONExtensionContexts()) {
            extensions = new HashMap<>();
            ADEMarshallerHelper helper = new ADEMarshallerHelper(json);

            for (ADEContext adeContext : context.getADEContexts()) {
                if (adeContext instanceof CityJSONExtensionContext) {
                    CityJSONExtension extension = ((CityJSONExtensionContext) adeContext).getCityJSONExtension();
                    extension.getExtensionMarshaller().setADEMarshallerHelper(helper);
                    for (ADEModule module : adeContext.getADEModules()) {
                        for (String packageName : adeContext.getModelPackageNames())
                            extensions.put(packageName, extension);
                    }
                }
            }
        }
    }

    public List<AbstractCityObjectType> marshalCityObject(ADEModelObject src) {
        if (extensions != null) {
            CityJSONExtension extension = extensions.get(src.getClass().getPackage().getName());
            if (extension != null)
                return extension.getExtensionMarshaller().marshalCityObject(src);
        }

        return null;
    }

    public SemanticsType marshalSemanticSurface(ADEModelObject src) {
        if (extensions != null) {
            CityJSONExtension extension = extensions.get(src.getClass().getPackage().getName());
            if (extension != null)
                return extension.getExtensionMarshaller().marshalSemanticSurface(src);
        }

        return null;
    }

    public ExtensionAttribute unmarshalExtensionAttribute(ADEModelObject src) {
        if (extensions != null) {
            CityJSONExtension extension = extensions.get(src.getClass().getPackage().getName());
            if (extension != null)
                return extension.getExtensionMarshaller().unmarshalExtensionAttribute(src);
        }

        return null;
    }

}
