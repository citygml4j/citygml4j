package org.citygml4j.adapter.xml.deprecated.transportation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfSquare;
import org.citygml4j.model.transportation.ADEPropertyOfSquare;
import org.citygml4j.model.transportation.Square;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
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
        @XMLElement(name = "Square", namespaceURI = CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE),
        @XMLElement(name = "Square", namespaceURI = CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE)
})
public class SquareAdapter extends AbstractTransportationObjectAdapter<Square> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfSquare"),
            new QName(CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE, "_GenericApplicationPropertyOfSquare")
    };


    @Override
    public Square createObject(QName name) throws ObjectBuildException {
        return new Square();
    }

    @Override
    public void buildChildObject(Square object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfSquare> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfSquare.class);
            if (builder != null)
                object.getADEPropertiesOfSquare().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfSquare().add(GenericADEPropertyOfSquare.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Square object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getTransportationNamespace(namespaces), "Square");
    }

    @Override
    public void writeChildElements(Square object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfSquare property : object.getADEPropertiesOfSquare())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}