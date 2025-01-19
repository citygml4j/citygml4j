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

package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.core.model.appearance.GeometryReference;
import org.citygml4j.core.model.appearance.TextureAssociation;
import org.citygml4j.core.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "TextureAssociation", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE)
public class TextureAssociationAdapter extends AbstractGMLAdapter<TextureAssociation> {

    @Override
    public TextureAssociation createObject(QName name, Object parent) throws ObjectBuildException {
        return new TextureAssociation();
    }

    @Override
    public void buildChildObject(TextureAssociation object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "target":
                    reader.getTextContent().ifPresent(v -> object.setTarget(new GeometryReference(v)));
                    break;
                case "textureParameterization":
                    object.setTextureParameterization(reader.getObjectUsingBuilder(AbstractTextureParameterizationPropertyAdapter.class));
                    break;
            }
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(TextureAssociation object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "TextureAssociation");
    }

    @Override
    public void writeChildElements(TextureAssociation object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        String target = object.getTarget() != null ? object.getTarget().getHref() : null;
        writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "target").addTextContent(target));

        if (object.getTextureParameterization() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "textureParameterization"), object.getTextureParameterization(), AbstractTextureParameterizationPropertyAdapter.class, namespaces);
    }
}
