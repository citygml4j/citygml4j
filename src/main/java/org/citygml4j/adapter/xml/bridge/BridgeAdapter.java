package org.citygml4j.adapter.xml.bridge;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBridge;
import org.citygml4j.model.bridge.ADEPropertyOfBridge;
import org.citygml4j.model.bridge.Bridge;
import org.citygml4j.model.bridge.BridgePartProperty;
import org.citygml4j.util.CityGMLConstants;
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
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "AbstractGenericApplicationPropertyOfBridge");

    @Override
    public Bridge createObject(QName name) throws ObjectBuildException {
        return new Bridge();
    }

    @Override
    public void buildChildObject(Bridge object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(name.getNamespaceURI()) && "bridgePart".equals(name.getLocalPart())) {
            object.getBridgeParts().add(reader.getObjectUsingBuilder(BridgePartPropertyAdapter.class));
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(Bridge object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfBridge.class, object.getADEPropertiesOfBridge(),
                GenericADEPropertyOfBridge::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
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

        for (ADEPropertyOfBridge<?> property : object.getADEPropertiesOfBridge())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
