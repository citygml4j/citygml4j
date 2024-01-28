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

package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractTunnel;
import org.citygml4j.core.model.tunnel.*;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.AbstractConstructionAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractTunnelAdapter<T extends AbstractTunnel> extends AbstractConstructionAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "tunnelConstructiveElement":
                    object.getTunnelConstructiveElements().add(reader.getObjectUsingBuilder(TunnelConstructiveElementPropertyAdapter.class));
                    return;
                case "tunnelInstallation":
                    object.getTunnelInstallations().add(reader.getObjectUsingBuilder(TunnelInstallationPropertyAdapter.class));
                    return;
                case "hollowSpace":
                    object.getHollowSpaces().add(reader.getObjectUsingBuilder(HollowSpacePropertyAdapter.class));
                    return;
                case "tunnelFurniture":
                    object.getTunnelFurniture().add(reader.getObjectUsingBuilder(TunnelFurniturePropertyAdapter.class));
                    return;
                case "adeOfAbstractTunnel":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfAbstractTunnel::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, namespaces, writer);

        if (object.isSetTunnelConstructiveElements()) {
            for (TunnelConstructiveElementProperty property : object.getTunnelConstructiveElements())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "tunnelConstructiveElement"), property, TunnelConstructiveElementPropertyAdapter.class, namespaces);
        }

        if (object.isSetTunnelInstallations()) {
            for (TunnelInstallationProperty property : object.getTunnelInstallations())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "tunnelInstallation"), property, TunnelInstallationPropertyAdapter.class, namespaces);
        }

        if (object.isSetHollowSpaces()) {
            for (HollowSpaceProperty property : object.getHollowSpaces())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "hollowSpace"), property, HollowSpacePropertyAdapter.class, namespaces);
        }

        if (object.isSetTunnelFurniture()) {
            for (TunnelFurnitureProperty property : object.getTunnelFurniture())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "tunnelFurniture"), property, TunnelFurniturePropertyAdapter.class, namespaces);
        }

        for (ADEOfAbstractTunnel property : object.getADEProperties(ADEOfAbstractTunnel.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "adeOfAbstractTunnel"), property, namespaces, writer);
    }
}
