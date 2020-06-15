package org.citygml4j.xml.adapter.generics;

import org.citygml4j.model.generics.MeasureAttribute;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractGenericAttributeAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
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
        @XMLElement(name = "MeasureAttribute", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE),
        @XMLElement(name = "measureAttribute", namespaceURI = CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE),
        @XMLElement(name = "measureAttribute", namespaceURI = CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE)
})
public class MeasureAttributeAdapter extends AbstractGenericAttributeAdapter<MeasureAttribute> {

    @Override
    public MeasureAttribute createObject(QName name, Object parent) throws ObjectBuildException {
        return new MeasureAttribute();
    }

    @Override
    public void buildChildObject(MeasureAttribute object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);
        if (CityGMLBuilderHelper.isGenericsNamespace(name.getNamespaceURI()) && "value".equals(name.getLocalPart()))
            object.setValue(reader.getObjectUsingBuilder(MeasureAdapter.class));
    }

    @Override
    public Element createElement(MeasureAttribute object, Namespaces namespaces) throws ObjectSerializeException {
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace) ?
                Element.of(genericsNamespace, "MeasureAttribute") :
                Element.of(genericsNamespace, "measureAttribute");
    }

    @Override
    public void writeChildElements(MeasureAttribute object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);

        if (object.getValue() != null)
            writer.writeElementUsingSerializer(Element.of(genericsNamespace, "value"), object.getValue(), MeasureAdapter.class, namespaces);
    }
}
