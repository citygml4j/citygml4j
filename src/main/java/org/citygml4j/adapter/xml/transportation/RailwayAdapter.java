package org.citygml4j.adapter.xml.transportation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfRailway;
import org.citygml4j.model.transportation.ADEPropertyOfRailway;
import org.citygml4j.model.transportation.IntersectionProperty;
import org.citygml4j.model.transportation.Railway;
import org.citygml4j.model.transportation.SectionProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
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

@XMLElement(name = "Railway", namespaceURI = CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE)
public class RailwayAdapter extends AbstractTransportationSpaceAdapter<Railway> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "AbstractGenericApplicationPropertyOfRailway");

    @Override
    public Railway createObject(QName name) throws ObjectBuildException {
        return new Railway();
    }

    @Override
    public void buildChildObject(Railway object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "section":
                    object.getSections().add(reader.getObjectUsingBuilder(SectionPropertyAdapter.class));
                    return;
                case "intersection":
                    object.getIntersections().add(reader.getObjectUsingBuilder(IntersectionPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(Railway object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfRailway.class, object.getADEPropertiesOfRailway(),
                GenericADEPropertyOfRailway::of, reader, substitutionGroup))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(Railway object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "Railway");
    }

    @Override
    public void writeChildElements(Railway object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, namespaces, writer);

        for (SectionProperty property : object.getSections())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "section"), property, SectionPropertyAdapter.class, namespaces);

        for (IntersectionProperty property : object.getIntersections())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "intersection"), property, IntersectionPropertyAdapter.class, namespaces);

        for (ADEPropertyOfRailway property : object.getADEPropertiesOfRailway())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
