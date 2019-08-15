package org.citygml4j.adapter.xml.generics;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.model.generics.IntAttribute;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "IntAttribute", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE),
        @XMLElement(name = "intAttribute", namespaceURI = CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE),
        @XMLElement(name = "intAttribute", namespaceURI = CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE)
})
public class IntAttributeAdapter extends AbstractGenericAttributeAdapter<IntAttribute> {

    @Override
    public IntAttribute createObject(QName name) {
        return new IntAttribute();
    }

    @Override
    public void buildChildObject(IntAttribute object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);
        if (CityGMLBuilderHelper.isCityGMLGenericsNamespace(name.getNamespaceURI()) && "value".equals(name.getLocalPart()))
            reader.getTextContent().ifInteger(object::setValue);
    }
}
