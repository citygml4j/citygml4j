package org.citygml4j.adapter.xml.deprecated.cityobjectgroup;

import org.citygml4j.model.cityobjectgroup.Role;
import org.citygml4j.model.cityobjectgroup.RoleProperty;
import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class RolePropertyAdapter extends AbstractPropertyAdapter<RoleProperty> {

    @Override
    public RoleProperty createObject(QName name) throws ObjectBuildException {
        return new RoleProperty();
    }

    @Override
    public void initializeObject(RoleProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        if (object.getHref() == null) {
            object.setObject(new Role());
            attributes.getValue("role").ifPresent(object.getObject()::setRole);
        } else
            attributes.getValue("role").ifPresent(v -> object.getLocalProperties().set(DeprecatedProperties.ROLE, v));
    }

    @Override
    public void buildChildObject(RoleProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (object.getObject() == null) {
            object.setObject(new Role());
            object.getObject().setRole(object.getLocalProperties().get(DeprecatedProperties.ROLE, String.class));
        }

        object.getObject().setGroupMember(new AbstractCityObjectProperty(reader.getObject(AbstractCityObject.class)));
    }

    @Override
    public void initializeElement(Element element, RoleProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        if (object.getObject() != null)
            element.addAttribute("role", object.getObject().getRole());
        else if (object.getLocalProperties().contains(DeprecatedProperties.ROLE))
            element.addAttribute("role", object.getLocalProperties().get(DeprecatedProperties.ROLE, String.class));
    }

    @Override
    public void writeChildElements(RoleProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getObject() != null
                && object.getObject().getGroupMember() != null
                && object.getObject().getGroupMember().getObject() != null)
            writer.writeObject(object.getObject().getGroupMember().getObject(), namespaces);
    }
}
