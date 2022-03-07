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

package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.core.model.appearance.TexCoordGen;
import org.citygml4j.core.model.core.TransformationMatrix3x4;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "TexCoordGen", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "TexCoordGen", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "TexCoordGen", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public class TexCoordGenAdapter extends AbstractTextureParameterizationAdapter<TexCoordGen> {

    @Override
    public TexCoordGen createObject(QName name, Object parent) throws ObjectBuildException {
        return new TexCoordGen();
    }

    @Override
    public void initializeObject(TexCoordGen object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        GMLBuilderHelper.buildSRSReference(object, attributes);
    }

    @Override
    public void buildChildObject(TexCoordGen object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI()) && "worldToTexture".equals(name.getLocalPart())) {
            reader.getTextContent().ifDoubleList(v -> object.setWorldToTexture(TransformationMatrix3x4.ofRowMajorList(v)));
            GMLBuilderHelper.buildSRSReference(object, attributes);
        }
    }

    @Override
    public Element createElement(TexCoordGen object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "TexCoordGen");
    }

    @Override
    public void initializeElement(Element element, TexCoordGen object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE))
            GMLSerializerHelper.serializeSRSReference(element, object, namespaces);
    }

    @Override
    public void writeChildElements(TexCoordGen object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);

        if (object.getWorldToTexture() != null) {
            Element worldToTexture = Element.of(appearanceNamespace, "worldToTexture").addTextContent(TextContent.ofDoubleList(object.getWorldToTexture().toRowMajorList()));
            if (!CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(appearanceNamespace))
                GMLSerializerHelper.serializeSRSReference(worldToTexture, object, namespaces);

            writer.writeElement(worldToTexture);
        }
    }
}
