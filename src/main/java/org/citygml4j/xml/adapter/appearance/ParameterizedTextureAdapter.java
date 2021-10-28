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

package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.model.ade.generic.GenericADEOfParameterizedTexture;
import org.citygml4j.model.appearance.ADEOfParameterizedTexture;
import org.citygml4j.model.appearance.ParameterizedTexture;
import org.citygml4j.model.appearance.TextureAssociationProperty;
import org.citygml4j.model.deprecated.appearance.TextureAssociationReference;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.deprecated.appearance.TextureAssociationReferenceAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "ParameterizedTexture", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "ParameterizedTexture", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "ParameterizedTexture", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public class ParameterizedTextureAdapter extends AbstractTextureAdapter<ParameterizedTexture> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfParameterizedTexture"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfParameterizedTexture")
    };

    @Override
    public ParameterizedTexture createObject(QName name, Object parent) throws ObjectBuildException {
        return new ParameterizedTexture();
    }

    @Override
    public void buildChildObject(ParameterizedTexture object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "textureParameterization":
                    object.getTextureParameterizations().add(reader.getObjectUsingBuilder(TextureAssociationPropertyAdapter.class));
                    return;
                case "target":
                    if (attributes.getValue(GMLConstants.XLINK_NAMESPACE, "href").isPresent()) {
                        object.getDeprecatedProperties().getTargets().add(reader.getObjectUsingBuilder(TextureAssociationReferenceAdapter.class));
                    } else {
                        object.getTextureParameterizations().add(reader.getObjectUsingBuilder(org.citygml4j.xml.adapter.deprecated.appearance.TextureAssociationPropertyAdapter.class));
                    }
                    return;
                case "adeOfParameterizedTexture":
                    ADEBuilderHelper.addADEContainer(ADEOfParameterizedTexture.class, object.getADEOfParameterizedTexture(), GenericADEOfParameterizedTexture::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(ParameterizedTexture object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfParameterizedTexture.class, object.getADEOfParameterizedTexture(),
                GenericADEOfParameterizedTexture::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(ParameterizedTexture object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "ParameterizedTexture");
    }

    @Override
    public void writeChildElements(ParameterizedTexture object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(appearanceNamespace);

        for (TextureAssociationProperty property : object.getTextureParameterizations()) {
            if (isCityGML3)
                writer.writeElementUsingSerializer(Element.of(appearanceNamespace, "textureParameterization"), property, TextureAssociationPropertyAdapter.class, namespaces);
            else
                writer.writeElementUsingSerializer(Element.of(appearanceNamespace, "target"), property, org.citygml4j.xml.adapter.deprecated.appearance.TextureAssociationPropertyAdapter.class, namespaces);
        }

        if (!isCityGML3) {
            for (TextureAssociationReference reference : object.getDeprecatedProperties().getTargets())
                writer.writeElementUsingSerializer(Element.of(appearanceNamespace, "target"), reference, TextureAssociationReferenceAdapter.class, namespaces);
        }

        for (ADEOfParameterizedTexture container : object.getADEOfParameterizedTexture())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(appearanceNamespace, "adeOfParameterizedTexture") : null, container, namespaces, writer);
    }
}
