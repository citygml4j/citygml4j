package org.citygml4j.xml.adapter.bridge;

import org.citygml4j.model.ade.generic.GenericADEOfBridgePart;
import org.citygml4j.model.bridge.ADEOfBridgePart;
import org.citygml4j.model.bridge.BridgePart;
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

@XMLElement(name = "BridgePart", namespaceURI = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE)
public class BridgePartAdapter extends AbstractBridgeAdapter<BridgePart> {

    @Override
    public BridgePart createObject(QName name) throws ObjectBuildException {
        return new BridgePart();
    }

    @Override
    public void buildChildObject(BridgePart object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfBridgePart".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfBridgePart.class, object.getADEOfBridgePart(), GenericADEOfBridgePart::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BridgePart object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "BridgePart");
    }

    @Override
    public void writeChildElements(BridgePart object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfBridgePart container : object.getADEOfBridgePart())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "adeOfBridgePart"), container, namespaces, writer);
    }
}
