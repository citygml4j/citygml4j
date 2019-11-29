package org.citygml4j.adapter.xml.tunnel;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.construction.AbstractConstructionAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractTunnel;
import org.citygml4j.model.tunnel.ADEPropertyOfAbstractTunnel;
import org.citygml4j.model.tunnel.AbstractTunnel;
import org.citygml4j.model.tunnel.HollowSpaceMember;
import org.citygml4j.model.tunnel.TunnelConstructiveElementMember;
import org.citygml4j.model.tunnel.TunnelFurnitureMember;
import org.citygml4j.model.tunnel.TunnelInstallationMember;
import org.citygml4j.util.CityGMLConstants;
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

public abstract class AbstractTunnelAdapter<T extends AbstractTunnel> extends AbstractConstructionAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractTunnel");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "tunnelConstructiveElement":
                    object.getTunnelConstructiveElements().add(reader.getObjectUsingBuilder(TunnelConstructiveElementMemberAdapter.class));
                    return;
                case "tunnelInstallation":
                    object.getTunnelInstallations().add(reader.getObjectUsingBuilder(TunnelInstallationMemberAdapter.class));
                    return;
                case "hollowSpace":
                    object.getHollowSpaces().add(reader.getObjectUsingBuilder(HollowSpaceMemberAdapter.class));
                    return;
                case "tunnelFurniture":
                    object.getTunnelFurniture().add(reader.getObjectUsingBuilder(TunnelFurnitureMemberAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractTunnel.class, object.getADEPropertiesOfAbstractTunnel(),
                GenericADEPropertyOfAbstractTunnel::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, namespaces, writer);

        for (TunnelConstructiveElementMember member : object.getTunnelConstructiveElements())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "tunnelConstructiveElement"), member, TunnelConstructiveElementMemberAdapter.class, namespaces);

        for (TunnelInstallationMember member : object.getTunnelInstallations())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "tunnelInstallation"), member, TunnelInstallationMemberAdapter.class, namespaces);

        for (HollowSpaceMember member : object.getHollowSpaces())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "hollowSpace"), member, HollowSpaceMemberAdapter.class, namespaces);

        for (TunnelFurnitureMember member : object.getTunnelFurniture())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE, "tunnelFurniture"), member, TunnelFurnitureMemberAdapter.class, namespaces);

        for (ADEPropertyOfAbstractTunnel<?> property : object.getADEPropertiesOfAbstractTunnel())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
