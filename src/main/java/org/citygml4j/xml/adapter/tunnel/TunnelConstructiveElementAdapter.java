package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.model.ade.generic.GenericADEOfTunnelConstructiveElement;
import org.citygml4j.model.tunnel.ADEOfTunnelConstructiveElement;
import org.citygml4j.model.tunnel.TunnelConstructiveElement;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.AbstractConstructiveElementAdapter;
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

@XMLElement(name = "TunnelConstructiveElement", namespaceURI = CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE)
public class TunnelConstructiveElementAdapter extends AbstractConstructiveElementAdapter<TunnelConstructiveElement> {

    @Override
    public TunnelConstructiveElement createObject(QName name) throws ObjectBuildException {
        return new TunnelConstructiveElement();
    }

    @Override
    public void buildChildObject(TunnelConstructiveElement object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("adeOfTunnelConstructiveElement".equals(name.getLocalPart())) {
                ADEBuilderHelper.addADEContainer(ADEOfTunnelConstructiveElement.class, object.getADEOfTunnelConstructiveElement(), GenericADEOfTunnelConstructiveElement::of, reader);
                return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(TunnelConstructiveElement object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "TunnelConstructiveElement");
    }

    @Override
    public void writeChildElements(TunnelConstructiveElement object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, namespaces, writer);

        for (ADEOfTunnelConstructiveElement container : object.getADEOfTunnelConstructiveElement())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "adeOfTunnelConstructiveElement"), container, namespaces, writer);
    }
}
