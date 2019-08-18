package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AppearanceMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class AppearanceMemberAdapter extends AbstractFeatureMemberAdapter<AppearanceMember> {

    @Override
    public AppearanceMember createObject(QName name) {
        return new AppearanceMember();
    }

    @Override
    public void initializeObject(AppearanceMember object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        GMLBuilderHelper.buildAssociationAttributes(object, attributes);
    }

    @Override
    public void initializeElement(Element element, AppearanceMember object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        GMLSerializerHelper.serializeAssociationAttributes(element, object, namespaces);
    }
}
