package org.citygml4j.xml.adapter.generics;

import org.citygml4j.model.generics.CodeAttribute;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractGenericAttributeAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "CodeAttribute", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE)
public class CodeAttributeAdapter extends AbstractGenericAttributeAdapter<CodeAttribute> {

    @Override
    public CodeAttribute createObject(QName name, Object parent) throws ObjectBuildException {
        return new CodeAttribute();
    }

    @Override
    public void buildChildObject(CodeAttribute object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);
        if (CityGMLBuilderHelper.isGenericsNamespace(name.getNamespaceURI()) && "value".equals(name.getLocalPart()))
            object.setValue(reader.getObjectUsingBuilder(CodeAdapter.class));
    }

    @Override
    public Element createElement(CodeAttribute object, Namespaces namespaces) throws ObjectSerializeException {
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace) ?
                Element.of(genericsNamespace, "CodeAttribute") :
                Element.of(genericsNamespace, "stringAttribute");
    }

    @Override
    public void writeChildElements(CodeAttribute object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);

        if (object.getValue() != null) {
            if (CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace))
                writer.writeElementUsingSerializer(Element.of(genericsNamespace, "value"), object.getValue(), CodeAdapter.class, namespaces);
            else if (object.getValue().getValue() != null)
                writer.writeElement(Element.of(genericsNamespace, "value").addTextContent(object.getValue().getValue()));
        }
    }
}
