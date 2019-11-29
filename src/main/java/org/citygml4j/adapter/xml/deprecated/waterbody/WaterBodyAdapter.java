package org.citygml4j.adapter.xml.deprecated.waterbody;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractCityObjectAdapter;
import org.citygml4j.adapter.xml.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfWaterBody;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.waterbody.ADEPropertyOfWaterBody;
import org.citygml4j.model.waterbody.WaterBody;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
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

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "WaterBody", namespaceURI = CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE),
        @XMLElement(name = "WaterBody", namespaceURI = CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE)
})
public class WaterBodyAdapter extends AbstractCityObjectAdapter<WaterBody> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterObject"),
            new QName(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBody"),
            new QName(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterObject"),
            new QName(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBody")
    };

    @Override
    public WaterBody createObject(QName name) throws ObjectBuildException {
        return new WaterBody();
    }

    @Override
    public void buildChildObject(WaterBody object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isWaterBodyNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "boundedBy":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
                case "lod0MultiCurve":
                    object.setLod0MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod0MultiSurface":
                    object.setLod0MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1MultiCurve":
                    object.getDeprecatedProperties().addGeometry(1, DeprecatedProperties.LOD1_MULTI_CURVE, reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.getDeprecatedProperties().addGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
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
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_SOLID, reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(WaterBody object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfWaterBody.class, object.getADEPropertiesOfWaterBody(),
                GenericADEPropertyOfWaterBody::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(WaterBody object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getWaterBodyNamespace(namespaces), "WaterBody");
    }

    @Override
    public void writeChildElements(WaterBody object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String waterBodyNamespace = CityGMLSerializerHelper.getWaterBodyNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, waterBodyNamespace, namespaces, writer);

        if (object.getLod0MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod0MultiCurve"), object.getLod0MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod0MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod0MultiSurface"), object.getLod0MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_MULTI_CURVE)) {
            MultiCurveProperty property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_MULTI_CURVE, MultiCurveProperty.class);
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod1MultiCurve"), property, MultiCurvePropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod1MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getLod1Solid() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod1Solid"), object.getLod1Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod2Solid() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod2Solid"), object.getLod2Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod3Solid() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_SOLID)) {
            SolidProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_SOLID, SolidProperty.class);
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod4Solid"), property, SolidPropertyAdapter.class, namespaces);
        }

        for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "boundedBy"), property, AbstractWaterBoundarySurfacePropertyAdapter.class, namespaces);

        for (ADEPropertyOfWaterBody<?> property : object.getADEPropertiesOfWaterBody())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
