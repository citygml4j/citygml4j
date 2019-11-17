package org.citygml4j.adapter.xml.deprecated.tunnel;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfTunnelPart;
import org.citygml4j.model.tunnel.ADEPropertyOfTunnelPart;
import org.citygml4j.model.tunnel.TunnelPart;
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

@XMLElement(name = "TunnelPart", namespaceURI = CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE)
public class TunnelPartAdapter extends AbstractTunnelAdapter<TunnelPart> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfTunnelPart");

    @Override
    public TunnelPart createObject(QName name) throws ObjectBuildException {
        return new TunnelPart();
    }

    @Override
    public void buildChildObject(TunnelPart object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(TunnelPart object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfTunnelPart.class, object.getADEPropertiesOfTunnelPart(),
                GenericADEPropertyOfTunnelPart::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(TunnelPart object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTunnelNamespace(namespaces), "TunnelPart");
    }

    @Override
    public void writeChildElements(TunnelPart object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfTunnelPart property : object.getADEPropertiesOfTunnelPart())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
