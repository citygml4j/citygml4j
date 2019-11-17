package org.citygml4j.adapter.xml.deprecated.transportation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfTrack;
import org.citygml4j.model.transportation.ADEPropertyOfTrack;
import org.citygml4j.model.transportation.Track;
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
        @XMLElement(name = "Track", namespaceURI = CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE),
        @XMLElement(name = "Track", namespaceURI = CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE)
})
public class TrackAdapter extends AbstractTransportationObjectAdapter<Track> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfTrack"),
            new QName(CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfTrack")
    };


    @Override
    public Track createObject(QName name) throws ObjectBuildException {
        return new Track();
    }

    @Override
    public void buildChildObject(Track object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI()))
            buildADEProperty(object, name, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(Track object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfTrack.class, object.getADEPropertiesOfTrack(),
                GenericADEPropertyOfTrack::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(Track object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTransportationNamespace(namespaces), "Track");
    }

    @Override
    public void writeChildElements(Track object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfTrack property : object.getADEPropertiesOfTrack())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
