/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.ade.ADEContainer;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.MissingADESchemaException;
import org.w3c.dom.Element;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.stream.EventType;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import javax.xml.namespace.QName;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ADEBuilderHelper {

    public static <T extends ADEContainer> void addADEContainer(Class<T> type, List<T> containers, Function<Element, T> creator, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (reader.hasNext() && reader.nextTag() == EventType.START_ELEMENT) {
            QName name = reader.getName();
            ObjectBuilder<T> builder = reader.getXMLObjects().getBuilder(name, type);
            if (builder != null)
                buildContainer(builder, name, containers, reader);
            else if (reader.isCreateDOMAsFallback())
                containers.add(creator.apply(reader.getDOMElement()));
        }
    }

    public static <T extends ADEContainer> boolean addADEContainer(QName name, Class<T> type, List<T> containers, Function<Element, T> creator, XMLReader reader, QName... substitutionGroups) throws ObjectBuildException, XMLReadException {
        ObjectBuilder<T> builder = reader.getXMLObjects().getBuilder(name, type);
        if (builder != null) {
            buildContainer(builder, name, containers, reader);
            return true;
        } else if (reader.isCreateDOMAsFallback() && substitutes(name, reader, substitutionGroups)) {
            containers.add(creator.apply(reader.getDOMElement()));
            return true;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    private static <T extends ADEContainer> void buildContainer(ObjectBuilder<T> builder, QName name, List<T> containers, XMLReader reader) throws ObjectBuildException, XMLReadException {
        Map<Object, Object> containerInfo = (Map<Object, Object>) reader.getProperties().getOrSet("org.citygml4j.reuseADEContainers", Map.class, HashMap::new);

        Object entry = containerInfo.get(builder.getClass().getName());
        if (entry == null) {
            try {
                Method method = builder.getClass().getMethod("createObject", QName.class, Object.class);
                ReuseADEContainer reuseADEContainer = method.getAnnotation(ReuseADEContainer.class);
                entry = reuseADEContainer != null ? reuseADEContainer : Boolean.FALSE;
                containerInfo.put(builder.getClass().getName(), entry);
            } catch (NoSuchMethodException e) {
                throw new ObjectBuildException("Failed to find createObject method of builder " + builder.getClass().getName());
            }
        }

        if (entry instanceof ReuseADEContainer) {
            ReuseADEContainer reuseADEContainer = (ReuseADEContainer) entry;
            if (reuseADEContainer.value().length == 0
                    || Arrays.asList(reuseADEContainer.value()).contains(name.getNamespaceURI())) {
                Class<?> objectType = reader.getXMLObjects().getObjectType(name.getNamespaceURI(), builder);
                for (T container : containers) {
                    if (container.getClass() == objectType) {
                        reader.fillObjectUsingBuilder(container, builder);
                        return;
                    }
                }
            }
        }

        containers.add(reader.getObjectUsingBuilder(builder));
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
