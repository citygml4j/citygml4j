package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractBridge;
import org.citygml4j.model.bridge.ADEOfAbstractBridge;
import org.citygml4j.model.bridge.AbstractBridge;
import org.citygml4j.model.bridge.BridgeConstructiveElementMember;
import org.citygml4j.model.bridge.BridgeFurnitureMember;
import org.citygml4j.model.bridge.BridgeInstallationMember;
import org.citygml4j.model.bridge.BridgeRoomMember;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.AbstractConstructionAdapter;
import org.citygml4j.xml.adapter.core.AddressPropertyAdapter;
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

public abstract class AbstractBridgeAdapter<T extends AbstractBridge> extends AbstractConstructionAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "isMovable":
                    reader.getTextContent().ifBoolean(object::setIsMovable);
                    return;
                case "bridgeConstructiveElement":
                    object.getBridgeConstructiveElements().add(reader.getObjectUsingBuilder(BridgeConstructiveElementMemberAdapter.class));
                    return;
                case "bridgeInstallation":
                    object.getBridgeInstallations().add(reader.getObjectUsingBuilder(BridgeInstallationMemberAdapter.class));
                    return;
                case "bridgeRoom":
                    object.getBridgeRooms().add(reader.getObjectUsingBuilder(BridgeRoomMemberAdapter.class));
                    return;
                case "bridgeFurniture":
                    object.getBridgeFurniture().add(reader.getObjectUsingBuilder(BridgeFurnitureMemberAdapter.class));
                    return;
                case "address":
                    object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
                    return;
                case "adeOfAbstractBridge":
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractBridge.class, object.getADEOfAbstractBridge(), GenericADEOfAbstractBridge::new, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, namespaces, writer);

        if (object.isSetIsMovable())
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "isMovable").addTextContent(TextContent.ofBoolean(object.getIsMovable())));

        for (BridgeConstructiveElementMember member : object.getBridgeConstructiveElements())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "bridgeConstructiveElement"), member, BridgeConstructiveElementMemberAdapter.class, namespaces);

        for (BridgeInstallationMember member : object.getBridgeInstallations())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "bridgeInstallation"), member, BridgeInstallationMemberAdapter.class, namespaces);

        for (BridgeRoomMember member : object.getBridgeRooms())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "bridgeRoom"), member, BridgeRoomMemberAdapter.class, namespaces);

        for (BridgeFurnitureMember member : object.getBridgeFurniture())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "bridgeFurniture"), member, BridgeFurnitureMemberAdapter.class, namespaces);

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (ADEOfAbstractBridge container : object.getADEOfAbstractBridge())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "adeOfAbstractBridge"), container, namespaces, writer);
    }
}
