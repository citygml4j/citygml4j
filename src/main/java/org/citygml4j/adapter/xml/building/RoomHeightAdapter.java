package org.citygml4j.adapter.xml.building;

import org.citygml4j.model.building.RoomElevationReferenceValue;
import org.citygml4j.model.building.RoomHeight;
import org.citygml4j.model.construction.HeightStatusValue;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.measures.LengthAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "RoomHeight", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class RoomHeightAdapter implements ObjectBuilder<RoomHeight>, ObjectSerializer<RoomHeight> {

    @Override
    public RoomHeight createObject(QName name) throws ObjectBuildException {
        return new RoomHeight();
    }

    @Override
    public void buildChildObject(RoomHeight object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "highReference":
                    reader.getTextContent().ifPresent(v -> object.setHighReference(RoomElevationReferenceValue.fromValue(v)));
                    break;
                case "lowReference":
                    reader.getTextContent().ifPresent(v -> object.setLowReference(RoomElevationReferenceValue.fromValue(v)));
                    break;
                case "status":
                    reader.getTextContent().ifPresent(v -> object.setStatus(HeightStatusValue.fromValue(v)));
                    break;
                case "value":
                    object.setValue(reader.getObjectUsingBuilder(LengthAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(RoomHeight object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "RoomHeight");
    }

    @Override
    public void writeChildElements(RoomHeight object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getHighReference() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "highReference").addTextContent(object.getHighReference().toValue()));

        if (object.getLowReference() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "lowReference").addTextContent(object.getLowReference().toValue()));

        if (object.getStatus() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "status").addTextContent(object.getStatus().toValue()));

        if (object.getValue() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "value"), object.getValue(), LengthAdapter.class, namespaces);
    }
}
