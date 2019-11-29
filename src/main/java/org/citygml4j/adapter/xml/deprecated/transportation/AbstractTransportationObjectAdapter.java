package org.citygml4j.adapter.xml.deprecated.transportation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractCityObjectAdapter;
import org.citygml4j.adapter.xml.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractTransportationSpace;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.transportation.ADEPropertyOfAbstractTransportationSpace;
import org.citygml4j.model.transportation.AbstractTransportationSpace;
import org.citygml4j.model.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.transportation.AuxiliaryTrafficSpace;
import org.citygml4j.model.transportation.AuxiliaryTrafficSpaceProperty;
import org.citygml4j.model.transportation.GranularityValue;
import org.citygml4j.model.transportation.TrafficArea;
import org.citygml4j.model.transportation.TrafficSpace;
import org.citygml4j.model.transportation.TrafficSpaceProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.complexes.GeometricComplexPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.complexes.CompositeCurve;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplexProperty;
import org.xmlobjects.gml.model.geometry.primitives.AbstractCurve;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;
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
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTransportationObjectAdapter<T extends AbstractTransportationSpace> extends AbstractCityObjectAdapter<T> {
    private final CopyBuilder copyBuilder = new CopyBuilder();
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfTransportationObject"),
            new QName(CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfTransportationObject")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isTransportationNamespace(name.getNamespaceURI())) {
            if (object instanceof StandardObjectClassifier
                    && CityGMLBuilderHelper.buildStandardObjectClassifier((StandardObjectClassifier) object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "trafficArea":
                    AbstractSpaceBoundaryProperty trafficArea = reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class);
                    TrafficSpace trafficSpace = new TrafficSpace(GranularityValue.WAY);
                    trafficSpace.addBoundary(trafficArea);
                    object.getTrafficSpaces().add(new TrafficSpaceProperty(trafficSpace));
                    return;
                case "auxiliaryTrafficArea":
                    AbstractSpaceBoundaryProperty auxiliaryTrafficArea = reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class);
                    AuxiliaryTrafficSpace auxiliaryTrafficSpace = new AuxiliaryTrafficSpace(GranularityValue.WAY);
                    auxiliaryTrafficSpace.addBoundary(auxiliaryTrafficArea);
                    object.getAuxiliaryTrafficSpaces().add(new AuxiliaryTrafficSpaceProperty(auxiliaryTrafficSpace));
                    return;
                case "lod0Network":
                    GeometricComplexProperty property = reader.getObjectUsingBuilder(GeometricComplexPropertyAdapter.class);
                    if (property.isSetCompositeCurve())
                        object.setLod0MultiCurve(getMultiCurveProperty(property.getCompositeCurve()));
                    else
                        object.getDeprecatedProperties().addGeometry(0, DeprecatedProperties.LOD0_NETWORK, property);
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
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractTransportationSpace.class, object.getADEPropertiesOfAbstractTransportationSpace(),
                GenericADEPropertyOfAbstractTransportationSpace::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String transportationNamespace = CityGMLSerializerHelper.getTransportationNamespace(namespaces);

        if (object instanceof StandardObjectClassifier)
            CityGMLSerializerHelper.serializeStandardObjectClassifier((StandardObjectClassifier) object, transportationNamespace, namespaces, writer);

        for (TrafficSpaceProperty property : object.getTrafficSpaces()) {
            if (property.getObject() != null) {
                TrafficSpace trafficSpace = property.getObject();
                for (AbstractSpaceBoundaryProperty boundary : trafficSpace.getBoundaries()) {
                    if (boundary.getObject() == null || boundary.getObject() instanceof TrafficArea)
                        writer.writeElementUsingSerializer(Element.of(transportationNamespace, "trafficArea"), boundary, AbstractSpaceBoundaryPropertyAdapter.class, namespaces);
                }
            }
        }

        for (AuxiliaryTrafficSpaceProperty property : object.getAuxiliaryTrafficSpaces()) {
            if (property.getObject() != null) {
                AuxiliaryTrafficSpace auxiliaryTrafficSpace = property.getObject();
                for (AbstractSpaceBoundaryProperty boundary : auxiliaryTrafficSpace.getBoundaries()) {
                    if (boundary.getObject() == null || boundary.getObject() instanceof AuxiliaryTrafficArea)
                        writer.writeElementUsingSerializer(Element.of(transportationNamespace, "auxiliaryTrafficArea"), boundary, AbstractSpaceBoundaryPropertyAdapter.class, namespaces);
                }
            }
        }

        if (object.getDeprecatedProperties().containsGeometry(0, DeprecatedProperties.LOD0_NETWORK)) {
            GeometricComplexProperty property = object.getDeprecatedProperties().getGeometry(0, DeprecatedProperties.LOD0_NETWORK, GeometricComplexProperty.class);
            writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod0Network"), property, GeometricComplexPropertyAdapter.class, namespaces);
        } else if (object.getLod0MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod0Network"), getGeometricComplexProperty(object.getLod0MultiCurve()), GeometricComplexPropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod1MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getLod2MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod4MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfAbstractTransportationSpace<?> property : object.getADEPropertiesOfAbstractTransportationSpace())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }

    private MultiCurveProperty getMultiCurveProperty(CompositeCurve src) {
        MultiCurve multiCurve = new MultiCurve();
        multiCurve.setCurveMember(src.getCurveMembers());
        return new MultiCurveProperty(multiCurve);
    }

    private GeometricComplexProperty getGeometricComplexProperty(MultiCurveProperty src) {
        GeometricComplexProperty dest;

        if (src.getObject() != null) {
            MultiCurve multiCurve = src.getObject();

            List<CurveProperty> properties = new ArrayList<>();
            for (CurveProperty property : multiCurve.getCurveMember())
                properties.add((CurveProperty) property.shallowCopy(copyBuilder));

            if (multiCurve.getCurveMembers() != null) {
                for (AbstractCurve curve : multiCurve.getCurveMembers().getObjects())
                    properties.add(new CurveProperty((AbstractCurve) curve.shallowCopy(copyBuilder)));
            }

            if (properties.size() == 0)
                dest = new GeometricComplexProperty();
            else
                dest = new GeometricComplexProperty(new CompositeCurve(properties));
        } else
            dest = new GeometricComplexProperty();

        return dest;
    }
}
