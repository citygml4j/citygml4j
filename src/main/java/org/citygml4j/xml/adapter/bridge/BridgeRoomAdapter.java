package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.ade.generic.GenericADEOfBridgeRoom;
import org.citygml4j.model.bridge.ADEOfBridgeRoom;
import org.citygml4j.model.bridge.BridgeFurnitureProperty;
import org.citygml4j.model.bridge.BridgeInstallationProperty;
import org.citygml4j.model.bridge.BridgeRoom;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
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
    public BridgeRoom createObject(QName name) throws ObjectBuildException {
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
                    ADEBuilderHelper.addADEContainer(ADEOfBridgeRoom.class, object.getADEOfBridgeRoom(), GenericADEOfBridgeRoom::new, reader);
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
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfBridgeRoom.class, object.getADEOfBridgeRoom(),
                GenericADEOfBridgeRoom::new, reader, substitutionGroup))
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

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, bridgeNamespace, namespaces, writer);

        if (!isCityGML3) {
            if (object.getDeprecatedProperties().getLod4Solid() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4Solid"), object.getDeprecatedProperties().getLod4Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4MultiSurface"), object.getDeprecatedProperties().getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);
        }

        for (BridgeFurnitureProperty property : object.getBridgeFurniture())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, isCityGML3 ? "bridgeFurniture" : "interiorFurniture"), property, BridgeFurniturePropertyAdapter.class, namespaces);

        for (BridgeInstallationProperty property : object.getBridgeInstallations())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, isCityGML3 ? "bridgeInstallation" : "bridgeRoomInstallation"), property, BridgeInstallationPropertyAdapter.class, namespaces);

        for (ADEOfBridgeRoom container : object.getADEOfBridgeRoom())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(bridgeNamespace, "adeOfBridgeRoom") : null, container, namespaces, writer);
    }
}
