package org.citygml4j.adapter.xml.vegetation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfPlantCover;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.vegetation.ADEPropertyOfPlantCover;
import org.citygml4j.model.vegetation.PlantCover;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSolidPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.measures.LengthAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolid;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolidProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "PlantCover", namespaceURI = CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE),
        @XMLElement(name = "PlantCover", namespaceURI = CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE),
        @XMLElement(name = "PlantCover", namespaceURI = CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE)
})
public class PlantCoverAdapter extends AbstractVegetationObjectAdapter<PlantCover> {
    private final CopyBuilder copyBuilder = new CopyBuilder();
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE, "AbstractGenericApplicationPropertyOfPlantCover"),
            new QName(CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfPlantCover"),
            new QName(CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE, "_GenericApplicationPropertyOfPlantCover")
    };

    @Override
    public PlantCover createObject(QName name) throws ObjectBuildException {
        return new PlantCover();
    }

    @Override
    public void buildChildObject(PlantCover object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isVegetationNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "averageHeight":
                    object.setAverageHeight(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "minHeight":
                    object.setMinHeight(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "maxHeight":
                    object.setMaxHeight(reader.getObjectUsingBuilder(LengthAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.getDeprecatedProperties().addGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod2MultiSurface":
                    object.setLod2MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1MultiSolid":
                    MultiSolidProperty lod1MultiSolid = reader.getObjectUsingBuilder(MultiSolidPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 1, lod1MultiSolid))
                        object.getDeprecatedProperties().addGeometry(1, DeprecatedProperties.LOD1_MULTI_SOLID, lod1MultiSolid);
                    return;
                case "lod2MultiSolid":
                    MultiSolidProperty lod2MultiSolid = reader.getObjectUsingBuilder(MultiSolidPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 2, lod2MultiSolid))
                        object.getDeprecatedProperties().addGeometry(2, DeprecatedProperties.LOD2_MULTI_SOLID, lod2MultiSolid);
                    return;
                case "lod3MultiSolid":
                    MultiSolidProperty lod3MultiSolid = reader.getObjectUsingBuilder(MultiSolidPropertyAdapter.class);
                    if (!CityGMLBuilderHelper.assignDefaultGeometry(object, 3, lod3MultiSolid))
                        object.getDeprecatedProperties().addGeometry(3, DeprecatedProperties.LOD3_MULTI_SOLID, lod3MultiSolid);
                    return;
                case "lod4MultiSolid":
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_MULTI_SOLID, reader.getObjectUsingBuilder(MultiSolidPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(PlantCover object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfPlantCover.class, object.getADEPropertiesOfPlantCover(),
                GenericADEPropertyOfPlantCover::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(PlantCover object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getVegetationNamespace(namespaces), "PlantCover");
    }

    @Override
    public void writeChildElements(PlantCover object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String vegetationNamespace = CityGMLSerializerHelper.getVegetationNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE.equals(vegetationNamespace);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, vegetationNamespace, namespaces, writer);

        if (object.getAverageHeight() != null)
            writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "averageHeight"), object.getAverageHeight(), LengthAdapter.class, namespaces);

        if (isCityGML3) {
            if (object.getMinHeight() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "minHeight"), object.getMinHeight(), LengthAdapter.class, namespaces);

            if (object.getMaxHeight() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "maxHeight"), object.getMaxHeight(), LengthAdapter.class, namespaces);
        }

        if (!isCityGML3) {
            if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE)) {
                MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, MultiSurfaceProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod1MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
            }

            if (object.getLod2MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE)) {
                MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, MultiSurfaceProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod4MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
            }

            if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_MULTI_SOLID)) {
                MultiSolidProperty property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_MULTI_SOLID, MultiSolidProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod1MultiSolid"), property, MultiSolidPropertyAdapter.class, namespaces);
            } else if (object.getLod1Solid() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod1MultiSolid"), getMultiSolidProperty(object.getLod1Solid()), MultiSolidPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().containsGeometry(2, DeprecatedProperties.LOD2_MULTI_SOLID)) {
                MultiSolidProperty property = object.getDeprecatedProperties().getGeometry(2, DeprecatedProperties.LOD2_MULTI_SOLID, MultiSolidProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod2MultiSolid"), property, MultiSolidPropertyAdapter.class, namespaces);
            } else if (object.getLod2Solid() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod2MultiSolid"), getMultiSolidProperty(object.getLod2Solid()), MultiSolidPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().containsGeometry(3, DeprecatedProperties.LOD3_MULTI_SOLID)) {
                MultiSolidProperty property = object.getDeprecatedProperties().getGeometry(3, DeprecatedProperties.LOD3_MULTI_SOLID, MultiSolidProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod3MultiSolid"), property, MultiSolidPropertyAdapter.class, namespaces);
            } else if (object.getLod3Solid() != null)
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod3MultiSolid"), getMultiSolidProperty(object.getLod3Solid()), MultiSolidPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_SOLID)) {
                MultiSolidProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_SOLID, MultiSolidProperty.class);
                writer.writeElementUsingSerializer(Element.of(vegetationNamespace, "lod4MultiSolid"), property, MultiSolidPropertyAdapter.class, namespaces);
            }
        }

        for (ADEPropertyOfPlantCover<?> property : object.getADEPropertiesOfPlantCover())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }

    private MultiSolidProperty getMultiSolidProperty(SolidProperty src) {
        MultiSolid multiSolid = new MultiSolid();
        multiSolid.getSolidMember().add(src);
        return new MultiSolidProperty(multiSolid);
    }
}
