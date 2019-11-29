package org.citygml4j.adapter.xml.vegetation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.ImplicitGeometryPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfSolitaryVegetationObject;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.vegetation.ADEPropertyOfSolitaryVegetationObject;
import org.citygml4j.model.vegetation.SolitaryVegetationObject;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.adapter.measures.LengthAdapter;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
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
        @XMLElement(name = "SolitaryVegetationObject", namespaceURI = CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE),
        @XMLElement(name = "SolitaryVegetationObject", namespaceURI = CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE),
        @XMLElement(name = "SolitaryVegetationObject", namespaceURI = CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE)
})
public class SolitaryVegetationObjectAdapter extends AbstractVegetationObjectAdapter<SolitaryVegetationObject> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE, "AbstractGenericApplicationPropertyOfSolitaryVegetationObject"),
            new QName(CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfSolitaryVegetationObject"),
            new QName(CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfSolitaryVegetationObject")
    };

    @Override
    public SolitaryVegetationObject createObject(QName name) throws ObjectBuildException {
        return new SolitaryVegetationObject();
    }

    @Override
    public void buildChildObject(SolitaryVegetationObject object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isVegetationNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "species":
                    object.setSpecies(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "height":
                    object.setHeight(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "trunkDiameter":
                    object.setTrunkDiameter(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "crownDiameter":
                    object.setCrownDiameter(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "rootBallDiameter":
                    object.setRootBallDiameter(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "maxRootBallDepth":
                    object.setMaxRootBallDepth(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
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
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(SolitaryVegetationObject object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfSolitaryVegetationObject.class, object.getADEPropertiesOfSolitaryVegetationObject(),
                GenericADEPropertyOfSolitaryVegetationObject::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(SolitaryVegetationObject object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getVegetationNamespace(namespaces), "SolitaryVegetationObject");
    }

    @Override
    public void writeChildElements(SolitaryVegetationObject object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String vegetationNamespace = CityGMLSerializerHelper.getVegetationNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE.equals(vegetationNamespace);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, vegetationNamespace, namespaces, writer);

        if (object.getSpecies() != null)
            writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "species"), object.getSpecies(), CodeAdapter.class, namespaces);

        if (object.getHeight() != null)
            writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "height"), object.getHeight(), LengthAdapter.class, namespaces);

        if (object.getTrunkDiameter() != null)
            writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "trunkDiameter"), object.getTrunkDiameter(), LengthAdapter.class, namespaces);

        if (object.getCrownDiameter() != null)
            writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "crownDiameter"), object.getCrownDiameter(), LengthAdapter.class, namespaces);

        if (isCityGML3) {
            if (object.getRootBallDiameter() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "rootBallDiameter"), object.getRootBallDiameter(), LengthAdapter.class, namespaces);

            if (object.getMaxRootBallDepth() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "maxRootBallDepth"), object.getMaxRootBallDepth(), LengthAdapter.class, namespaces);
        }

        if (!isCityGML3) {
            if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_GEOMETRY)) {
                GeometryProperty<?> property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod1Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 1, "lod1Geometry", vegetationNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().containsGeometry(2, DeprecatedProperties.LOD2_GEOMETRY)) {
                GeometryProperty<?> property = object.getDeprecatedProperties().getGeometry(2, DeprecatedProperties.LOD2_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod2Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 2, "lod2Geometry", vegetationNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().containsGeometry(3, DeprecatedProperties.LOD3_GEOMETRY)) {
                GeometryProperty<?> property = object.getDeprecatedProperties().getGeometry(3, DeprecatedProperties.LOD3_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod3Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            } else
                CityGMLSerializerHelper.serializeDefaultGeometry(object, 3, "lod3Geometry", vegetationNamespace, namespaces, writer);

            if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_GEOMETRY)) {
                GeometryProperty<?> property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod4Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLod1ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod1ImplicitRepresentation"), object.getLod1ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod2ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod2ImplicitRepresentation"), object.getLod2ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getLod3ImplicitRepresentation() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod3ImplicitRepresentation"), object.getLod3ImplicitRepresentation(), ImplicitGeometryPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4ImplicitRepresentation() != null) {
                ImplicitGeometryProperty property = object.getDeprecatedProperties().getLod4ImplicitRepresentation();
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod4ImplicitRepresentation"), property, ImplicitGeometryPropertyAdapter.class, namespaces);
            }
        }

        for (ADEPropertyOfSolitaryVegetationObject<?> property : object.getADEPropertiesOfSolitaryVegetationObject())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
