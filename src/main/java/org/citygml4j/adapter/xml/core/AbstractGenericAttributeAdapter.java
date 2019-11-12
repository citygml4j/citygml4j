package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AbstractGenericAttribute;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
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

public abstract class AbstractGenericAttributeAdapter<T extends AbstractGenericAttribute> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue("name").ifPresent(object::setName);
    }

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI()) && "name".equals(name.getLocalPart()))
            reader.getTextContent().ifPresent(object::setName);
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getName() != null && !namespaces.contains(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE))
            element.addAttribute("name", object.getName());
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getName() != null && namespaces.contains(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE))
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE, "name").addTextContent(object.getName()));
    }
}
