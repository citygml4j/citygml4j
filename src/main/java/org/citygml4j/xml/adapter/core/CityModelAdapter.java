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

package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.ade.generic.GenericADEOfCityModel;
import org.citygml4j.model.core.*;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

@XMLElement(name = "CityModel", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class CityModelAdapter extends AbstractFeatureWithLifespanAdapter<CityModel> {

    @Override
    public CityModel createObject(QName name, Object parent) throws ObjectBuildException {
        return new CityModel();
    }

    @Override
    public void buildChildObject(CityModel object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "cityObjectMember":
                    object.getCityObjectMembers().add(reader.getObjectUsingBuilder(AbstractCityObjectPropertyAdapter.class));
                    return;
                case "appearanceMember":
                    object.getAppearanceMembers().add(reader.getObjectUsingBuilder(AbstractAppearancePropertyAdapter.class));
                    return;
                case "versionMember":
                    object.getVersionMembers().add(reader.getObjectUsingBuilder(AbstractVersionPropertyAdapter.class));
                    return;
                case "versionTransitionMember":
                    object.getVersionTransitionMembers().add(reader.getObjectUsingBuilder(AbstractVersionTransitionPropertyAdapter.class));
                    return;
                case "featureMember":
                    object.getFeatureMembers().add(reader.getObjectUsingBuilder(AbstractFeaturePropertyAdapter.class));
                    return;
                case "engineeringCRS":
                    object.setEngineeringCRS(reader.getObjectUsingBuilder(EngineeringCRSPropertyAdapter.class));
                    return;
                case "adeOfCityModel":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfCityModel::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CityModel object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "CityModel");
    }

    @Override
    public void writeChildElements(CityModel object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getEngineeringCRS() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "engineeringCRS"), object.getEngineeringCRS(), EngineeringCRSPropertyAdapter.class, namespaces);

        for (AbstractCityObjectProperty property : object.getCityObjectMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "cityObjectMember"), property, AbstractCityObjectPropertyAdapter.class, namespaces);

        for (AbstractAppearanceProperty property : object.getAppearanceMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "appearanceMember"), property, AbstractAppearancePropertyAdapter.class, namespaces);

        for (AbstractVersionProperty property : object.getVersionMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "versionMember"), property, AbstractVersionPropertyAdapter.class, namespaces);

        for (AbstractVersionTransitionProperty property : object.getVersionTransitionMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "versionTransitionMember"), property, AbstractVersionTransitionPropertyAdapter.class, namespaces);

        for (AbstractFeatureProperty property : object.getFeatureMembers())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "featureMember"), property, AbstractFeaturePropertyAdapter.class, namespaces);

        for (ADEOfCityModel property : object.getADEProperties(ADEOfCityModel.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "adeOfCityModel"), property, namespaces, writer);
    }
}
