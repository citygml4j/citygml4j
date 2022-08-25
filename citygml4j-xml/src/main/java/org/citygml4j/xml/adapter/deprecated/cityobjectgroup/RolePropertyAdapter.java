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

package org.citygml4j.xml.adapter.deprecated.cityobjectgroup;

import org.citygml4j.core.model.cityobjectgroup.Role;
import org.citygml4j.core.model.cityobjectgroup.RoleProperty;
import org.citygml4j.core.model.core.AbstractCityObjectReference;
import org.citygml4j.xml.adapter.core.AbstractCityObjectReferenceAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class RolePropertyAdapter extends AbstractInlinePropertyAdapter<RoleProperty> {

    @Override
    public RoleProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new RoleProperty();
    }

    @Override
    public void initializeObject(RoleProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        object.setObject(new Role(attributes.getValue("role").get(), new AbstractCityObjectReference()));
        reader.getOrCreateBuilder(AbstractCityObjectReferenceAdapter.class).initializeObject(object.getObject().getGroupMember(), name, attributes, reader);
    }

    @Override
    public void initializeElement(Element element, RoleProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getObject() != null) {
            element.addAttribute("role", object.getObject().getRole());

            if (object.getObject().getGroupMember() != null)
                writer.getOrCreateSerializer(AbstractCityObjectReferenceAdapter.class).initializeElement(element, object.getObject().getGroupMember(), namespaces, writer);
        }
    }
}
