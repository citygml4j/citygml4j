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

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractCityObject;
import org.citygml4j.core.model.core.*;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

public abstract class AbstractCityObjectAdapter<T extends AbstractCityObject> extends AbstractFeatureWithLifespanAdapter<T> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE, "_GenericApplicationPropertyOfCityObject"),
            new QName(CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE, "_GenericApplicationPropertyOfCityObject")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCoreNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "externalReference":
                    if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()))
                        object.getExternalReferences().add(reader.getObjectUsingBuilder(ExternalReferencePropertyAdapter.class));
                    else {
                        ExternalReference reference = reader.getObjectUsingBuilder(ExternalReferenceAdapter.class);
                        object.getExternalReferences().add(new ExternalReferenceProperty(reference));
                    }
                    return;
                case "generalizesTo":
                    if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()))
                        object.getGeneralizesTo().add(reader.getObjectUsingBuilder(AbstractCityObjectReferenceAdapter.class));
                    else {
                        AbstractCityObjectProperty property = reader.getObjectUsingBuilder(AbstractCityObjectPropertyAdapter.class);
                        if (!property.isSetInlineObject() && !property.isSetGenericElement())
                            object.getGeneralizesTo().add(new AbstractCityObjectReference(property));
                        else
                            object.getDeprecatedProperties().getGeneralizesTo().add(property);
                    }
                    return;
                case "relativeToTerrain":
                    reader.getTextContent().ifPresent(v -> object.setRelativeToTerrain(RelativeToTerrain.fromValue(v)));
                    return;
                case "relativeToWater":
                    reader.getTextContent().ifPresent(v -> object.setRelativeToWater(RelativeToWater.fromValue(v)));
                    return;
                case "relatedTo":
                    object.getRelatedTo().add(reader.getObjectUsingBuilder(CityObjectRelationPropertyAdapter.class));
                    return;
                case "appearance":
                    object.getAppearances().add(reader.getObjectUsingBuilder(AbstractAppearancePropertyAdapter.class));
                    return;
                case "genericAttribute":
                    object.getGenericAttributes().add(reader.getObjectUsingBuilder(AbstractGenericAttributePropertyAdapter.class));
                    return;
                case "dynamizer":
                    object.getDynamizers().add(reader.getObjectUsingBuilder(AbstractDynamizerPropertyAdapter.class));
                    return;
                case "adeOfAbstractCityObject":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfAbstractCityObject::of, reader);
                    return;
            }
        } else if (CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE.equals(name.getNamespaceURI())
                || CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE.equals(name.getNamespaceURI())) {
            object.getAppearances().add(reader.getObjectUsingBuilder(AbstractAppearancePropertyAdapter.class));
            return;
        } else if (CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())
                || CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())) {
            object.getGenericAttributes().add(new AbstractGenericAttributeProperty(reader.getObject(AbstractGenericAttribute.class)));
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfAbstractCityObject::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace);

        if (object.isSetExternalReferences()) {
            for (ExternalReferenceProperty property : object.getExternalReferences()) {
                if (isCityGML3)
                    writer.writeElementUsingSerializer(Element.of(coreNamespace, "externalReference"), property, ExternalReferencePropertyAdapter.class, namespaces);
                else
                    writer.writeElementUsingSerializer(Element.of(coreNamespace, "externalReference"), property.getObject(), ExternalReferenceAdapter.class, namespaces);
            }
        }

        if (object.isSetGeneralizesTo()) {
            for (AbstractCityObjectReference reference : object.getGeneralizesTo())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "generalizesTo"), reference, AbstractCityObjectReferenceAdapter.class, namespaces);
        }

        if (!isCityGML3
                && object.hasDeprecatedProperties()
                && object.getDeprecatedProperties().isSetGeneralizesTo()) {
            for (AbstractCityObjectProperty property : object.getDeprecatedProperties().getGeneralizesTo())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "generalizesTo"), property, AbstractCityObjectPropertyAdapter.class, namespaces);
        }

        if (object.getRelativeToTerrain() != null)
            writer.writeElement(Element.of(coreNamespace, "relativeToTerrain").addTextContent(object.getRelativeToTerrain().toValue()));

        if (object.getRelativeToWater() != null)
            writer.writeElement(Element.of(coreNamespace, "relativeToWater").addTextContent(object.getRelativeToWater().toValue()));

        if (isCityGML3 && object.isSetRelatedTo()) {
            for (CityObjectRelationProperty property : object.getRelatedTo())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "relatedTo"), property, CityObjectRelationPropertyAdapter.class, namespaces);
        }

        if (object.isSetAppearances()) {
            for (AbstractAppearanceProperty member : object.getAppearances()) {
                if (isCityGML3)
                    writer.writeElementUsingSerializer(Element.of(coreNamespace, "appearance"), member, AbstractAppearancePropertyAdapter.class, namespaces);
                else {
                    String namespace = namespaces.contains(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE) ?
                            CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE :
                            CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE;
                    writer.writeElementUsingSerializer(Element.of(namespace, "appearance"), member, AbstractAppearancePropertyAdapter.class, namespaces);
                }
            }
        }

        if (object.isSetGenericAttributes()) {
            for (AbstractGenericAttributeProperty property : object.getGenericAttributes()) {
                if (isCityGML3)
                    writer.writeElementUsingSerializer(Element.of(coreNamespace, "genericAttribute"), property, AbstractGenericAttributePropertyAdapter.class, namespaces);
                else if (property.getObject() != null)
                    writer.writeObject(property.getObject(), namespaces);
            }
        }

        if (isCityGML3 && object.isSetDynamizers()) {
            for (AbstractDynamizerProperty property : object.getDynamizers())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "dynamizer"), property, AbstractDynamizerPropertyAdapter.class, namespaces);
        }

        for (ADEOfAbstractCityObject property : object.getADEProperties(ADEOfAbstractCityObject.class))
            ADESerializerHelper.writeADEProperty(isCityGML3 ? Element.of(coreNamespace, "adeOfAbstractCityObject") : null, property, namespaces, writer);
    }
}
