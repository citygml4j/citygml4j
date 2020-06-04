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
import org.xmlobjects.stream.BuildResult;
import org.xmlobjects.stream.EventType;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.function.Function;

public class ADEBuilderHelper {

    public static <T extends ADEContainer> void addADEContainer(Class<T> type, List<? super T> containers, Function<Element, T> creator, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (reader.hasNext() && reader.nextTag() == EventType.START_ELEMENT) {
            BuildResult<T> result = reader.getObjectOrDOMElement(type);
            if (result.isSetObject())
                containers.add(result.getObject());
            else if (result.isSetDOMElement())
                containers.add(creator.apply(result.getDOMElement()));
        }
    }

    public static <T extends ADEContainer> boolean addADEContainer(QName name, Class<T> type, List<? super T> properties, Function<Element, T> creator, XMLReader reader, QName... substitutionGroups) throws ObjectBuildException, XMLReadException {
        ObjectBuilder<T> builder = reader.getXMLObjects().getBuilder(name, type);
        if (builder != null) {
            properties.add(reader.getObjectUsingBuilder(builder));
            return true;
        } else if (ADEBuilderHelper.substitutes(name, reader, substitutionGroups)) {
            properties.add(creator.apply(reader.getDOMElement()));
            return true;
        }

        return false;
    }

    private static boolean substitutes(QName name, XMLReader reader, QName... substitutionGroups) throws XMLReadException {
        if (reader.isCreateDOMAsFallback() && reader.getSchemaHandler() != null) {
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
