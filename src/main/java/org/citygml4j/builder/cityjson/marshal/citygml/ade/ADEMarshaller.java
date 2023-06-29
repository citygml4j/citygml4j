/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.builder.cityjson.marshal.citygml.ade;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.extension.ADEPropertyContext;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionMarshaller;
import org.citygml4j.builder.cityjson.extension.ExtensionAttribute;
import org.citygml4j.builder.cityjson.extension.ExtensionProperty;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.DuplicateGeometryRemover;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.extension.ExtensibleType;
import org.citygml4j.cityjson.extension.Extension;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.geometry.SemanticsType;
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
                        if (parent instanceof AbstractCityObjectType) {
                            if (json.isRemoveDuplicateChildGeometries()) {
                                DuplicateGeometryRemover remover = new DuplicateGeometryRemover((AbstractCityObjectType) parent);
                                remover.removeDuplicateGeometries(cityObject);
                                if (!cityObject.isSetGeometry())
                                    continue;
                            }

                            cityJSON.addCityObject(cityObject);
                        }

                        parent.addChild(cityObject);
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
