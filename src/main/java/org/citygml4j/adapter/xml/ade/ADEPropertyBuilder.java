package org.citygml4j.adapter.xml.ade;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import javax.xml.namespace.QName;

public interface ADEPropertyBuilder<T> {
    void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException;
}
