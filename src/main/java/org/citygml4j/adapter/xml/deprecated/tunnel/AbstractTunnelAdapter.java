package org.citygml4j.adapter.xml.deprecated.tunnel;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfacePropertyAdapter;
import org.citygml4j.adapter.xml.deprecated.core.AbstractSiteAdapter;
import org.citygml4j.adapter.xml.tunnel.HollowSpaceMemberAdapter;
import org.citygml4j.adapter.xml.tunnel.HollowSpacePropertyAdapter;
import org.citygml4j.adapter.xml.tunnel.TunnelInstallationMemberAdapter;
import org.citygml4j.adapter.xml.tunnel.TunnelInstallationPropertyAdapter;
import org.citygml4j.adapter.xml.tunnel.TunnelPartPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractTunnel;
import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
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
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
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
                    object.getDeprecatedProperties().addGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
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
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.OUTER_TUNNEL_INSTALLATION, outerTunnelInstallation);
                    return;
                case "interiorTunnelInstallation":
                    TunnelInstallationProperty interiorTunnelInstallation = reader.getObjectUsingBuilder(TunnelInstallationPropertyAdapter.class);
                    if (interiorTunnelInstallation.getObject() != null)
                        object.getTunnelInstallations().add(new TunnelInstallationMember(interiorTunnelInstallation.getObject()));
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.INTERIOR_TUNNEL_INSTALLATION, interiorTunnelInstallation);
                    return;
                case "boundedBy":
                    object.addBoundarySurface(reader.getObjectUsingBuilder(AbstractThematicSurfacePropertyAdapter.class));
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
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_SOLID, reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiCurve":
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_MULTI_CURVE, reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod4TerrainIntersection":
                    object.getDeprecatedProperties().setLod4TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "interiorHollowSpace":
                    HollowSpaceProperty interiorHollowSpace = reader.getObjectUsingBuilder(HollowSpacePropertyAdapter.class);
                    if (interiorHollowSpace.getObject() != null)
                        object.getHollowSpaces().add(new HollowSpaceMember(interiorHollowSpace.getObject()));
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.INTERIOR_HOLLOW_SPACE, interiorHollowSpace);
                    return;
                case "consistsOfTunnelPart":
                    TunnelPartProperty consistsOfTunnelPart = reader.getObjectUsingBuilder(TunnelPartPropertyAdapter.class);
                    if (consistsOfTunnelPart.getObject() != null && object instanceof Tunnel)
                        ((Tunnel) object).getTunnelParts().add(consistsOfTunnelPart);
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.CONSISTS_OF_TUNNEL_PART, consistsOfTunnelPart);
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractTunnel> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractTunnel.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractTunnel().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfAbstractTunnel().add(GenericADEPropertyOfAbstractTunnel.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
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

        if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod1MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

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
            if (member.getObject() != null && !member.getObject().getLocalProperties().getAndCompare(DeprecatedProperties.INT_TUNNEL_INSTALLATION, true))
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "outerTunnelInstallation"), member, TunnelInstallationMemberAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.OUTER_TUNNEL_INSTALLATION)) {
            for (TunnelInstallationProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.OUTER_TUNNEL_INSTALLATION, TunnelInstallationProperty.class))
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "outerTunnelInstallation"), property, TunnelInstallationPropertyAdapter.class, namespaces);
        }

        for (TunnelInstallationMember member : object.getTunnelInstallations()) {
            if (member.getObject() != null && member.getObject().getLocalProperties().getAndCompare(DeprecatedProperties.INT_TUNNEL_INSTALLATION, true))
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "interiorTunnelInstallation"), member, TunnelInstallationMemberAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.INTERIOR_TUNNEL_INSTALLATION)) {
            for (TunnelInstallationProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.INTERIOR_TUNNEL_INSTALLATION, TunnelInstallationProperty.class))
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "interiorTunnelInstallation"), property, TunnelInstallationPropertyAdapter.class, namespaces);
        }

        for (AbstractThematicSurfaceProperty property : object.getBoundarySurfaces())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "boundedBy"), property, AbstractThematicSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3Solid() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3MultiCurve"), object.getLod3MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod3TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_SOLID)) {
            SolidProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_SOLID, SolidProperty.class);
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4Solid"), property, SolidPropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_CURVE)) {
            MultiCurveProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_CURVE, MultiCurveProperty.class);
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4MultiCurve"), property, MultiCurvePropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().getLod4TerrainIntersectionCurve() != null) {
            MultiCurveProperty property = object.getDeprecatedProperties().getLod4TerrainIntersectionCurve();
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "lod4TerrainIntersection"), property, MultiCurvePropertyAdapter.class, namespaces);
        }

        for (HollowSpaceMember member : object.getHollowSpaces())
            writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "interiorHollowSpace"), member, HollowSpaceMemberAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.INTERIOR_HOLLOW_SPACE)) {
            for (HollowSpaceProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.INTERIOR_HOLLOW_SPACE, HollowSpaceProperty.class))
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "interiorHollowSpace"), property, HollowSpacePropertyAdapter.class, namespaces);
        }

        if (object instanceof Tunnel) {
            for (TunnelPartProperty property : ((Tunnel) object).getTunnelParts())
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "consistsOfTunnelPart"), property, TunnelPartPropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.CONSISTS_OF_TUNNEL_PART)) {
            for (TunnelPartProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.CONSISTS_OF_TUNNEL_PART, TunnelPartProperty.class))
                writer.writeElementUsingSerializer(Element.of(tunnelNamespace, "consistsOfTunnelPart"), property, TunnelPartPropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfAbstractTunnel property : object.getADEPropertiesOfAbstractTunnel())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
