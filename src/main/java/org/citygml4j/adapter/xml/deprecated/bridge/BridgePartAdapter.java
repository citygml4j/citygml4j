package org.citygml4j.adapter.xml.deprecated.bridge;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBridgePart;
import org.citygml4j.model.bridge.ADEPropertyOfBridgePart;
import org.citygml4j.model.bridge.BridgePart;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "BridgePart", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE)
public class BridgePartAdapter extends AbstractBridgeAdapter<BridgePart> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfBridgePart");

    @Override
    public BridgePart createObject(QName name) throws ObjectBuildException {
        return new BridgePart();
    }

    @Override
    public void buildChildObject(BridgePart object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfBridgePart> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfBridgePart.class);
            if (builder != null)
                object.getADEPropertiesOfBridgePart().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfBridgePart().add(GenericADEPropertyOfBridgePart.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BridgePart object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getBridgeNamespace(namespaces), "BridgePart");
    }

    @Override
    public void writeChildElements(BridgePart object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfBridgePart property : object.getADEPropertiesOfBridgePart())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
