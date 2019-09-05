package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.QualifiedArea;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.base.ReferenceAdapter;
import org.xmlobjects.gml.adapter.measures.AreaAdapter;
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

@XMLElement(name = "QualifiedArea", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class QualifiedAreaAdapter implements ObjectBuilder<QualifiedArea>, ObjectSerializer<QualifiedArea> {

    @Override
    public QualifiedArea createObject(QName name) {
        return new QualifiedArea();
    }

    @Override
    public void buildChildObject(QualifiedArea object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "area":
                    object.setArea(reader.getObjectUsingBuilder(AreaAdapter.class));
                    break;
                case "typeOfArea":
                    object.setTypeOfArea(reader.getObjectUsingBuilder(ReferenceAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(QualifiedArea object, Namespaces namespaces) {
        return Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "QualifiedArea");
    }

    @Override
    public void writeChildElements(QualifiedArea object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getArea() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "area"), object.getArea(), AreaAdapter.class, namespaces);

        if (object.getTypeOfArea() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "typeOfArea"), object.getTypeOfArea(), ReferenceAdapter.class, namespaces);
    }
}
