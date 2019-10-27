package org.citygml4j.adapter.xml.waterbody;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfacePropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfWaterBody;
import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.waterbody.ADEPropertyOfWaterBody;
import org.citygml4j.model.waterbody.WaterBody;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
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

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "WaterBody", namespaceURI = CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE),
        @XMLElement(name = "WaterBody", namespaceURI = CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE),
        @XMLElement(name = "WaterBody", namespaceURI = CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE)
})
public class WaterBodyAdapter extends AbstractOccupiedSpaceAdapter<WaterBody> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "AbstractGenericApplicationPropertyOfWaterBody"),
            new QName(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterObject"),
            new QName(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBody"),
            new QName(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterObject"),
            new QName(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBody"),
    };

    @Override
    public WaterBody createObject(QName name) {
        return new WaterBody();
    }

    @Override
    public void buildChildObject(WaterBody object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLWaterBodyNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "boundedBy":
                    object.addBoundarySurface(reader.getObjectUsingBuilder(AbstractThematicSurfacePropertyAdapter.class));
                    return;
                case "lod0MultiCurve":
                    object.getLocalProperties().set(DeprecatedProperties.LOD0_MULTI_CURVE, reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod0MultiSurface":
                    object.setLod0MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1MultiCurve":
                    object.getLocalProperties().set(DeprecatedProperties.LOD1_MULTI_CURVE, reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.getLocalProperties().set(DeprecatedProperties.LOD1_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1Solid":
                    object.setLod1Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod2Solid":
                    object.setLod2Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod3Solid":
                    object.setLod3Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4Solid":
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_SOLID, reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfWaterBody> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfWaterBody.class);
            if (builder != null)
                object.getADEPropertiesOfWaterBody().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfWaterBody().add(GenericADEPropertyOfWaterBody.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(WaterBody object, Namespaces namespaces) {
        return Element.of(CityGMLSerializerHelper.getWaterBodyNamespace(namespaces), "WaterBody");
    }

    @Override
    public void writeChildElements(WaterBody object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String waterBodyNamespace = CityGMLSerializerHelper.getWaterBodyNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, waterBodyNamespace, namespaces, writer);

        if (!CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE.equals(waterBodyNamespace)) {
            if (object.getLocalProperties().contains(DeprecatedProperties.LOD0_MULTI_CURVE)) {
                MultiCurveProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD0_MULTI_CURVE, MultiCurveProperty.class);
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod0MultiCurve"), property, MultiCurvePropertyAdapter.class, namespaces);
            }

            if (object.getLod0MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod0MultiSurface"), object.getLod0MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD1_MULTI_CURVE)) {
                MultiCurveProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD1_MULTI_CURVE, MultiCurveProperty.class);
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod1MultiCurve"), property, MultiCurvePropertyAdapter.class, namespaces);
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD1_MULTI_SURFACE)) {
                MultiSurfaceProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD1_MULTI_SURFACE, MultiSurfaceProperty.class);
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod1MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
            }

            if (object.getLod1Solid() != null)
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod1Solid"), object.getLod1Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getLod2Solid() != null)
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod2Solid"), object.getLod2Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getLod3Solid() != null)
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_SOLID)) {
                SolidProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_SOLID, SolidProperty.class);
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod4Solid"), property, SolidPropertyAdapter.class, namespaces);
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD3_GEOMETRY)) {
                GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD3_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod3Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_GEOMETRY)) {
                GeometryProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_GEOMETRY, GeometryProperty.class);
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod4Geometry"), property, GeometryPropertyAdapter.class, namespaces);
            }

            for (AbstractThematicSurfaceProperty property : object.getBoundarySurfaces())
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "boundedBy"), property, AbstractThematicSurfacePropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfWaterBody property : object.getADEPropertiesOfWaterBody())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
