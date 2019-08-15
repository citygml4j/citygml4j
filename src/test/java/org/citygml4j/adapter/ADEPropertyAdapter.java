package org.citygml4j.adapter;

import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "roofType", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE),
        @XMLElement(name = "roofType", namespaceURI = CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE),
        @XMLElement(name = "roofType", namespaceURI = CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE)
})
public class ADEPropertyAdapter implements ObjectBuilder<RoofTypeProperty> {

    @Override
    public RoofTypeProperty createObject(QName name) throws ObjectBuildException {
        return new RoofTypeProperty();
    }

    @Override
    public void initializeObject(RoofTypeProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
    }
}
