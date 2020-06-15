package org.citygml4j.xml.adapter.cityobjectgroup;

import org.citygml4j.model.cityobjectgroup.Role;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.core.AbstractCityObjectPropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "Role", namespaceURI = CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE)
public class RoleAdapter extends AbstractGMLAdapter<Role> {

    @Override
    public Role createObject(QName name, Object parent) throws ObjectBuildException {
        return new Role();
    }

    @Override
    public void buildChildObject(Role object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "role":
                    reader.getTextContent().ifPresent(object::setRole);
                    break;
                case "groupMember":
                    object.setGroupMember(reader.getObjectUsingBuilder(AbstractCityObjectPropertyAdapter.class));
                    break;
            }
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Role object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE, "Role");
    }

    @Override
    public void writeChildElements(Role object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getRole() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE, "role").addTextContent(object.getRole()));

        if (object.getGroupMember() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE, "groupMember"), object.getGroupMember(), AbstractCityObjectPropertyAdapter.class, namespaces);
    }
}
