package org.citygml4j.xml.adapter.generics;

import org.citygml4j.model.core.AbstractGenericAttribute;
import org.citygml4j.model.core.AbstractGenericAttributeProperty;
import org.citygml4j.model.generics.GenericAttributeSet;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractGenericAttributeAdapter;
import org.citygml4j.xml.adapter.core.AbstractGenericAttributePropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "GenericAttributeSet", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE),
        @XMLElement(name = "genericAttributeSet", namespaceURI = CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE),
        @XMLElement(name = "genericAttributeSet", namespaceURI = CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE)
})
public class GenericAttributeSetAdapter extends AbstractGenericAttributeAdapter<GenericAttributeSet> {

    @Override
    public GenericAttributeSet createObject(QName name, Object parent) throws ObjectBuildException {
        return new GenericAttributeSet();
    }

    @Override
    public void initializeObject(GenericAttributeSet object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }

    @Override
    public void buildChildObject(GenericAttributeSet object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if (CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "codeSpace":
                    reader.getTextContent().ifPresent(object::setCodeSpace);
                    break;
                case "genericAttribute":
                    object.getValue().add(reader.getObjectUsingBuilder(AbstractGenericAttributePropertyAdapter.class));
                    break;
            }
        } else if (CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())
                || CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI()))
            object.getValue().add(new AbstractGenericAttributeProperty(reader.getObject(AbstractGenericAttribute.class)));
    }

    @Override
    public Element createElement(GenericAttributeSet object, Namespaces namespaces) throws ObjectSerializeException {
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace) ?
                Element.of(genericsNamespace, "GenericAttributeSet") :
                Element.of(genericsNamespace, "genericAttributeSet");
    }

    @Override
    public void initializeElement(Element element, GenericAttributeSet object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        if (object.getCodeSpace() != null && !namespaces.contains(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE))
            element.addAttribute("codeSpace", object.getName());
    }

    @Override
    public void writeChildElements(GenericAttributeSet object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace);

        if (isCityGML3 && object.getCodeSpace() != null)
            writer.writeElement(Element.of(genericsNamespace, "codeSpace").addTextContent(object.getCodeSpace()));

        for (AbstractGenericAttributeProperty property : object.getValue()) {
            if (isCityGML3)
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "genericAttribute"), property, AbstractGenericAttributePropertyAdapter.class, namespaces);
            else if (property.getObject() != null)
                writer.writeObject(property.getObject(), namespaces);
        }
    }
}
