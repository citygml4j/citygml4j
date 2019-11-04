package org.citygml4j.adapter.xml.tunnel;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.construction.AbstractConstructiveElementAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfTunnelConstructiveElement;
import org.citygml4j.model.tunnel.ADEPropertyOfTunnelConstructiveElement;
import org.citygml4j.model.tunnel.TunnelConstructiveElement;
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

@XMLElement(name = "TunnelConstructiveElement", namespaceURI = CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE)
public class TunnelConstructiveElementAdapter extends AbstractConstructiveElementAdapter<TunnelConstructiveElement> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "AbstractGenericApplicationPropertyOfTunnelConstructiveElement");

    @Override
    public TunnelConstructiveElement createObject(QName name) throws ObjectBuildException {
        return new TunnelConstructiveElement();
    }

    @Override
    public void buildChildObject(TunnelConstructiveElement object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(name.getNamespaceURI())
                && CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
            return;

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfTunnelConstructiveElement> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfTunnelConstructiveElement.class);
            if (builder != null)
                object.getADEPropertiesOfTunnelConstructiveElement().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfTunnelConstructiveElement().add(GenericADEPropertyOfTunnelConstructiveElement.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(TunnelConstructiveElement object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "TunnelConstructiveElement");
    }

    @Override
    public void writeChildElements(TunnelConstructiveElement object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, namespaces, writer);

        for (ADEPropertyOfTunnelConstructiveElement property : object.getADEPropertiesOfTunnelConstructiveElement())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
