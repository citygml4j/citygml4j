package org.citygml4j.adapter.xml.bridge;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.construction.AbstractConstructiveElementAdapter;
import org.citygml4j.adapter.xml.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.adapter.xml.core.ImplicitGeometryPropertyAdapter;
import org.citygml4j.adapter.xml.deprecated.bridge.AbstractBoundarySurfacePropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBridgeConstructiveElement;
import org.citygml4j.model.bridge.ADEPropertyOfBridgeConstructiveElement;
import org.citygml4j.model.bridge.BridgeConstructiveElement;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "BridgeConstructiveElement", namespaceURI = CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE),
        @XMLElement(name = "BridgeConstructionElement", namespaceURI = CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE)
})
public class BridgeConstructiveElementAdapter extends AbstractConstructiveElementAdapter<BridgeConstructiveElement> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE, "AbstractGenericApplicationPropertyOfBridgeConstructiveElement"),
            new QName(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE, "_GenericApplicationPropertyOfBridgeConstructionElement")
    };

    @Override
    public BridgeConstructiveElement createObject(QName name) throws ObjectBuildException {
        return new BridgeConstructiveElement();
    }

    @Override
    public void buildChildObject(BridgeConstructiveElement object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBridgeNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod1Geometry":
                    GeometryProperty<?> lod1Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 1, lod1Geometry))
                        object.getDeprecatedProperties().addGeometry(1, DeprecatedProperties.LOD1_GEOMETRY, lod1Geometry);
                    return;
                case "lod2Geometry":
                    GeometryProperty<?> lod2Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 2, lod2Geometry))
                        object.getDeprecatedProperties().addGeometry(2, DeprecatedProperties.LOD2_GEOMETRY, lod2Geometry);
                    return;
                case "lod3Geometry":
                    GeometryProperty<?> lod3Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 3, lod3Geometry))
                        object.getDeprecatedProperties().addGeometry(3, DeprecatedProperties.LOD3_GEOMETRY, lod3Geometry);
                    return;
                case "lod4Geometry":
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod1TerrainIntersection":
                    object.setLod1TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod2TerrainIntersection":
                    object.setLod2TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod3TerrainIntersection":
                    object.setLod3TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod4TerrainIntersection":
                    object.getDeprecatedProperties().setLod4TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod1ImplicitRepresentation":
                    object.setLod1ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "lod2ImplicitRepresentation":
                    object.setLod2ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "lod3ImplicitRepresentation":
                    object.setLod3ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "lod4ImplicitRepresentation":
                    object.getDeprecatedProperties().setLod4ImplicitRepresentation(reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(BridgeConstructiveElement object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfBridgeConstructiveElement.class, object.getADEPropertiesOfBridgeConstructiveElement(),
                GenericADEPropertyOfBridgeConstructiveElement::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(BridgeConstructiveElement object, Namespaces namespaces) throws ObjectSerializeException {
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(bridgeNamespace) ?
                Element.of(bridgeNamespace, "BridgeConstructiveElement") :
                Element.of(bridgeNamespace, "BridgeConstructionElement");
    }

    @Override
    public void writeChildElements(BridgeConstructiveElement object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String bridgeNamespace = CityGMLSerializerHelper.getBridgeNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, bridgeNamespace, namespaces, writer);

        if (!CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(bridgeNamespace)) {
            if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_GEOMETRY)) {
                GeometryProperty<?> property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 1, "lod1Geometry", bridgeNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().containsGeometry(2, DeprecatedProperties.LOD2_GEOMETRY)) {
                GeometryProperty<?> property = object.getDeprecatedProperties().getGeometry(2, DeprecatedProperties.LOD2_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 2, "lod2Geometry", bridgeNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().containsGeometry(3, DeprecatedProperties.LOD3_GEOMETRY)) {
                GeometryProperty<?> property = object.getDeprecatedProperties().getGeometry(3, DeprecatedProperties.LOD3_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 3, "lod3Geometry", bridgeNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_GEOMETRY)) {
                GeometryProperty<?> property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLod1TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1TerrainIntersection"), object.getLod1TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod2TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2TerrainIntersection"), object.getLod2TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod3TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4TerrainIntersectionCurve() != null) {
                MultiCurveProperty property = object.getDeprecatedProperties().getLod4TerrainIntersectionCurve();
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4TerrainIntersection"), property, MultiCurvePropertyAdapter.class, namespaces);
            }

            if (object.getLod1ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod1ImplicitRepresentation"), object.getLod1ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod2ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod2ImplicitRepresentation"), object.getLod2ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod3ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod3ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4ImplicitRepresentation() != null) {
                ImplicitGeometryProperty property = object.getDeprecatedProperties().getLod4ImplicitRepresentation();
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "lod4ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
            }

            for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                writer.writeElementUsingSerializer(Element.of(bridgeNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfBridgeConstructiveElement<?> property : object.getADEPropertiesOfBridgeConstructiveElement())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
