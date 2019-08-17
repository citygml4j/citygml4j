package org.citygml4j.adapter.xml.deprecated;

import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.deprecated.WeakCityObjectReference;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.BuildResult;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class WeakCityObjectReferenceAdapter extends AbstractWeakReferenceAdapter<WeakCityObjectReference> {

    @Override
    public WeakCityObjectReference createObject(QName name) throws ObjectBuildException {
        return new WeakCityObjectReference();
    }

    @Override
    public void buildChildObject(WeakCityObjectReference object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuildResult<AbstractCityObject> result = reader.getObjectOrDOMElement(object.getTargetType());
        if (result.isSetObject())
            object.setObject(result.getObject());
        else if (result.isSetDOMElement())
            object.setGenericElement(GenericElement.of(result.getDOMElement()));
    }

    @Override
    public void writeChildElements(WeakCityObjectReference object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetObject())
            writer.writeObject(object.getObject(), namespaces);
        else if (object.isSetGenericElement())
            writer.writeDOMElement(object.getGenericElement().getContent());
    }
}
