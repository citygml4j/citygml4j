package org.citygml4j.adapter.xml.generics;

import org.citygml4j.model.generics.AbstractGenericAttribute;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractGenericAttributeAdapter<T extends AbstractGenericAttribute> implements ObjectBuilder<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) {
        attributes.getValue("name").ifPresent(object::setName);
    }

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())
                && "name".equals(name.getLocalPart()))
            reader.getTextContent().ifPresent(object::setName);
    }
}
