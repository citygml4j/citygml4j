package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.Occupancy;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.gml.adapter.base.ReferenceAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

@XMLElement(name = "Occupancy", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class OccupancyAdapter extends AbstractGMLAdapter<Occupancy> {

    @Override
    public Occupancy createObject(QName name) {
        return new Occupancy();
    }

    @Override
    public void buildChildObject(Occupancy object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "numberOfOccupants":
                    reader.getTextContent().ifInteger(object::setNumberOfOccupants);
                    break;
                case "interval":
                    object.setInterval(reader.getObjectUsingBuilder(ReferenceAdapter.class));
                    break;
                case "occupantType":
                    object.setOccupantType(reader.getObjectUsingBuilder(ReferenceAdapter.class));
                    break;
            }
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Occupancy object, Namespaces namespaces) {
        return Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "Occupancy");
    }

    @Override
    public void writeChildElements(Occupancy object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getNumberOfOccupants() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "numberOfOccupants").addTextContent(TextContent.ofInteger(object.getNumberOfOccupants())));

        if (object.getInterval() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "interval"), object.getInterval(), ReferenceAdapter.class, namespaces);

        if (object.getOccupantType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "occupantType"), object.getOccupantType(), ReferenceAdapter.class, namespaces);
    }
}
