package org.citygml4j.adapter.xml.generics;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractGenericAttributeAdapter;
import org.citygml4j.model.generics.UriAttribute;
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

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "UriAttribute", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE),
        @XMLElement(name = "uriAttribute", namespaceURI = CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE),
        @XMLElement(name = "uriAttribute", namespaceURI = CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE)
})
public class UriAttributeAdapter extends AbstractGenericAttributeAdapter<UriAttribute> {

    @Override
    public UriAttribute createObject(QName name) {
        return new UriAttribute();
    }

    @Override
    public void buildChildObject(UriAttribute object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);
        if (CityGMLBuilderHelper.isCityGMLGenericsNamespace(name.getNamespaceURI()) && "value".equals(name.getLocalPart()))
            reader.getTextContent().ifPresent(object::setValue);
    }

    @Override
    public Element createElement(UriAttribute object, Namespaces namespaces) {
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace) ?
                Element.of(genericsNamespace, "UriAttribute") :
                Element.of(genericsNamespace, "uriAttribute");
    }

    @Override
    public void writeChildElements(UriAttribute object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);

        if (object.getValue() != null)
            writer.writeElement(Element.of(genericsNamespace, "value").addTextContent(object.getValue()));
    }
}
