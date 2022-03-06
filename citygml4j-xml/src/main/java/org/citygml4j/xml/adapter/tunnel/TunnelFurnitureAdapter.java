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

package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.core.model.ade.generic.GenericADEOfTunnelFurniture;
import org.citygml4j.core.model.deprecated.tunnel.DeprecatedPropertiesOfTunnelFurniture;
import org.citygml4j.core.model.tunnel.ADEOfTunnelFurniture;
import org.citygml4j.core.model.tunnel.TunnelFurniture;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.AbstractFurnitureAdapter;
import org.citygml4j.xml.adapter.core.ImplicitGeometryPropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
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
        @XMLElement(name = "TunnelFurniture", namespaceURI = CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE),
        @XMLElement(name = "TunnelFurniture", namespaceURI = CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE)
})
public class TunnelFurnitureAdapter extends AbstractFurnitureAdapter<TunnelFurniture> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfTunnelFurniture");

    @Override
    public TunnelFurniture createObject(QName name, Object parent) throws ObjectBuildException {
        return new TunnelFurniture();
    }

    @Override
    public void buildChildObject(TunnelFurniture object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isTunnelNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod4Geometry":
                    object.getDeprecatedProperties().setLod4Geometry(reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod4ImplicitRepresentation":
                    object.getDeprecatedProperties().setLod4ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "adeOfTunnelFurniture":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfTunnelFurniture::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(TunnelFurniture object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfTunnelFurniture::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(TunnelFurniture object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTunnelNamespace(namespaces), "TunnelFurniture");
    }

    @Override
    public void writeChildElements(TunnelFurniture object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String tunnelNamespace = CityGMLSerializerHelper.getTunnelNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(tunnelNamespace);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, tunnelNamespace, namespaces, writer);

        if (!isCityGML3 && object.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfTunnelFurniture properties = object.getDeprecatedProperties();

            if (properties.getLod4Geometry() != null)
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4Geometry"), properties.getLod4Geometry(), GeometryPropertyAdapter.class, namespaces);

            if (properties.getLod4ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4ImplicitRepresentation"), properties.getLod4ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);
        }

        for (ADEOfTunnelFurniture property : object.getADEProperties(ADEOfTunnelFurniture.class))
            ADESerializerHelper.writeADEProperty(isCityGML3 ? Element.of(tunnelNamespace, "adeOfTunnelFurniture") : null, property, namespaces, writer);
    }
}
