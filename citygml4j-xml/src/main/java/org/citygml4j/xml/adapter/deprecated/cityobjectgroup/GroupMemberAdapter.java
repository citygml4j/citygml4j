/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.deprecated.cityobjectgroup;

import org.citygml4j.core.model.deprecated.cityobjectgroup.GroupMember;
import org.xmlobjects.builder.ObjectBuildException;
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

public class GroupMemberAdapter extends AbstractFeatureMemberAdapter<GroupMember> {

    @Override
    public GroupMember createObject(QName name, Object parent) throws ObjectBuildException {
        return new GroupMember();
    }

    @Override
    public void initializeObject(GroupMember object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue("role").ifPresent(object::setRole);
    }

    @Override
    public void initializeElement(Element element, GroupMember object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addAttribute("role", object.getRole());
    }
}
