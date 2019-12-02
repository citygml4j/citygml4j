package org.citygml4j.xml.adapter.deprecated.tunnel;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.xml.adapter.deprecated.core.AbstractSiteAdapter;
import org.citygml4j.xml.adapter.tunnel.HollowSpaceMemberAdapter;
import org.citygml4j.xml.adapter.tunnel.HollowSpacePropertyAdapter;
import org.citygml4j.xml.adapter.tunnel.TunnelInstallationMemberAdapter;
import org.citygml4j.xml.adapter.tunnel.TunnelInstallationPropertyAdapter;
import org.citygml4j.xml.adapter.tunnel.TunnelPartPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractTunnel;
import org.citygml4j.model.construction.RelationToConstruction;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.tunnel.ADEPropertyOfAbstractTunnel;
import org.citygml4j.model.tunnel.AbstractTunnel;
import org.citygml4j.model.tunnel.HollowSpaceMember;
import org.citygml4j.model.tunnel.HollowSpaceProperty;
import org.citygml4j.model.tunnel.Tunnel;
import org.citygml4j.model.tunnel.TunnelInstallationMember;
import org.citygml4j.model.tunnel.TunnelInstallationProperty;
import org.citygml4j.model.tunnel.TunnelPartProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.ReferenceAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public abstract class AbstractTunnelAdapter<T extends AbstractTunnel> extends AbstractSiteAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE, "_GenericApplicationPropertyOfAbstractTunnel");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isTunnelNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "yearOfConstruction":
                    reader.getTextContent().ifGYear(v -> object.setDateOfConstruction(v.toLocalDate()));
                    return;
                case "yearOfDemolition":
                    reader.getTextContent().ifGYear(v -> object.setDateOfDemolition(v.toLocalDate()));
                    return;
                case "lod1Solid":
                    object.setLod1Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.getDeprecatedProperties().setLod1MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1TerrainIntersection":
                    object.setLod1TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod2Solid":
                    object.setLod2Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod2MultiSurface":
                    object.setLod2MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod2MultiCurve":
                    object.setLod2MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod2TerrainIntersection":
                    object.setLod2TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "outerTunnelInstallation":
                    TunnelInstallationProperty outerTunnelInstallation = reader.getObjectUsingBuilder(TunnelInstallationPropertyAdapter.class);
                    if (outerTunnelInstallation.getObject() != null)
                        object.getTunnelInstallations().add(new TunnelInstallationMember(outerTunnelInstallation.getObject()));
                    else
                        object.getDeprecatedProperties().getOuterTunnelInstallations().add(outerTunnelInstallation);
                    return;
                case "interiorTunnelInstallation":
                    TunnelInstallationProperty interiorTunnelInstallation = reader.getObjectUsingBuilder(TunnelInstallationPropertyAdapter.class);
                    if (interiorTunnelInstallation.getObject() != null)
                        object.getTunnelInstallations().add(new TunnelInstallationMember(interiorTunnelInstallation.getObject()));
                    else
                        object.getDeprecatedProperties().getInteriorTunnelInstallations().add(interiorTunnelInstallation);
                    return;
                case "boundedBy":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
                case "lod3Solid":
                    object.setLod3Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3MultiCurve":
                    object.setLod3MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod3TerrainIntersection":
                    object.setLod3TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod4Solid":
                    object.getDeprecatedProperties().setLod4Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().setLod4MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiCurve":
                    object.getDeprecatedProperties().setLod4MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod4TerrainIntersection":
                    object.getDeprecatedProperties().setLod4TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "interiorHollowSpace":
                    HollowSpaceProperty interiorHollowSpace = reader.getObjectUsingBuilder(HollowSpacePropertyAdapter.class);
                    if (interiorHollowSpace.getObject() != null)
                        object.getHollowSpaces().add(new HollowSpaceMember(interiorHollowSpace.getObject()));
                    else if (interiorHollowSpace.getGenericElement() != null) {
                        HollowSpaceMember member = new HollowSpaceMember();
                        member.setGenericElement(interiorHollowSpace.getGenericElement());
                        object.getHollowSpaces().add(member);
                    } else
                        object.getDeprecatedProperties().getInteriorHollowSpaces().add(new Reference(interiorHollowSpace));
                    return;
                case "consistsOfTunnelPart":
                    TunnelPartProperty consistsOfTunnelPart = reader.getObjectUsingBuilder(TunnelPartPropertyAdapter.class);
                    if ((consistsOfTunnelPart.getObject() != null || consistsOfTunnelPart.getGenericElement() != null) && object instanceof Tunnel)
                        ((Tunnel) object).getTunnelParts().add(consistsOfTunnelPart);
                    else
                        object.getDeprecatedProperties().getConsistsOfTunnelParts().add(consistsOfTunnelPart);
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
        String tunnelNamespace = CityGMLSerializerHelper.getTunnelNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, tunnelNamespace, namespaces, writer);

        if (object.getDateOfConstruction() != null)
            writer.writeElement(Element.of(tunnelNamespace, "yearOfConstruction").addTextContent(TextContent.ofGYear(OffsetDateTime.of(object.getDateOfConstruction(), LocalTime.MIN, ZoneOffset.UTC))));

        if (object.getDateOfDemolition() != null)
            writer.writeElement(Element.of(tunnelNamespace, "yearOfDemolition").addTextContent(TextContent.ofGYear(OffsetDateTime.of(object.getDateOfDemolition(), LocalTime.MIN, ZoneOffset.UTC))));

        if (object.getLod1Solid() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod1Solid"), object.getLod1Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod1MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod1MultiSurface"), object.getDeprecatedProperties().getLod1MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod1TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod1TerrainIntersection"), object.getLod1TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod2Solid() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod2Solid"), object.getLod2Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod2MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod2MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod2MultiCurve"), object.getLod2MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod2TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod2TerrainIntersection"), object.getLod2TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        for (TunnelInstallationMember member : object.getTunnelInstallations()) {
            if (member.getObject() != null && member.getObject().getRelationToConstruction() != RelationToConstruction.INSIDE)
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "outerTunnelInstallation"), member, TunnelInstallationMemberAdapter.class, namespaces);
        }

        for (TunnelInstallationProperty property : object.getDeprecatedProperties().getOuterTunnelInstallations())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "outerTunnelInstallation"), property, TunnelInstallationPropertyAdapter.class, namespaces);

        for (TunnelInstallationMember member : object.getTunnelInstallations()) {
            if (member.getObject() != null && member.getObject().getRelationToConstruction() == RelationToConstruction.INSIDE)
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "interiorTunnelInstallation"), member, TunnelInstallationMemberAdapter.class, namespaces);
        }

        for (TunnelInstallationProperty property : object.getDeprecatedProperties().getInteriorTunnelInstallations())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "interiorTunnelInstallation"), property, TunnelInstallationPropertyAdapter.class, namespaces);

        for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);

        if (object.getLod3Solid() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3MultiCurve"), object.getLod3MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod3TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4Solid() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4Solid"), object.getDeprecatedProperties().getLod4Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4MultiSurface"), object.getDeprecatedProperties().getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4MultiCurve"), object.getDeprecatedProperties().getLod4MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4TerrainIntersection"), object.getDeprecatedProperties().getLod4TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        for (HollowSpaceMember member : object.getHollowSpaces())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "interiorHollowSpace"), member, HollowSpaceMemberAdapter.class, namespaces);

        for (Reference reference : object.getDeprecatedProperties().getInteriorHollowSpaces())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "interiorHollowSpace"), reference, ReferenceAdapter.class, namespaces);

        if (object instanceof Tunnel) {
            for (TunnelPartProperty property : ((Tunnel) object).getTunnelParts())
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "consistsOfTunnelPart"), property, TunnelPartPropertyAdapter.class, namespaces);
        }

        for (TunnelPartProperty property : object.getDeprecatedProperties().getConsistsOfTunnelParts())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "consistsOfTunnelPart"), property, TunnelPartPropertyAdapter.class, namespaces);

        for (ADEPropertyOfAbstractTunnel<?> property : object.getADEPropertiesOfAbstractTunnel())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
