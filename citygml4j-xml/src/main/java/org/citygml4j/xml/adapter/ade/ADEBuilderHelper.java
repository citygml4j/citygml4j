/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.ade;

import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchemaSet;
import org.citygml4j.core.model.ade.ADEProperty;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.MissingADESchemaException;
import org.w3c.dom.Element;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.stream.EventType;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ADEBuilderHelper {

    public static void addADEProperty(AbstractFeature feature, Function<Element, ADEProperty> creator, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (reader.hasNext() && reader.nextTag() == EventType.START_ELEMENT) {
            QName name = reader.getName();
            ObjectBuilder<ADEProperty> builder = reader.getXMLObjects().getBuilder(name, ADEProperty.class);
            if (builder != null) {
                buildADEProperty(feature, name, builder, reader);
            } else if (reader.isCreateDOMAsFallback()) {
                feature.addADEProperty(creator.apply(reader.getDOMElement()));
            }
        }
    }

    public static boolean addADEProperty(AbstractFeature feature, QName name, Function<Element, ADEProperty> creator, XMLReader reader, QName... substitutionGroups) throws ObjectBuildException, XMLReadException {
        ObjectBuilder<ADEProperty> builder = reader.getXMLObjects().getBuilder(name, ADEProperty.class);
        if (builder != null) {
            buildADEProperty(feature, name, builder, reader);
            return true;
        } else if (reader.isCreateDOMAsFallback() && substitutes(name, reader, substitutionGroups)) {
            feature.addADEProperty(creator.apply(reader.getDOMElement()));
            return true;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    private static void buildADEProperty(AbstractFeature feature, QName name, ObjectBuilder<ADEProperty> builder, XMLReader reader) throws ObjectBuildException, XMLReadException {
        Map<Object, Boolean> singletons = (Map<Object, Boolean>) reader.getProperties()
                .getOrSet("org.citygml4j.singletonADEs", Map.class, HashMap::new);

        Boolean isSingleton = singletons.get(builder.getClass().getName());
        if (isSingleton == null) {
            XMLElements elements = builder.getClass().getAnnotation(XMLElements.class);
            isSingleton = elements != null && elements.value().length > 0;
            singletons.put(builder.getClass().getName(), isSingleton);
        }

        if (isSingleton) {
            Class<ADEProperty> objectType = (Class<ADEProperty>) reader.getXMLObjects().getObjectType(name.getNamespaceURI(), builder);
            for (ADEProperty property : feature.getADEProperties(objectType)) {
                if (property.getClass() == objectType) {
                    reader.fillObjectUsingBuilder(property, builder);
                    return;
                }
            }
        }

        feature.addADEProperty(reader.getObjectUsingBuilder(builder));
    }

    private static boolean substitutes(QName name, XMLReader reader, QName... substitutionGroups) throws XMLReadException {
        if (reader.getSchemaHandler() != null) {
            try {
                SchemaHandler schemaHandler = reader.getSchemaHandler();
                schemaHandler.resolveAndParseSchema(name.getNamespaceURI());

                XSSchemaSet schemas = schemaHandler.getSchemaSet(name.getNamespaceURI());
                XSElementDecl element = schemas.getElementDecl(name.getNamespaceURI(), name.getLocalPart());
                if (element != null) {
                    XSElementDecl head = null;
                    while ((element = element.getSubstAffiliation()) != null)
                        head = element;

                    if (head != null) {
                        for (QName substitutionGroup : substitutionGroups) {
                            if (substitutionGroup.getNamespaceURI().equals(head.getTargetNamespace())
                                    && substitutionGroup.getLocalPart().equals(head.getName()))
                                return true;
                        }
                    }
                }
            } catch (SchemaHandlerException e) {
                if (reader.getProperties().getAndCompare(CityGMLInputFactory.FAIL_ON_MISSING_ADE_SCHEMA, true))
                    throw new MissingADESchemaException("Failed to load ADE schema document for target namespace '" + name.getNamespaceURI() + "'.", e);
            }
        }

        return false;
    }
}
