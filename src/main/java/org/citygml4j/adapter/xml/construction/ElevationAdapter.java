package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.Elevation;
import org.citygml4j.model.construction.ElevationReferenceValue;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.DirectPositionAdapter;
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

@XMLElement(name = "Elevation", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class ElevationAdapter implements ObjectBuilder<Elevation>, ObjectSerializer<Elevation> {

    @Override
    public Elevation createObject(QName name) throws ObjectBuildException {
        return new Elevation();
    }

    @Override
    public void buildChildObject(Elevation object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "elevationReference":
                    reader.getTextContent().ifPresent(v -> object.setElevationReference(ElevationReferenceValue.fromValue(v)));
                    break;
                case "elevationValue":
                    object.setElevationValue(reader.getObjectUsingBuilder(DirectPositionAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(Elevation object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "Elevation");
    }

    @Override
    public void writeChildElements(Elevation object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getElevationReference() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "elevationReference").addTextContent(object.getElevationReference().toValue()));

        if (object.getElevationValue() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "elevationValue"), object.getElevationValue(), DirectPositionAdapter.class, namespaces);
    }
}
