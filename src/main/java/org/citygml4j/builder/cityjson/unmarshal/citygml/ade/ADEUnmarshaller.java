package org.citygml4j.builder.cityjson.unmarshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.extension.CityJSONExtension;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionModule;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionUnmarshaller;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ADEUnmarshaller {
    private Map<String, CityJSONExtensionUnmarshaller> unmarshallersByType;
    private Map<Class<? extends AbstractCityObjectType>, Map<String, CityJSONExtensionUnmarshaller>> unmarshallersByAttribute;

    public ADEUnmarshaller(CityJSONUnmarshaller json) {
        CityGMLContext context = CityGMLContext.getInstance();
        if (context.hasCityJSONExtensionContexts()) {
            unmarshallersByType = new HashMap<>();
            unmarshallersByAttribute = new HashMap<>();
            ADEUnmarshallerHelper helper = new ADEUnmarshallerHelper(json);

            for (ADEContext adeContext : context.getADEContexts()) {
                if (adeContext instanceof CityJSONExtensionContext) {
                    CityJSONExtension extension = ((CityJSONExtensionContext) adeContext).getCityJSONExtension();
                    CityJSONExtensionUnmarshaller unmarshaller = extension.getExtensionUnmarshaller();
                    unmarshaller.setADEUnmarshallerHelper(helper);

                    for (CityJSONExtensionModule module : extension.getExtensionModules()) {
                        Map<String, Class<? extends AbstractCityObjectType>> cityObjects = module.getCityObjects();
                        if (cityObjects != null) {
                            for (String type : cityObjects.keySet())
                                unmarshallersByType.put(type, unmarshaller);
                        }

                        Map<String, Class<? extends SemanticsType>> semanticSurfaces = module.getSemanticSurfaces();
                        if (semanticSurfaces != null) {
                            for (String type : semanticSurfaces.keySet())
                                unmarshallersByType.put(type + "\"surface\"", unmarshaller);
                        }

                        Map<Class<? extends AbstractCityObjectType>, Map<String, Type>> attributes = module.getExtensionAttributes();
                        if (attributes != null) {
                            for (Map.Entry<Class<? extends AbstractCityObjectType>, Map<String, Type>> entry : attributes.entrySet()) {
                                for (String name : entry.getValue().keySet()) {
                                    Map<String, CityJSONExtensionUnmarshaller> unmarshallers = unmarshallersByAttribute
                                            .computeIfAbsent(entry.getKey(), v -> new ConcurrentHashMap<>());
                                    unmarshallers.put(name, unmarshaller);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public AbstractFeature unmarshalCityObject(AbstractCityObjectType src, CityJSON cityJSON, AbstractFeature parent) {
        if (unmarshallersByType != null) {
            CityJSONExtensionUnmarshaller unmarshaller = unmarshallersByType.get(src.getType());
            if (unmarshaller != null)
                return unmarshaller.unmarshalCityObject(src, cityJSON, parent);
        }

        return null;
    }

    public AbstractCityObject unmarshalSemanticSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent) {
        if (unmarshallersByType != null) {
            CityJSONExtensionUnmarshaller unmarshaller = unmarshallersByType.get(src.getType() + "\"surface\"");
            if (unmarshaller != null)
                return unmarshaller.unmarshalSemanticSurface(src, surfaces, lod, parent);
        }

        return null;
    }

    public boolean assignSemanticSurface(AbstractCityObject semanticSurface, Number lod, ADEModelObject parent) {
        for (ADEContext adeContext : CityGMLContext.getInstance().getADEContexts()) {
            if (adeContext instanceof CityJSONExtensionContext
                    && adeContext.getModelPackageNames().contains(parent.getClass().getPackage().getName())) {
                CityJSONExtension extension = ((CityJSONExtensionContext) adeContext).getCityJSONExtension();
                return extension.getExtensionUnmarshaller().assignSemanticSurface(semanticSurface, lod, parent);
            }
        }

        return false;
    }

    public void unmarshalExtensionAttribute(String name, Object value, AbstractCityObjectType src, AbstractCityObject parent) {
        if (unmarshallersByAttribute != null) {
            for (Map.Entry<Class<? extends AbstractCityObjectType>, Map<String, CityJSONExtensionUnmarshaller>> entry : unmarshallersByAttribute.entrySet()) {
                if (entry.getKey().isAssignableFrom(src.getClass())) {
                    CityJSONExtensionUnmarshaller unmarshaller = entry.getValue().get(name);
                    if (unmarshaller != null)
                        unmarshaller.unmarshalExtensionAttribute(name, value, parent);
                }
            }
        }
    }

}
