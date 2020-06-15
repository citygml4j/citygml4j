package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.model.ade.generic.GenericADEOfTunnelPart;
import org.citygml4j.model.tunnel.ADEOfTunnelPart;
import org.citygml4j.model.tunnel.TunnelPart;
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

@XMLElement(name = "TunnelPart", namespaceURI = CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE)
public class TunnelPartAdapter extends AbstractTunnelAdapter<TunnelPart> {

    @Override
    public TunnelPart createObject(QName name, Object parent) throws ObjectBuildException {
        return new TunnelPart();
    }

    @Override
    public void buildChildObject(TunnelPart object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfTunnelPart".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfTunnelPart.class, object.getADEOfTunnelPart(), GenericADEOfTunnelPart::of, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(TunnelPart object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "TunnelPart");
    }

    @Override
    public void writeChildElements(TunnelPart object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfTunnelPart container : object.getADEOfTunnelPart())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "adeOfTunnelPart"), container, namespaces, writer);
    }
}
