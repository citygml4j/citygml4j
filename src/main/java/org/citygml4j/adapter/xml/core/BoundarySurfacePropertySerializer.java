package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.BoundarySurfaceProperty;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

public class BoundarySurfacePropertySerializer implements ObjectSerializer<BoundarySurfaceProperty> {

    @Override
    public void initializeElement(Element element, BoundarySurfaceProperty object, Namespaces namespaces, XMLWriter writer) {
        GMLSerializerHelper.serializeAssociationAttributes(element, object, namespaces);
        GMLSerializerHelper.serializeOwnershipAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(BoundarySurfaceProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetObject())
            writer.writeObject(object.getObject(), namespaces);
        else if (object.isSetGenericElement())
            writer.writeDOMElement(object.getGenericElement().getContent());
    }
}
