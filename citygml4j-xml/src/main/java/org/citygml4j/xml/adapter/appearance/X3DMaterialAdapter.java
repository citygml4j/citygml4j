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

import org.citygml4j.core.model.ade.generic.GenericADEOfX3DMaterial;
import org.citygml4j.core.model.appearance.ADEOfX3DMaterial;
import org.citygml4j.core.model.appearance.Color;
import org.citygml4j.core.model.appearance.GeometryReference;
import org.citygml4j.core.model.appearance.X3DMaterial;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
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
        @XMLElement(name = "X3DMaterial", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "X3DMaterial", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "X3DMaterial", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public class X3DMaterialAdapter extends AbstractSurfaceDataAdapter<X3DMaterial> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfX3DMaterial"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfX3DMaterial")
    };

    @Override
    public X3DMaterial createObject(QName name, Object parent) throws ObjectBuildException {
        return new X3DMaterial();
    }

    @Override
    public void buildChildObject(X3DMaterial object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "ambientIntensity":
                    reader.getTextContent().ifDouble(object::setAmbientIntensity);
                    return;
                case "diffuseColor":
                    reader.getTextContent().ifDoubleList(v -> object.setDiffuseColor(Color.fromList(v)));
                    return;
                case "emissiveColor":
                    reader.getTextContent().ifDoubleList(v -> object.setEmissiveColor(Color.fromList(v)));
                    return;
                case "specularColor":
                    reader.getTextContent().ifDoubleList(v -> object.setSpecularColor(Color.fromList(v)));
                    return;
                case "shininess":
                    reader.getTextContent().ifDouble(object::setShininess);
                    return;
                case "transparency":
                    reader.getTextContent().ifDouble(object::setTransparency);
                    return;
                case "isSmooth":
                    reader.getTextContent().ifBoolean(object::setIsSmooth);
                    return;
                case "target":
                    reader.getTextContent().ifPresent(v -> object.getTargets().add(new GeometryReference(v)));
                    return;
                case "adeOfX3DMaterial":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfX3DMaterial::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(X3DMaterial object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfX3DMaterial::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(X3DMaterial object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "X3DMaterial");
    }

    @Override
    public void writeChildElements(X3DMaterial object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equalsIgnoreCase(appearanceNamespace);

        if (object.isSetAmbientIntensity())
            writer.writeElement(Element.of(appearanceNamespace, "ambientIntensity").addTextContent(TextContent.ofDouble(object.getAmbientIntensity())));

        if (object.isSetDiffuseColor())
            writer.writeElement(Element.of(appearanceNamespace, "diffuseColor").addTextContent(TextContent.ofDoubleList(object.getDiffuseColor().toList())));

        if (object.isSetEmissiveColor())
            writer.writeElement(Element.of(appearanceNamespace, "emissiveColor").addTextContent(TextContent.ofDoubleList(object.getEmissiveColor().toList())));

        if (object.isSetSpecularColor())
            writer.writeElement(Element.of(appearanceNamespace, "specularColor").addTextContent(TextContent.ofDoubleList(object.getSpecularColor().toList())));

        if (object.isSetShininess())
            writer.writeElement(Element.of(appearanceNamespace, "shininess").addTextContent(TextContent.ofDouble(object.getShininess())));

        if (object.isSetTransparency())
            writer.writeElement(Element.of(appearanceNamespace, "transparency").addTextContent(TextContent.ofDouble(object.getTransparency())));

        if (object.isSetIsSmooth())
            writer.writeElement(Element.of(appearanceNamespace, "isSmooth").addTextContent(TextContent.ofBoolean(object.getIsSmooth())));

        if (object.isSetTargets()) {
            for (GeometryReference target : object.getTargets()) {
                if (target != null)
                    writer.writeElement(Element.of(appearanceNamespace, "target").addTextContent(target.getHref()));
            }
        }

        for (ADEOfX3DMaterial property : object.getADEProperties(ADEOfX3DMaterial.class))
            ADESerializerHelper.writeADEProperty(isCityGML3 ? Element.of(appearanceNamespace, "adeOfX3DMaterial") : null, property, namespaces, writer);
    }
}
