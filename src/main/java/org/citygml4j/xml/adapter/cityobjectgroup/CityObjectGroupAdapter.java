/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.model.ade.generic.GenericADEOfCityObjectGroup;
import org.citygml4j.model.cityobjectgroup.ADEOfCityObjectGroup;
import org.citygml4j.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.cityobjectgroup.RoleProperty;
import org.citygml4j.model.deprecated.cityobjectgroup.DeprecatedPropertiesOfCityObjectGroup;
import org.citygml4j.model.deprecated.cityobjectgroup.GroupMember;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractCityObjectReferenceAdapter;
import org.citygml4j.xml.adapter.core.AbstractLogicalSpaceAdapter;
import org.citygml4j.xml.adapter.deprecated.cityobjectgroup.GroupMemberAdapter;
import org.citygml4j.xml.adapter.deprecated.cityobjectgroup.GroupParentMemberAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CityObjectGroup", namespaceURI = CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE),
        @XMLElement(name = "CityObjectGroup", namespaceURI = CityGMLConstants.CITYGML_2_0_CITYOBJECTGROUP_NAMESPACE),
        @XMLElement(name = "CityObjectGroup", namespaceURI = CityGMLConstants.CITYGML_1_0_CITYOBJECTGROUP_NAMESPACE)
})
public class CityObjectGroupAdapter extends AbstractLogicalSpaceAdapter<CityObjectGroup> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_CITYOBJECTGROUP_NAMESPACE, "_GenericApplicationPropertyOfCityObjectGroup"),
            new QName(CityGMLConstants.CITYGML_1_0_CITYOBJECTGROUP_NAMESPACE, "_GenericApplicationPropertyOfCityObjectGroup")
    };

    @Override
    public CityObjectGroup createObject(QName name, Object parent) throws ObjectBuildException {
        return new CityObjectGroup();
    }

    @Override
    public void buildChildObject(CityObjectGroup object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityObjectGroupNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "groupMember":
                    if (CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE.equals(name.getNamespaceURI())) {
                        object.getGroupMembers().add(reader.getObjectUsingBuilder(RolePropertyAdapter.class));
                    } else {
                        if (attributes.getValue(GMLConstants.XLINK_NAMESPACE, "href").isPresent()) {
                            object.getGroupMembers().add(reader.getObjectUsingBuilder(org.citygml4j.xml.adapter.deprecated.cityobjectgroup.RolePropertyAdapter.class));
                        } else {
                            object.getDeprecatedProperties().getGroupMembers().add(reader.getObjectUsingBuilder(GroupMemberAdapter.class));
                        }
                    }
                    return;
                case "parent":
                    if (CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE.equals(name.getNamespaceURI())
                            || attributes.getValue(GMLConstants.XLINK_NAMESPACE, "href").isPresent()) {
                        object.setGroupParent(reader.getObjectUsingBuilder(AbstractCityObjectReferenceAdapter.class));
                    } else {
                        object.getDeprecatedProperties().setGroupParent(reader.getObjectUsingBuilder(GroupParentMemberAdapter.class));
                    }
                    return;
                case "geometry":
                    object.getDeprecatedProperties().setGeometry(reader.getObjectUsingBuilder(GeometryPropertyAdapter.class));
                    return;
                case "adeOfCityObjectGroup":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfCityObjectGroup::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(CityObjectGroup object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfCityObjectGroup::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(CityObjectGroup object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getCityObjectGroupNamespace(namespaces), "CityObjectGroup");
    }

    @Override
    public void writeChildElements(CityObjectGroup object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String cityObjectGroupNamespace = CityGMLSerializerHelper.getCityObjectGroupNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE.equals(cityObjectGroupNamespace);
        DeprecatedPropertiesOfCityObjectGroup properties = object.hasDeprecatedProperties() ?
                object.getDeprecatedProperties() :
                null;

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, cityObjectGroupNamespace, namespaces, writer);

        for (RoleProperty property : object.getGroupMembers()) {
            if (isCityGML3)
                writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "groupMember"), property, RolePropertyAdapter.class, namespaces);
            else
                writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "groupMember"), property, org.citygml4j.xml.adapter.deprecated.cityobjectgroup.RolePropertyAdapter.class, namespaces);
        }

        if (!isCityGML3 && properties != null) {
            for (GroupMember property : properties.getGroupMembers())
                writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "groupMember"), property, GroupMemberAdapter.class, namespaces);
        }

        if (object.getGroupParent() != null)
            writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "parent"), object.getGroupParent(), AbstractCityObjectReferenceAdapter.class, namespaces);
        else if (!isCityGML3 && properties != null && properties.getGroupParent() != null)
            writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "parent"), properties.getGroupParent(), GroupParentMemberAdapter.class, namespaces);

        if (!isCityGML3 && properties != null && properties.getGeometry() != null)
            writer.writeElementUsingSerializer(Element.of(cityObjectGroupNamespace, "geometry"), properties.getGeometry(), GeometryPropertyAdapter.class, namespaces);

        for (ADEOfCityObjectGroup property : object.getADEProperties(ADEOfCityObjectGroup.class))
            ADESerializerHelper.writeADEProperty(isCityGML3 ? Element.of(cityObjectGroupNamespace, "adeOfCityObjectGroup") : null, property, namespaces, writer);
    }
}
