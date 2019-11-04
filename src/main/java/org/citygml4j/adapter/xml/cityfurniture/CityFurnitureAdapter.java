package org.citygml4j.adapter.xml.cityfurniture;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.adapter.xml.core.ImplicitGeometryPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfCityFurniture;
import org.citygml4j.model.cityfurniture.ADEPropertyOfCityFurniture;
import org.citygml4j.model.cityfurniture.CityFurniture;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
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
        @XMLElement(name = "CityFurniture", namespaceURI = CityGMLConstants.CITYGML_3_0_CITYFURNITURE_NAMESPACE),
        @XMLElement(name = "CityFurniture", namespaceURI = CityGMLConstants.CITYGML_2_0_CITYFURNITURE_NAMESPACE),
        @XMLElement(name = "CityFurniture", namespaceURI = CityGMLConstants.CITYGML_1_0_CITYFURNITURE_NAMESPACE)
})
public class CityFurnitureAdapter extends AbstractOccupiedSpaceAdapter<CityFurniture> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_CITYFURNITURE_NAMESPACE, "AbstractGenericApplicationPropertyOfCityFurniture"),
            new QName(CityGMLConstants.CITYGML_2_0_CITYFURNITURE_NAMESPACE, "_GenericApplicationPropertyOfCityFurniture"),
            new QName(CityGMLConstants.CITYGML_1_0_CITYFURNITURE_NAMESPACE, "_GenericApplicationPropertyOfCityFurniture")
    };

    @Override
    public CityFurniture createObject(QName name) throws ObjectBuildException {
        return new CityFurniture();
    }

    @Override
    public void buildChildObject(CityFurniture object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLCityFurnitureNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "lod1Geometry":
                    GeometryProperty lod1Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 1, lod1Geometry))
                        object.getDeprecatedProperties().addGeometry(1, DeprecatedProperties.LOD1_GEOMETRY, lod1Geometry);
                    return;
                case "lod2Geometry":
                    GeometryProperty lod2Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 2, lod2Geometry))
                        object.getDeprecatedProperties().addGeometry(2, DeprecatedProperties.LOD2_GEOMETRY, lod2Geometry);
                    return;
                case "lod3Geometry":
                    GeometryProperty lod3Geometry = reader.getObjectUsingBuilder(GeometryPropertyAdapter.class);
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
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfCityFurniture> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfCityFurniture.class);
            if (builder != null)
                object.getADEPropertiesOfCityFurniture().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfCityFurniture().add(GenericADEPropertyOfCityFurniture.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CityFurniture object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getCityFurnitureNamespace(namespaces), "CityFurniture");
    }

    @Override
    public void writeChildElements(CityFurniture object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String cityFurnitureNamespace = CityGMLSerializerHelper.getCityFurnitureNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, cityFurnitureNamespace, namespaces, writer);

        if (!CityGMLConstants.CITYGML_3_0_CITYFURNITURE_NAMESPACE.equals(cityFurnitureNamespace)) {
            if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_GEOMETRY)) {
                GeometryProperty property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod1Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 1, "lod1Geometry", cityFurnitureNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().containsGeometry(2, DeprecatedProperties.LOD2_GEOMETRY)) {
                GeometryProperty property = object.getDeprecatedProperties().getGeometry(2, DeprecatedProperties.LOD2_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod2Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 2, "lod2Geometry", cityFurnitureNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().containsGeometry(3, DeprecatedProperties.LOD3_GEOMETRY)) {
                GeometryProperty property = object.getDeprecatedProperties().getGeometry(3, DeprecatedProperties.LOD3_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod3Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 3, "lod3Geometry", cityFurnitureNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_GEOMETRY)) {
                GeometryProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod4Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLod1TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod1TerrainIntersection"), object.getLod1TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod2TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod2TerrainIntersection"), object.getLod2TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod3TerrainIntersectionCurve() != null)
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4TerrainIntersectionCurve() != null) {
                MultiCurveProperty property = object.getDeprecatedProperties().getLod4TerrainIntersectionCurve();
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod4TerrainIntersection"), property, MultiCurvePropertyAdapter.class, namespaces);
            }

            if (object.getLod1ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod1ImplicitRepresentation"), object.getLod1ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod2ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod2ImplicitRepresentation"), object.getLod2ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod3ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod3ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4ImplicitRepresentation() != null) {
                ImplicitGeometryProperty property = object.getDeprecatedProperties().getLod4ImplicitRepresentation();
                writer.writeElementUsingSerializer(Element.of(cityFurnitureNamespace, "lod4ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
            }
        }

        for (ADEPropertyOfCityFurniture property : object.getADEPropertiesOfCityFurniture())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
