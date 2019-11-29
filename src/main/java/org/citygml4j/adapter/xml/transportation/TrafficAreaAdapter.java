package org.citygml4j.adapter.xml.transportation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfTrafficArea;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.transportation.ADEPropertyOfTrafficArea;
import org.citygml4j.model.transportation.TrafficArea;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
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

@XMLElements({
        @XMLElement(name = "TrafficArea", namespaceURI = CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE),
        @XMLElement(name = "TrafficArea", namespaceURI = CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE),
        @XMLElement(name = "TrafficArea", namespaceURI = CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE)
})
public class TrafficAreaAdapter extends AbstractThematicSurfaceAdapter<TrafficArea> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "AbstractGenericApplicationPropertyOfTrafficArea"),
            new QName(CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfTrafficArea"),
            new QName(CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfTrafficArea")
    };

    @Override
    public TrafficArea createObject(QName name) throws ObjectBuildException {
        return new TrafficArea();
    }

    @Override
    public void buildChildObject(TrafficArea object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isTransportationNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "surfaceMaterial":
                    object.setSurfaceMaterial(reader.getObjectUsingBuilder(CodeAdapter.class));
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
    public void buildADEProperty(TrafficArea object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfTrafficArea.class, object.getADEPropertiesOfTrafficArea(),
                GenericADEPropertyOfTrafficArea::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(TrafficArea object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTransportationNamespace(namespaces), "TrafficArea");
    }

    @Override
    public void writeChildElements(TrafficArea object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String transportationNamespace = CityGMLSerializerHelper.getTransportationNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, transportationNamespace, namespaces, writer);

        if (object.getSurfaceMaterial() != null)
            writer.writeElementUsingSerializer(Element.of(transportationNamespace, "surfaceMaterial"), object.getSurfaceMaterial(), CodeAdapter.class, namespaces);

        if (!CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(transportationNamespace)) {
            if (object.getLod2MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE)) {
                MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, MultiSurfaceProperty.class);
                writer.writeElementUsingSerializer(Element.of(transportationNamespace, "lod4MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
            }
        }

        for (ADEPropertyOfTrafficArea<?> property : object.getADEPropertiesOfTrafficArea())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
