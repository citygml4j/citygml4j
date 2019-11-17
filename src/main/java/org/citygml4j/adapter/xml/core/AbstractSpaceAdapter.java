package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractSpace;
import org.citygml4j.model.core.ADEPropertyOfAbstractSpace;
import org.citygml4j.model.core.AbstractSpace;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.core.QualifiedAreaProperty;
import org.citygml4j.model.core.QualifiedVolumeProperty;
import org.citygml4j.model.core.SpaceType;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.PointPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractSpaceAdapter<T extends AbstractSpace> extends AbstractCityObjectAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractSpace");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "spaceType":
                    reader.getTextContent().ifPresent(v -> object.setSpaceType(SpaceType.fromValue(v)));
                    return;
                case "volume":
                    object.getVolumes().add(reader.getObjectUsingBuilder(QualifiedVolumePropertyAdapter.class));
                    return;
                case "area":
                    object.getAreas().add(reader.getObjectUsingBuilder(QualifiedAreaPropertyAdapter.class));
                    return;
                case "boundary":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
                case "lod0Point":
                    object.setLod0Point(reader.getObjectUsingBuilder(PointPropertyAdapter.class));
                    return;
                case "lod0MultiSurface":
                    object.setLod0MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod0MultiCurve":
                    object.setLod0MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                case "lod1Solid":
                    object.setLod1Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
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
                case "lod3Solid":
                    object.setLod3Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3MultiCurve":
                    object.setLod3MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
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
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractSpace.class, object.getADEPropertiesOfAbstractSpace(),
                GenericADEPropertyOfAbstractSpace::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            if (object.getSpaceType() != null)
                writer.writeElement(Element.of(coreNamespace, "spaceType").addTextContent(object.getSpaceType().toValue()));

            for (QualifiedVolumeProperty property : object.getVolumes())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "volume"), property, QualifiedVolumePropertyAdapter.class, namespaces);

            for (QualifiedAreaProperty property : object.getAreas())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "area"), property, QualifiedAreaPropertyAdapter.class, namespaces);

            for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "boundary"), property, AbstractSpaceBoundaryPropertyAdapter.class, namespaces);

            if (object.getLod0Point() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod0Point"), object.getLod0Point(), PointPropertyAdapter.class, namespaces);

            if (object.getLod0MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod0MultiSurface"), object.getLod0MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod0MultiCurve() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod0MultiCurve"), object.getLod0MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod1Solid() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod1Solid"), object.getLod1Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getLod2Solid() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod2Solid"), object.getLod2Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getLod2MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod2MultiCurve() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod2MultiCurve"), object.getLod2MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod3Solid() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod3MultiCurve() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod3MultiCurve"), object.getLod3MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

            for (ADEPropertyOfAbstractSpace property : object.getADEPropertiesOfAbstractSpace())
                CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
        }
    }
}
