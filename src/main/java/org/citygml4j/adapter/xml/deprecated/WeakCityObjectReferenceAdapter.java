package org.citygml4j.adapter.xml.deprecated;

import org.citygml4j.model.deprecated.WeakCityObjectReference;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class WeakCityObjectReferenceAdapter implements ObjectBuilder<WeakCityObjectReference> {

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
}
