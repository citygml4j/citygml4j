/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.model.ade.generic.GenericADEOfAbstractTexture;
import org.citygml4j.model.appearance.*;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
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

public abstract class AbstractTextureAdapter<T extends AbstractTexture> extends AbstractSurfaceDataAdapter<T> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfTexture"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfTexture")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "imageURI":
                    reader.getTextContent().ifPresent(object::setImageURI);
                    return;
                case "mimeType":
                    object.setMimeType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "textureType":
                    reader.getTextContent().ifPresent(v -> object.setTextureType(TextureType.fromValue(v)));
                    return;
                case "wrapMode":
                    reader.getTextContent().ifPresent(v -> object.setWrapMode(WrapMode.fromValue(v)));
                    return;
                case "borderColor":
                    reader.getTextContent().ifDoubleList(v -> object.setBorderColor(ColorPlusOpacity.fromList(v)));
                    return;
                case "adeOfAbstractTexture":
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractTexture.class, object.getADEOfAbstractTexture(), GenericADEOfAbstractTexture::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfAbstractTexture.class, object.getADEOfAbstractTexture(),
                GenericADEOfAbstractTexture::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equalsIgnoreCase(appearanceNamespace);

        if (object.getImageURI() != null)
            writer.writeElement(Element.of(appearanceNamespace, "imageURI").addTextContent(object.getImageURI()));

        if (object.getMimeType() != null)
            writer.writeElementUsingSerializer(Element.of(appearanceNamespace, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

        if (object.getTextureType() != null)
            writer.writeElement(Element.of(appearanceNamespace, "textureType").addTextContent(object.getTextureType().toValue()));

        if (object.getWrapMode() != null)
            writer.writeElement(Element.of(appearanceNamespace, "wrapMode").addTextContent(object.getWrapMode().toValue()));

        if (object.getBorderColor() != null)
            writer.writeElement(Element.of(appearanceNamespace, "borderColor").addTextContent(TextContent.ofDoubleList(object.getBorderColor().toList())));

        for (ADEOfAbstractTexture container : object.getADEOfAbstractTexture())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(appearanceNamespace, "adeOfAbstractTexture") : null, container, namespaces, writer);
    }
}
