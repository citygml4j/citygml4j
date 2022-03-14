/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.xml.adapter.cityobjectgroup;

import org.citygml4j.core.model.cityobjectgroup.Role;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.core.AbstractCityObjectReferenceAdapter;
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
                    object.setGroupMember(reader.getObjectUsingBuilder(AbstractCityObjectReferenceAdapter.class));
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
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE, "groupMember"), object.getGroupMember(), AbstractCityObjectReferenceAdapter.class, namespaces);
    }
}
