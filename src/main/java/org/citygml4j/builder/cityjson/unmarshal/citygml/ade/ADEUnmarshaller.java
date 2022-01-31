/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.builder.cityjson.unmarshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.extension.CityJSONExtension;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionModule;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionUnmarshaller;
import org.citygml4j.builder.cityjson.extension.CityObjectContext;
import org.citygml4j.builder.cityjson.extension.ExtensionPropertyContext;
import org.citygml4j.builder.cityjson.extension.SemanticSurfaceContext;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.extension.ExtensibleType;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.feature.CityObjectTypeAdapter;
import org.citygml4j.cityjson.feature.GenericCityObjectType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ADEUnmarshaller {
    private final CityJSONUnmarshaller json;
    private Map<String, CityJSONExtensionUnmarshaller> unmarshallersByType;
    private Map<Class<? extends ExtensibleType>, Map<String, CityJSONExtensionUnmarshaller>> unmarshallersByProperty;
    private Map<String, CityJSONExtensionUnmarshaller> unmarshallersByPackage;

    public ADEUnmarshaller(CityJSONUnmarshaller json) {
        this.json = json;
        CityGMLContext context = CityGMLContext.getInstance();

        if (context.hasCityJSONExtensionContexts()) {
            unmarshallersByType = new HashMap<>();
            unmarshallersByProperty = new HashMap<>();
            unmarshallersByPackage = new HashMap<>();
            ADEUnmarshallerHelper helper = new ADEUnmarshallerHelper(json);

            for (ADEContext adeContext : context.getADEContexts()) {
                if (adeContext instanceof CityJSONExtensionContext) {
                    CityJSONExtension extension = ((CityJSONExtensionContext) adeContext).getCityJSONExtension();
                    CityJSONExtensionUnmarshaller unmarshaller = extension.createExtensionUnmarshaller();
                    if (unmarshaller == null)
                        continue;

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

                        Map<Class<? extends ExtensibleType>, Map<String, Type>> properties = module.getExtensionProperties();
                        if (properties != null) {
                            for (Map.Entry<Class<? extends ExtensibleType>, Map<String, Type>> entry : properties.entrySet()) {
                                for (String name : entry.getValue().keySet()) {
                                    Map<String, CityJSONExtensionUnmarshaller> unmarshallers = unmarshallersByProperty
                                            .computeIfAbsent(entry.getKey(), v -> new ConcurrentHashMap<>());
                                    unmarshallers.put(name, unmarshaller);
                                }
                            }
                        }
                    }

                    for (String packageName : adeContext.getModelPackageNames())
                        unmarshallersByPackage.put(packageName, unmarshaller);
                }
            }
        }
    }

    public AbstractFeature unmarshalCityObject(AbstractCityObjectType src, CityJSON cityJSON, AbstractFeature parent) {
        if (unmarshallersByType != null) {
            CityJSONExtensionUnmarshaller unmarshaller = unmarshallersByType.get(src.getType());
            if (unmarshaller != null)
                return unmarshaller.unmarshalCityObject(src, new CityObjectContext(parent, cityJSON));
        }

        else if (src.hasLocalProperty(CityObjectTypeAdapter.UNKNOWN_EXTENSION) && src instanceof GenericCityObjectType) {
            // map unknown extension
            GenericCityObject dest = json.getCityGMLUnmarshaller().getGenericsUnmarshaller().unmarshalGenericCityObject((GenericCityObjectType) src, cityJSON);

            String type = src.getType();
            if (type.startsWith("+"))
                type = type.substring(1);

            dest.setClazz(new Code(type));

            dest.setLocalProperty(CityObjectTypeAdapter.UNKNOWN_EXTENSION, true);
            json.getCityGMLUnmarshaller().getCoreUnmarshaller().unmarshalAsGlobalFeature(dest);

            return dest;
        }

        return null;
    }

    public AbstractCityObject unmarshalSemanticSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent) {
        if (unmarshallersByType != null) {
            CityJSONExtensionUnmarshaller unmarshaller = unmarshallersByType.get(src.getType() + "\"surface\"");
            if (unmarshaller != null)
                return unmarshaller.unmarshalSemanticSurface(src, new SemanticSurfaceContext(surfaces, lod, parent));
        }

        return null;
    }

    public boolean assignSemanticSurface(AbstractCityObject semanticSurface, Number lod, AbstractCityObject parent) {
        if (unmarshallersByPackage != null) {
            CityJSONExtensionUnmarshaller unmarshaller = unmarshallersByPackage.get(parent.getClass().getPackage().getName());
            if (unmarshaller != null)
                return unmarshaller.assignSemanticSurface(semanticSurface, new SemanticSurfaceContext(lod, parent));
        }

        return false;
    }

    public void unmarshalExtensionProperty(String name, Object value, ExtensibleType src, CityJSON cityJSON, AbstractFeature parent) {
        if (unmarshallersByProperty != null) {
            for (Map.Entry<Class<? extends ExtensibleType>, Map<String, CityJSONExtensionUnmarshaller>> entry : unmarshallersByProperty.entrySet()) {
                if (entry.getKey().isAssignableFrom(src.getClass())) {
                    CityJSONExtensionUnmarshaller unmarshaller = entry.getValue().get(name);
                    if (unmarshaller != null)
                        unmarshaller.unmarshalExtensionProperty(name, new ExtensionPropertyContext(value, cityJSON, parent));
                }
            }
        }
    }

}
