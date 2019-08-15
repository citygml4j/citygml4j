package org.citygml4j.adapter.xml.deprecated;

import org.citygml4j.model.deprecated.ExternalObject;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class ExternalObjectAdapter implements ObjectBuilder<ExternalObject> {

    @Override
    public ExternalObject createObject(QName name) {
        return new ExternalObject();
    }

    @Override
    public void buildChildObject(ExternalObject object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        if (CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE.equals(name.getNamespaceURI())
                || CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "name":
                    reader.getTextContent().ifPresent(object::setName);
                    break;
                case "uri":
                    reader.getTextContent().ifPresent(object::setURI);
                    break;
            }
        }
    }
}
