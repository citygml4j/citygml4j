package org.citygml4j.adapter.xml.generics;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractGenericAttributeAdapter;
import org.citygml4j.model.generics.DoubleAttribute;
import org.citygml4j.util.CityGMLConstants;
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
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "DoubleAttribute", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE),
        @XMLElement(name = "doubleAttribute", namespaceURI = CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE),
        @XMLElement(name = "doubleAttribute", namespaceURI = CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE)
})
public class DoubleAttributeAdapter extends AbstractGenericAttributeAdapter<DoubleAttribute> {

    @Override
    public DoubleAttribute createObject(QName name) throws ObjectBuildException {
        return new DoubleAttribute();
    }

    @Override
    public void buildChildObject(DoubleAttribute object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);
        if (CityGMLBuilderHelper.isCityGMLGenericsNamespace(name.getNamespaceURI()) && "value".equals(name.getLocalPart()))
            reader.getTextContent().ifDouble(object::setValue);
    }

    @Override
    public Element createElement(DoubleAttribute object, Namespaces namespaces) throws ObjectSerializeException {
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace) ?
                Element.of(genericsNamespace, "DoubleAttribute") :
                Element.of(genericsNamespace, "doubleAttribute");
    }

    @Override
    public void writeChildElements(DoubleAttribute object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);

        if (object.getValue() != null)
            writer.writeElement(Element.of(genericsNamespace, "value").addTextContent(TextContent.ofDouble(object.getValue())));
    }
}
