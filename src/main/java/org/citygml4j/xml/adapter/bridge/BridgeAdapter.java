package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.ade.generic.GenericADEOfBridge;
import org.citygml4j.model.bridge.ADEOfBridge;
import org.citygml4j.model.bridge.Bridge;
import org.citygml4j.model.bridge.BridgePartProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.annotation.XMLElement;
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

@XMLElement(name = "Bridge", namespaceURI = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE)
public class BridgeAdapter extends AbstractBridgeAdapter<Bridge> {

    @Override
    public Bridge createObject(QName name) throws ObjectBuildException {
        return new Bridge();
    }

    @Override
    public void buildChildObject(Bridge object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "bridgePart":
                    object.getBridgeParts().add(reader.getObjectUsingBuilder(BridgePartPropertyAdapter.class));
                    return;
                case "adeOfBridge":
                    ADEBuilderHelper.addADEContainer(ADEOfBridge.class, object.getADEOfBridge(), GenericADEOfBridge::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Bridge object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "Bridge");
    }

    @Override
    public void writeChildElements(Bridge object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (BridgePartProperty property : object.getBridgeParts())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "bridgePart"), property, BridgePartPropertyAdapter.class, namespaces);

        for (ADEOfBridge container : object.getADEOfBridge())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "adeOfBridge"), container, namespaces, writer);
    }
}
