package org.citygml4j.adapter.xml.deprecated;

import org.citygml4j.model.deprecated.WeakCityObjectReference;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
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

public class WeakCityObjectReferenceAdapter implements ObjectBuilder<WeakCityObjectReference>, ObjectSerializer<WeakCityObjectReference> {

    @Override
    public WeakCityObjectReference createObject(QName name) {
        return new WeakCityObjectReference();
    }

    @Override
    public void initializeObject(WeakCityObjectReference object, QName name, Attributes attributes, XMLReader reader) {
        GMLBuilderHelper.buildAssociationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(WeakCityObjectReference object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        object.setObject(reader.getObject(object.getTargetType()));
    }

    @Override
    public void initializeElement(Element element, WeakCityObjectReference object, Namespaces namespaces, XMLWriter writer) {
        GMLSerializerHelper.serializeAssociationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(WeakCityObjectReference object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getObject() != null)
            writer.writeObject(object.getObject(), namespaces);
    }
}
