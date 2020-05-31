package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractCityObject;
import org.citygml4j.model.core.ADEOfAbstractCityObject;
import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.model.core.AbstractDynamizerProperty;
import org.citygml4j.model.core.AbstractGenericAttribute;
import org.citygml4j.model.core.AbstractGenericAttributeProperty;
import org.citygml4j.model.core.CityObjectRelationProperty;
import org.citygml4j.model.core.ExternalReference;
import org.citygml4j.model.core.ExternalReferenceProperty;
import org.citygml4j.model.core.RelativeToTerrain;
import org.citygml4j.model.core.RelativeToWater;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.ReferenceAdapter;
import org.xmlobjects.gml.model.base.Reference;
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
                        object.getGeneralizesTo().add(reader.getObjectUsingBuilder(ReferenceAdapter.class));
                    else {
                        AbstractCityObjectProperty property = reader.getObjectUsingBuilder(AbstractCityObjectPropertyAdapter.class);
                        if (property.getObject() == null && property.getGenericElement() == null)
                            object.getGeneralizesTo().add(new Reference(property));
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
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractCityObject.class, object.getADEOfAbstractCityObject(), GenericADEOfAbstractCityObject::new, reader);
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
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfAbstractCityObject.class, object.getADEOfAbstractCityObject(),
                GenericADEOfAbstractCityObject::new, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace);

        for (ExternalReferenceProperty property : object.getExternalReferences()) {
            if (isCityGML3)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "externalReference"), property, ExternalReferencePropertyAdapter.class, namespaces);
            else
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "externalReference"), property.getObject(), ExternalReferenceAdapter.class, namespaces);
        }

        for (Reference reference : object.getGeneralizesTo())
            writer.writeElementUsingSerializer(Element.of(coreNamespace, "generalizesTo"), reference, ReferenceAdapter.class, namespaces);

        if (!isCityGML3) {
            for (AbstractCityObjectProperty property : object.getDeprecatedProperties().getGeneralizesTo())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "generalizesTo"), property, AbstractCityObjectPropertyAdapter.class, namespaces);
        }

        if (object.getRelativeToTerrain() != null)
            writer.writeElement(Element.of(coreNamespace, "relativeToTerrain").addTextContent(object.getRelativeToTerrain().toValue()));

        if (object.getRelativeToWater() != null)
            writer.writeElement(Element.of(coreNamespace, "relativeToWater").addTextContent(object.getRelativeToWater().toValue()));

        if (isCityGML3) {
            for (CityObjectRelationProperty property : object.getRelatedTo())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "relatedTo"), property, CityObjectRelationPropertyAdapter.class, namespaces);
        }

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

        for (AbstractGenericAttributeProperty property : object.getGenericAttributes()) {
            if (isCityGML3)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "genericAttribute"), property, AbstractGenericAttributePropertyAdapter.class, namespaces);
            else if (property.getObject() != null)
                writer.writeObject(property.getObject(), namespaces);
        }

        if (isCityGML3) {
            for (AbstractDynamizerProperty property : object.getDynamizers())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "dynamizer"), property, AbstractDynamizerPropertyAdapter.class, namespaces);
        }

        for (ADEOfAbstractCityObject container : object.getADEOfAbstractCityObject())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(coreNamespace, "adeOfAbstractCityObject") : null, container, namespaces, writer);
    }
}
