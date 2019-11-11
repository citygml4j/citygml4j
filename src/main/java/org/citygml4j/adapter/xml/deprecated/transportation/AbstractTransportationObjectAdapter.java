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
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.complexes.GeometricComplexPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractTransportationObjectAdapter<T extends AbstractTransportationSpace> extends AbstractCityObjectAdapter<T> {
    private final QName[] substitutionGroups = new QName[] {
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
                    object.setNetwork(reader.getObjectUsingBuilder(GeometricComplexPropertyAdapter.class));
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
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractTransportationSpace> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractTransportationSpace.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractTransportationSpace().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfAbstractTransportationSpace().add(GenericADEPropertyOfAbstractTransportationSpace.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
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

        if (object.getNetwork() != null)
            writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod0Network"), object.getNetwork(), GeometricComplexPropertyAdapter.class, namespaces);

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

        for (ADEPropertyOfAbstractTransportationSpace property : object.getADEPropertiesOfAbstractTransportationSpace())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
