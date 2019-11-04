package org.citygml4j.adapter.xml.bridge;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfacePropertyAdapter;
import org.citygml4j.adapter.xml.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBridgeRoom;
import org.citygml4j.model.bridge.ADEPropertyOfBridgeRoom;
import org.citygml4j.model.bridge.BridgeFurnitureProperty;
import org.citygml4j.model.bridge.BridgeInstallationProperty;
import org.citygml4j.model.bridge.BridgeRoom;
import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
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
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "AbstractGenericApplicationPropertyOfBridgeRoom"),
            new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfBridgeRoom")
    };

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
                    object.setLod3Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.getBoundarySurfaces().add(reader.getObjectUsingBuilder(AbstractThematicSurfacePropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfBridgeRoom> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfBridgeRoom.class);
            if (builder != null)
                object.getADEPropertiesOfBridgeRoom().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfBridgeRoom().add(GenericADEPropertyOfBridgeRoom.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
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
            if (object.getLod3Solid() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            for (AbstractThematicSurfaceProperty property : object.getBoundarySurfaces())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "boundedBy"), property, AbstractThematicSurfacePropertyAdapter.class, namespaces);
        }

        for (BridgeFurnitureProperty property : object.getBridgeFurniture())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, isCityGML3 ? "bridgeFurniture" : "interiorFurniture"), property, BridgeFurniturePropertyAdapter.class, namespaces);

        for (BridgeInstallationProperty property : object.getBridgeInstallations())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, isCityGML3 ? "bridgeInstallation" : "bridgeRoomInstallation"), property, BridgeInstallationPropertyAdapter.class, namespaces);

        for (ADEPropertyOfBridgeRoom property : object.getADEPropertiesOfBridgeRoom())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
