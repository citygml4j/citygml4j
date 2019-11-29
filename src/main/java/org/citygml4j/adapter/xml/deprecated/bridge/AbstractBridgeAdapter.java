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
import org.citygml4j.adapter.xml.core.AbstractSpaceBoundaryPropertyAdapter;
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
import org.citygml4j.model.construction.RelationToConstruction;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.core.AddressProperty;
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

public abstract class AbstractBridgeAdapter<T extends AbstractBridge> extends AbstractSiteAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfAbstractBridge");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBridgeNamespace(name.getNamespaceURI())) {
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
                case "outerBridgeConstruction":
                    BridgeConstructiveElementProperty bridgeConstructiveElement = reader.getObjectUsingBuilder(BridgeConstructiveElementPropertyAdapter.class);
                    if (bridgeConstructiveElement.getObject() != null)
                        object.getBridgeConstructiveElements().add(new BridgeConstructiveElementMember(bridgeConstructiveElement.getObject()));
                    //else if (bridgeConstructiveElement.getGenericElement() != null)
                    //    object.getBridgeConstructiveElements().add(new BridgeConstructiveElementMember(bridgeConstructiveElement.getGenericElement()));
                    else
                        object.getDeprecatedProperties().getOuterBridgeConstructions().add(new Reference(bridgeConstructiveElement));
                    return;
                case "outerBridgeInstallation":
                    BridgeInstallationProperty outerBridgeInstallation = reader.getObjectUsingBuilder(BridgeInstallationPropertyAdapter.class);
                    if (outerBridgeInstallation.getObject() != null)
                        object.getBridgeInstallations().add(new BridgeInstallationMember(outerBridgeInstallation.getObject()));
                    else
                        object.getDeprecatedProperties().getOuterBridgeInstallations().add(outerBridgeInstallation);
                    return;
                case "interiorBridgeInstallation":
                    BridgeInstallationProperty interiorBridgeInstallation = reader.getObjectUsingBuilder(BridgeInstallationPropertyAdapter.class);
                    if (interiorBridgeInstallation.getObject() != null)
                        object.getBridgeInstallations().add(new BridgeInstallationMember(interiorBridgeInstallation.getObject()));
                    else
                        object.getDeprecatedProperties().getInteriorBridgeInstallations().add(interiorBridgeInstallation);
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
                case "interiorBridgeRoom":
                    BridgeRoomProperty interiorBridgeRoom = reader.getObjectUsingBuilder(BridgeRoomPropertyAdapter.class);
                    if (interiorBridgeRoom.getObject() != null)
                        object.getBridgeRooms().add(new BridgeRoomMember(interiorBridgeRoom.getObject()));
                    //else if (interiorBridgeRoom.getGenericElement() != null)
                     //   object.getBridgeRooms().add(new BridgeRoomMember(interiorBridgeRoom.getGenericElement()));
                    else
                        object.getDeprecatedProperties().getInteriorBridgeRooms().add(new Reference(interiorBridgeRoom));
                    return;
                case "consistsOfBridgePart":
                    BridgePartProperty consistsOfBridgePart = reader.getObjectUsingBuilder(BridgePartPropertyAdapter.class);
                    if ((consistsOfBridgePart.getObject() != null || consistsOfBridgePart.getGenericElement() != null) && object instanceof Bridge)
                        ((Bridge) object).getBridgeParts().add(consistsOfBridgePart);
                    else
                        object.getDeprecatedProperties().getConsistsOfBridgeParts().add(consistsOfBridgePart);
                    return;
                case "address":
                    object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
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
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractBridge.class, object.getADEPropertiesOfAbstractBridge(),
                GenericADEPropertyOfAbstractBridge::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
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

        if (object.getDeprecatedProperties().getLod1MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1MultiSurface"), object.getDeprecatedProperties().getLod1MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

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

        for (Reference reference : object.getDeprecatedProperties().getOuterBridgeConstructions())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "outerBridgeConstruction"), reference, ReferenceAdapter.class, namespaces);

        for (BridgeInstallationMember member : object.getBridgeInstallations()) {
            if (member.getObject() != null && member.getObject().getRelationToConstruction() != RelationToConstruction.INSIDE)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "outerBridgeInstallation"), member, BridgeInstallationMemberAdapter.class, namespaces);
        }

        for (BridgeInstallationProperty property : object.getDeprecatedProperties().getOuterBridgeInstallations())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "outerBridgeInstallation"), property, BridgeInstallationPropertyAdapter.class, namespaces);

        for (BridgeInstallationMember member : object.getBridgeInstallations()) {
            if (member.getObject() != null && member.getObject().getRelationToConstruction() == RelationToConstruction.INSIDE)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "interiorBridgeInstallation"), member, BridgeInstallationMemberAdapter.class, namespaces);
        }

        for (BridgeInstallationProperty property : object.getDeprecatedProperties().getInteriorBridgeInstallations())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "interiorBridgeInstallation"), property, BridgeInstallationPropertyAdapter.class, namespaces);

        for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);

        if (object.getLod3Solid() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3MultiCurve"), object.getLod3MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod3TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4Solid() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4Solid"), object.getDeprecatedProperties().getLod4Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4MultiSurface"), object.getDeprecatedProperties().getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4MultiCurve"), object.getDeprecatedProperties().getLod4MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4TerrainIntersection"), object.getDeprecatedProperties().getLod4TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        for (BridgeRoomMember member : object.getBridgeRooms())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "interiorBridgeRoom"), member, BridgeRoomMemberAdapter.class, namespaces);

        for (Reference reference : object.getDeprecatedProperties().getInteriorBridgeRooms())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "interiorBridgeRoom"), reference, ReferenceAdapter.class, namespaces);

        if (object instanceof Bridge) {
            for (BridgePartProperty property : ((Bridge) object).getBridgeParts())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "consistsOfBridgePart"), property, BridgePartPropertyAdapter.class, namespaces);
        }

        for (BridgePartProperty property : object.getDeprecatedProperties().getConsistsOfBridgeParts())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "consistsOfBridgePart"), property, BridgePartPropertyAdapter.class, namespaces);

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (ADEPropertyOfAbstractBridge<?> property : object.getADEPropertiesOfAbstractBridge())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
