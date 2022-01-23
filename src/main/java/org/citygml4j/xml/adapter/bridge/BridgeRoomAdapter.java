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

package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.ade.generic.GenericADEOfBridgeRoom;
import org.citygml4j.model.bridge.ADEOfBridgeRoom;
import org.citygml4j.model.bridge.BridgeFurnitureProperty;
import org.citygml4j.model.bridge.BridgeInstallationProperty;
import org.citygml4j.model.bridge.BridgeRoom;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.deprecated.bridge.DeprecatedPropertiesOfBridgeRoom;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.xml.adapter.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.xml.adapter.deprecated.bridge.AbstractBoundarySurfacePropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
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
        @XMLElement(name = "BridgeRoom", namespaceURI = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE),
        @XMLElement(name = "BridgeRoom", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE)
})
public class BridgeRoomAdapter extends AbstractUnoccupiedSpaceAdapter<BridgeRoom> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfBridgeRoom");

    @Override
    public BridgeRoom createObject(QName name, Object parent) throws ObjectBuildException {
        return new BridgeRoom();
    }

    @Override
    public void buildChildObject(BridgeRoom object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBridgeNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "bridgeFurniture":
                case "interiorFurniture":
                    object.getBridgeFurniture().add(reader.getObjectUsingBuilder(BridgeFurniturePropertyAdapter.class));
                    return;
                case "bridgeInstallation":
                case "bridgeRoomInstallation":
                    object.getBridgeInstallations().add(reader.getObjectUsingBuilder(BridgeInstallationPropertyAdapter.class));
                    return;
                case "lod4Solid":
                    object.getDeprecatedProperties().setLod4Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().setLod4MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
                case "adeOfBridgeRoom":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfBridgeRoom::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(BridgeRoom object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfBridgeRoom::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(BridgeRoom object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getBridgeNamespace(namespaces), "BridgeRoom");
    }

    @Override
    public void writeChildElements(BridgeRoom object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(bridgeNamespace);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, bridgeNamespace, namespaces, writer);

        if (!isCityGML3) {
            DeprecatedPropertiesOfBridgeRoom properties = object.hasDeprecatedProperties() ?
                    object.getDeprecatedProperties() :
                    null;

            if (properties != null && properties.getLod4Solid() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4Solid"), properties.getLod4Solid(), SolidPropertyAdapter.class, namespaces);

            if (properties != null && properties.getLod4MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4MultiSurface"), properties.getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.isSetBoundaries()) {
                for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                    writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);
            }
        }

        if (object.isSetBridgeFurniture()) {
            for (BridgeFurnitureProperty property : object.getBridgeFurniture())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, isCityGML3 ? "bridgeFurniture" : "interiorFurniture"), property, BridgeFurniturePropertyAdapter.class, namespaces);
        }

        if (object.isSetBridgeInstallations()) {
            for (BridgeInstallationProperty property : object.getBridgeInstallations())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, isCityGML3 ? "bridgeInstallation" : "bridgeRoomInstallation"), property, BridgeInstallationPropertyAdapter.class, namespaces);
        }

        for (ADEOfBridgeRoom property : object.getADEProperties(ADEOfBridgeRoom.class))
            ADESerializerHelper.writeADEProperty(isCityGML3 ? Element.of(bridgeNamespace, "adeOfBridgeRoom") : null, property, namespaces, writer);
    }
}
