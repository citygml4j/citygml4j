package org.citygml4j.adapter.xml.deprecated.transportation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfRoad;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.transportation.ADEPropertyOfRoad;
import org.citygml4j.model.transportation.Road;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
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
        @XMLElement(name = "TransportationComplex", namespaceURI = CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE),
        @XMLElement(name = "TransportationComplex", namespaceURI = CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE),
        @XMLElement(name = "Road", namespaceURI = CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE),
        @XMLElement(name = "Road", namespaceURI = CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE)
})
public class RoadAdapter extends AbstractTransportationObjectAdapter<Road> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfTransportationComplex"),
            new QName(CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfTransportationComplex"),
            new QName(CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfRoad"),
            new QName(CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfRoad")
    };

    @Override
    public Road createObject(QName name) throws ObjectBuildException {
        Road object = new Road();
        if ("TransportationComplex".equals(name.getLocalPart()))
            object.getLocalProperties().set(DeprecatedProperties.TRANSPORTATION_COMPLEX, true);

        return object;
    }

    @Override
    public void buildChildObject(Road object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(Road object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfRoad.class, object.getADEPropertiesOfRoad(),
                GenericADEPropertyOfRoad::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(Road object, Namespaces namespaces) throws ObjectSerializeException {
        String transportationNamespace = CityGMLSerializerHelper.getTransportationNamespace(namespaces);
        return object.getLocalProperties().getAndCompare(DeprecatedProperties.TRANSPORTATION_COMPLEX, true) ?
                Element.of(transportationNamespace, "TransportationComplex") :
                Element.of(transportationNamespace, "Road");
    }

    @Override
    public void writeChildElements(Road object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfRoad property : object.getADEPropertiesOfRoad())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
