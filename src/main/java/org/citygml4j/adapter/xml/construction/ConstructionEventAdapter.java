package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.ConstructionEvent;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@XMLElement(name = "ConstructionEvent", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class ConstructionEventAdapter implements ObjectBuilder<ConstructionEvent>, ObjectSerializer<ConstructionEvent> {

    @Override
    public ConstructionEvent createObject(QName name) {
        return new ConstructionEvent();
    }

    @Override
    public void buildChildObject(ConstructionEvent object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "event":
                    object.setEvent(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "dateOfEvent":
                    reader.getTextContent().ifDate(v -> object.setDateOfEvent(v.toLocalDate()));
                    break;
                case "description":
                    reader.getTextContent().ifPresent(object::setDescription);
                    break;
            }
        }
    }

    @Override
    public Element createElement(ConstructionEvent object, Namespaces namespaces) {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "ConstructionEvent");
    }

    @Override
    public void writeChildElements(ConstructionEvent object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getEvent() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "event"), object.getEvent(), CodeAdapter.class, namespaces);

        if (object.getDateOfEvent() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "dateOfEvent").addTextContent(TextContent.ofDate(OffsetDateTime.of(object.getDateOfEvent(), LocalTime.MIN, ZoneOffset.UTC))));

        if (object.getDescription() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "description").addTextContent(object.getDescription()));
    }
}
