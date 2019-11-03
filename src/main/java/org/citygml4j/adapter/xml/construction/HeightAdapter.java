package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.ElevationReferenceValue;
import org.citygml4j.model.construction.Height;
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

@XMLElement(name = "Height", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class HeightAdapter implements ObjectBuilder<Height>, ObjectSerializer<Height> {

    @Override
    public Height createObject(QName name) throws ObjectBuildException {
        return new Height();
    }

    @Override
    public void buildChildObject(Height object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "highReference":
                    reader.getTextContent().ifPresent(v -> object.setHighReference(ElevationReferenceValue.fromValue(v)));
                    break;
                case "lowReference":
                    reader.getTextContent().ifPresent(v -> object.setLowReference(ElevationReferenceValue.fromValue(v)));
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
    public Element createElement(Height object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "Height");
    }

    @Override
    public void writeChildElements(Height object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getHighReference() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "highReference").addTextContent(object.getHighReference().toValue()));

        if (object.getLowReference() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "lowReference").addTextContent(object.getLowReference().toValue()));

        if (object.getStatus() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "status").addTextContent(object.getStatus().toValue()));

        if (object.getValue() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "value"), object.getValue(), LengthAdapter.class, namespaces);
    }
}
