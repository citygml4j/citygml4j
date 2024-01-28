/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.core.model.appearance.AbstractTextureParameterization;
import org.citygml4j.core.model.deprecated.DeprecatedProperties;
import org.citygml4j.core.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractTextureParameterizationAdapter<T extends AbstractTextureParameterization> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(name.getNamespaceURI())) {
            attributes.getValue(GMLConstants.GML_3_1_NAMESPACE, "id").ifPresent(v -> object.getLocalProperties().set(DeprecatedProperties.GML_ID, v));
            attributes.getValue(GMLConstants.GML_3_2_NAMESPACE, "id").ifPresent(v -> object.getLocalProperties().set(DeprecatedProperties.GML_ID, v));
        }
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.hasLocalProperties() && !namespaces.contains(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE))
            element.addAttribute(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "id", object.getLocalProperties().get(DeprecatedProperties.GML_ID, String.class));
    }
}
