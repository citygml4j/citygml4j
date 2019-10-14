package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.QualifiedVolume;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.measures.VolumeAdapter;
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

@XMLElement(name = "QualifiedVolume", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class QualifiedVolumeAdapter implements ObjectBuilder<QualifiedVolume>, ObjectSerializer<QualifiedVolume> {

    @Override
    public QualifiedVolume createObject(QName name) {
        return new QualifiedVolume();
    }

    @Override
    public void buildChildObject(QualifiedVolume object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "volume":
                    object.setVolume(reader.getObjectUsingBuilder(VolumeAdapter.class));
                    break;
                case "typeOfVolume":
                    object.setTypeOfVolume(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(QualifiedVolume object, Namespaces namespaces) {
        return Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "QualifiedVolume");
    }

    @Override
    public void writeChildElements(QualifiedVolume object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getVolume() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "volume"), object.getVolume(), VolumeAdapter.class, namespaces);

        if (object.getTypeOfVolume() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "typeOfVolume"), object.getTypeOfVolume(), CodeAdapter.class, namespaces);
    }
}
