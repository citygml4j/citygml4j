package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.model.ade.generic.GenericADEOfTunnel;
import org.citygml4j.model.tunnel.ADEOfTunnel;
import org.citygml4j.model.tunnel.Tunnel;
import org.citygml4j.model.tunnel.TunnelPartProperty;
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

@XMLElement(name = "Tunnel", namespaceURI = CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE)
public class TunnelAdapter extends AbstractTunnelAdapter<Tunnel> {

    @Override
    public Tunnel createObject(QName name) throws ObjectBuildException {
        return new Tunnel();
    }

    @Override
    public void buildChildObject(Tunnel object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "tunnelPart":
                    object.getTunnelParts().add(reader.getObjectUsingBuilder(TunnelPartPropertyAdapter.class));
                    return;
                case "adeOfTunnel":
                    ADEBuilderHelper.addADEContainer(ADEOfTunnel.class, object.getADEOfTunnel(), GenericADEOfTunnel::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Tunnel object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "Tunnel");
    }

    @Override
    public void writeChildElements(Tunnel object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (TunnelPartProperty property : object.getTunnelParts())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "tunnelPart"), property, TunnelPartPropertyAdapter.class, namespaces);

        for (ADEOfTunnel container : object.getADEOfTunnel())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "adeOfTunnel"), container, namespaces, writer);
    }
}
