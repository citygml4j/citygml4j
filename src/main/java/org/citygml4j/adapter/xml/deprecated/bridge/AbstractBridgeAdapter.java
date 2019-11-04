package org.citygml4j.adapter.xml.deprecated.bridge;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.bridge.BridgeConstructiveElementMemberAdapter;
import org.citygml4j.adapter.xml.bridge.BridgeConstructiveElementPropertyAdapter;
import org.citygml4j.adapter.xml.bridge.BridgeInstallationMemberAdapter;
import org.citygml4j.adapter.xml.bridge.BridgeInstallationPropertyAdapter;
import org.citygml4j.adapter.xml.bridge.BridgePartPropertyAdapter;
import org.citygml4j.adapter.xml.bridge.BridgeRoomMemberAdapter;
import org.citygml4j.adapter.xml.bridge.BridgeRoomPropertyAdapter;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfacePropertyAdapter;
import org.citygml4j.adapter.xml.core.AddressPropertyAdapter;
import org.citygml4j.adapter.xml.deprecated.core.AbstractSiteAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractBridge;
import org.citygml4j.model.bridge.ADEPropertyOfAbstractBridge;
import org.citygml4j.model.bridge.AbstractBridge;
import org.citygml4j.model.bridge.Bridge;
import org.citygml4j.model.bridge.BridgeConstructiveElementMember;
import org.citygml4j.model.bridge.BridgeConstructiveElementProperty;
import org.citygml4j.model.bridge.BridgeInstallationMember;
import org.citygml4j.model.bridge.BridgeInstallationProperty;
import org.citygml4j.model.bridge.BridgePartProperty;
import org.citygml4j.model.bridge.BridgeRoomMember;
import org.citygml4j.model.bridge.BridgeRoomProperty;
import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
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

public abstract class AbstractBridgeAdapter<T extends AbstractBridge> extends AbstractSiteAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfAbstractBridge");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLBridgeNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "yearOfConstruction":
                    reader.getTextContent().ifGYear(v -> object.setDateOfConstruction(v.toLocalDate()));
                    return;
                case "yearOfDemolition":
                    reader.getTextContent().ifGYear(v -> object.setDateOfDemolition(v.toLocalDate()));
                    return;
                case "isMovable":
                    reader.getTextContent().ifBoolean(object::setIsMovable);
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
                case "outerBridgeConstruction":
                    BridgeConstructiveElementProperty bridgeConstructiveElement = reader.getObjectUsingBuilder(BridgeConstructiveElementPropertyAdapter.class);
                    if (bridgeConstructiveElement.getObject() != null)
                        object.getBridgeConstructiveElements().add(new BridgeConstructiveElementMember(bridgeConstructiveElement.getObject()));
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.OUTER_BRIDGE_CONSTRUCTION, bridgeConstructiveElement);
                    return;
                case "outerBridgeInstallation":
                    BridgeInstallationProperty outerBridgeInstallation = reader.getObjectUsingBuilder(BridgeInstallationPropertyAdapter.class);
                    if (outerBridgeInstallation.getObject() != null)
                        object.getBridgeInstallations().add(new BridgeInstallationMember(outerBridgeInstallation.getObject()));
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.OUTER_BRIDGE_INSTALLATION, outerBridgeInstallation);
                    return;
                case "interiorBridgeInstallation":
                    BridgeInstallationProperty interiorBridgeInstallation = reader.getObjectUsingBuilder(BridgeInstallationPropertyAdapter.class);
                    if (interiorBridgeInstallation.getObject() != null)
                        object.getBridgeInstallations().add(new BridgeInstallationMember(interiorBridgeInstallation.getObject()));
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.INTERIOR_BRIDGE_INSTALLATION, interiorBridgeInstallation);
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
                case "interiorBridgeRoom":
                    BridgeRoomProperty interiorBridgeRoom = reader.getObjectUsingBuilder(BridgeRoomPropertyAdapter.class);
                    if (interiorBridgeRoom.getObject() != null)
                        object.getBridgeRooms().add(new BridgeRoomMember(interiorBridgeRoom.getObject()));
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.INTERIOR_BRIDGE_ROOM, interiorBridgeRoom);
                    return;
                case "consistsOfBridgePart":
                    BridgePartProperty consistsOfBridgePart = reader.getObjectUsingBuilder(BridgePartPropertyAdapter.class);
                    if (consistsOfBridgePart.getObject() != null && object instanceof Bridge)
                        ((Bridge) object).getBridgeParts().add(consistsOfBridgePart);
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.CONSISTS_OF_BRIDGE_PART, consistsOfBridgePart);
                    return;
                case "address":
                    object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractBridge> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractBridge.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractBridge().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfAbstractBridge().add(GenericADEPropertyOfAbstractBridge.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, bridgeNamespace, namespaces, writer);

        if (object.getDateOfConstruction() != null)
            writer.writeElement(Element.of(bridgeNamespace, "yearOfConstruction").addTextContent(TextContent.ofGYear(OffsetDateTime.of(object.getDateOfConstruction(), LocalTime.MIN, ZoneOffset.UTC))));

        if (object.getDateOfDemolition() != null)
            writer.writeElement(Element.of(bridgeNamespace, "yearOfDemolition").addTextContent(TextContent.ofGYear(OffsetDateTime.of(object.getDateOfDemolition(), LocalTime.MIN, ZoneOffset.UTC))));

        if (object.isSetIsMovable())
            writer.writeElement(Element.of(bridgeNamespace, "isMovable").addTextContent(TextContent.ofBoolean(object.getIsMovable())));

        if (object.getLod1Solid() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1Solid"), object.getLod1Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getLod1TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1TerrainIntersection"), object.getLod1TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod2Solid() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2Solid"), object.getLod2Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod2MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod2MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2MultiCurve"), object.getLod2MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod2TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2TerrainIntersection"), object.getLod2TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        for (BridgeConstructiveElementMember member : object.getBridgeConstructiveElements())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "outerBridgeConstruction"), member, BridgeConstructiveElementMemberAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.OUTER_BRIDGE_CONSTRUCTION)) {
            for (BridgeConstructiveElementProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.OUTER_BRIDGE_CONSTRUCTION, BridgeConstructiveElementProperty.class))
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "outerBridgeConstruction"), property, BridgeConstructiveElementPropertyAdapter.class, namespaces);
        }

        for (BridgeInstallationMember member : object.getBridgeInstallations()) {
            if (member.getObject() != null && !member.getObject().getLocalProperties().getAndCompare(DeprecatedProperties.INT_BRIDGE_INSTALLATION, true))
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "outerBridgeInstallation"), member, BridgeInstallationMemberAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.OUTER_BRIDGE_INSTALLATION)) {
            for (BridgeInstallationProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.OUTER_BRIDGE_INSTALLATION, BridgeInstallationProperty.class))
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "outerBridgeInstallation"), property, BridgeInstallationPropertyAdapter.class, namespaces);
        }

        for (BridgeInstallationMember member : object.getBridgeInstallations()) {
            if (member.getObject() != null && member.getObject().getLocalProperties().getAndCompare(DeprecatedProperties.INT_BRIDGE_INSTALLATION, true))
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "interiorBridgeInstallation"), member, BridgeInstallationMemberAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.INTERIOR_BRIDGE_INSTALLATION)) {
            for (BridgeInstallationProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.INTERIOR_BRIDGE_INSTALLATION, BridgeInstallationProperty.class))
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "interiorBridgeInstallation"), property, BridgeInstallationPropertyAdapter.class, namespaces);
        }

        for (AbstractThematicSurfaceProperty property : object.getBoundarySurfaces())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "boundedBy"), property, AbstractThematicSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3Solid() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3MultiCurve"), object.getLod3MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod3TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_SOLID)) {
            SolidProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_SOLID, SolidProperty.class);
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4Solid"), property, SolidPropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_CURVE)) {
            MultiCurveProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_CURVE, MultiCurveProperty.class);
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4MultiCurve"), property, MultiCurvePropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().getLod4TerrainIntersectionCurve() != null) {
            MultiCurveProperty property = object.getDeprecatedProperties().getLod4TerrainIntersectionCurve();
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4TerrainIntersection"), property, MultiCurvePropertyAdapter.class, namespaces);
        }

        for (BridgeRoomMember member : object.getBridgeRooms())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "interiorBridgeRoom"), member, BridgeRoomMemberAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.INTERIOR_BRIDGE_ROOM)) {
            for (BridgeRoomProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.INTERIOR_BRIDGE_ROOM, BridgeRoomProperty.class))
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "interiorBridgeRoom"), property, BridgeRoomPropertyAdapter.class, namespaces);
        }

        if (object instanceof Bridge) {
            for (BridgePartProperty property : ((Bridge) object).getBridgeParts())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "consistsOfBridgePart"), property, BridgePartPropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.CONSISTS_OF_BRIDGE_PART)) {
            for (BridgePartProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.CONSISTS_OF_BRIDGE_PART, BridgePartProperty.class))
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "consistsOfBridgePart"), property, BridgePartPropertyAdapter.class, namespaces);
        }

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (ADEPropertyOfAbstractBridge property : object.getADEPropertiesOfAbstractBridge())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
