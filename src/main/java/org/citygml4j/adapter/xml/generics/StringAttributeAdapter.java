package org.citygml4j.adapter.xml.generics;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.model.generics.StringAttribute;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "StringAttribute", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE),
        @XMLElement(name = "stringAttribute", namespaceURI = CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE),
        @XMLElement(name = "stringAttribute", namespaceURI = CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE)
})
public class StringAttributeAdapter extends AbstractGenericAttributeAdapter<StringAttribute> {

    @Override
    public StringAttribute createObject(QName name) {
        return new StringAttribute();
    }

    @Override
    public void buildChildObject(StringAttribute object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);
        if (CityGMLBuilderHelper.isCityGMLGenericsNamespace(name.getNamespaceURI()) && "value".equals(name.getLocalPart()))
            reader.getTextContent().ifPresent(object::setValue);
    }
}