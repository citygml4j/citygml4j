/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.versioning;

import org.citygml4j.model.ade.generic.GenericADEOfVersion;
import org.citygml4j.model.core.AbstractFeatureWithLifespanProperty;
import org.citygml4j.model.versioning.ADEOfVersion;
import org.citygml4j.model.versioning.Version;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractFeatureWithLifespanPropertyAdapter;
import org.citygml4j.xml.adapter.core.AbstractVersionAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "Version", namespaceURI = CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE)
public class VersionAdapter extends AbstractVersionAdapter<Version> {

    @Override
    public Version createObject(QName name, Object parent) throws ObjectBuildException {
        return new Version();
    }

    @Override
    public void buildChildObject(Version object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "tag":
                    reader.getTextContent().ifPresent(object.getTags()::add);
                    return;
                case "versionMember":
                    object.getVersionMembers().add(reader.getObjectUsingBuilder(AbstractFeatureWithLifespanPropertyAdapter.class));
                    return;
                case "adeOfVersion":
                    ADEBuilderHelper.addADEContainer(ADEOfVersion.class, object.getADEOfVersion(), GenericADEOfVersion::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Version object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "Version");
    }

    @Override
    public void writeChildElements(Version object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (String tag : object.getTags())
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "tag").addTextContent(tag));

        for (AbstractFeatureWithLifespanProperty property : object.getVersionMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "versionMember"), property, AbstractFeatureWithLifespanPropertyAdapter.class, namespaces);

        for (ADEOfVersion container : object.getADEOfVersion())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "adeOfVersion"), container, namespaces, writer);
    }
}
