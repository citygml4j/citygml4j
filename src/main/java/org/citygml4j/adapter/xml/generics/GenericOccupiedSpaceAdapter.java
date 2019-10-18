package org.citygml4j.adapter.xml.generics;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.adapter.xml.core.ImplicitGeometryPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfGenericOccupiedSpace;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.generics.ADEPropertyOfGenericOccupiedSpace;
import org.citygml4j.model.generics.GenericOccupiedSpace;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
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
        @XMLElement(name = "GenericOccupiedSpace", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE),
        @XMLElement(name = "GenericCityObject", namespaceURI = CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE),
        @XMLElement(name = "GenericCityObject", namespaceURI = CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE)
})
public class GenericOccupiedSpaceAdapter extends AbstractOccupiedSpaceAdapter<GenericOccupiedSpace> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "AbstractGenericApplicationPropertyOfGenericOccupiedSpace");

    @Override
    public GenericOccupiedSpace createObject(QName name) {
        return new GenericOccupiedSpace();
    }

    @Override
    public void buildChildObject(GenericOccupiedSpace object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLGenericsNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod0Geometry":
                    object.getLocalProperties().set(DeprecatedProperties.LOD0_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod1Geometry":
                    object.getLocalProperties().set(DeprecatedProperties.LOD1_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod2Geometry":
                    object.getLocalProperties().set(DeprecatedProperties.LOD2_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod3Geometry":
                    object.getLocalProperties().set(DeprecatedProperties.LOD3_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod4Geometry":
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_GEOMETRY, reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "lod0TerrainIntersection":
                    object.getLocalProperties().set(DeprecatedProperties.LOD0_TERRAIN_INTERSECTION, reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
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
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_TERRAIN_INTERSECTION, reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod0ImplicitRepresentation":
                    object.getLocalProperties().set(DeprecatedProperties.LOD0_IMPLICIT_REPRESENTATION, reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
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
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_IMPLICIT_REPRESENTATION, reader.getObjectUsingBuilder(ImplicitGeometryPropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfGenericOccupiedSpace> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfGenericOccupiedSpace.class);
            if (builder != null)
                object.getADEPropertiesOfGenericOccupiedSpace().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfGenericOccupiedSpace().add(GenericADEPropertyOfGenericOccupiedSpace.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(GenericOccupiedSpace object, Namespaces namespaces) {
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace) ?
                Element.of(genericsNamespace, "GenericOccupiedSpace") :
                Element.of(genericsNamespace, "GenericCityObject");
    }

    @Override
    public void writeChildElements(GenericOccupiedSpace object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, genericsNamespace, namespaces, writer);

        if (!CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace)) {
            if (object.getLocalProperties().contains(DeprecatedProperties.LOD0_GEOMETRY)) {
                GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD0_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod0Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD1_GEOMETRY)) {
                GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD1_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod1Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD2_GEOMETRY)) {
                GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD2_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod2Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD3_GEOMETRY)) {
                GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD3_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod3Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_GEOMETRY)) {
                GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod4Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD0_TERRAIN_INTERSECTION)) {
                MultiCurveProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD0_TERRAIN_INTERSECTION, MultiCurveProperty.class);
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod0TerrainIntersection"), property, MultiCurvePropertyAdapter.class, namespaces);
            }

            if (object.getLod1TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod1TerrainIntersection"), object.getLod1TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod2TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod2TerrainIntersection"), object.getLod2TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod3TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_TERRAIN_INTERSECTION)) {
                MultiCurveProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_TERRAIN_INTERSECTION, MultiCurveProperty.class);
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod4TerrainIntersection"), property, MultiCurvePropertyAdapter.class, namespaces);
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD0_IMPLICIT_REPRESENTATION)) {
                ImplicitGeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD0_IMPLICIT_REPRESENTATION, ImplicitGeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod0ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLod1ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod1ImplicitRepresentation"), object.getLod1ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod2ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod2ImplicitRepresentation"), object.getLod2ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod3ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod3ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_IMPLICIT_REPRESENTATION)) {
                ImplicitGeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_IMPLICIT_REPRESENTATION, ImplicitGeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "lod4ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
            }
        } else {
            for (ADEPropertyOfGenericOccupiedSpace property : object.getADEPropertiesOfGenericOccupiedSpace())
                CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
        }
    }
}
