package org.citygml4j.adapter.xml.core;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.deprecated.WeakCityObjectReferenceAdapter;
import org.citygml4j.adapter.xml.dynamizer.DynamizerPropertyAdapter;
import org.citygml4j.adapter.xml.generics.AbstractGenericAttributePropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractCityObject;
import org.citygml4j.model.core.ADEPropertyOfAbstractCityObject;
import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.core.ExternalReference;
import org.citygml4j.model.core.ExternalReferenceProperty;
import org.citygml4j.model.core.RelativeToTerrain;
import org.citygml4j.model.core.RelativeToWater;
import org.citygml4j.model.deprecated.WeakCityObjectReference;
import org.citygml4j.model.generics.AbstractGenericAttribute;
import org.citygml4j.model.generics.AbstractGenericAttributeProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.base.ReferenceAdapter;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractCityObjectAdapter<T extends AbstractCityObject> extends AbstractFeatureWithLifespanAdapter<T> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractCityObject"),
            new QName(CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE, "_GenericApplicationPropertyOfCityObject"),
            new QName(CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE, "_GenericApplicationPropertyOfCityObject"),
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLCoreNamespace(name.getNamespaceURI())) {
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
                        object.getGeneralizesTo().add(new WeakCityObjectReference(reader.getObjectUsingBuilder(ReferenceAdapter.class)));
                    else
                        object.getGeneralizesTo().add(reader.getObjectUsingBuilder(WeakCityObjectReferenceAdapter.class));
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
                    object.getAppearances().add(reader.getObjectUsingBuilder(AppearanceMemberAdapter.class));
                    return;
                case "genericAttribute":
                    object.getGenericAttributes().add(reader.getObjectUsingBuilder(AbstractGenericAttributePropertyAdapter.class));
                    return;
                case "dynamizer":
                    object.getDynamizers().add(reader.getObjectUsingBuilder(DynamizerPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE.equals(name.getNamespaceURI())
                || CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE.equals(name.getNamespaceURI())) {
            object.getAppearances().add(reader.getObjectUsingBuilder(AppearanceMemberAdapter.class));
            return;
        } else if (CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())
                || CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE.equals(name.getNamespaceURI())) {
            object.getGenericAttributes().add(new AbstractGenericAttributeProperty(reader.getObject(AbstractGenericAttribute.class)));
            return;
        }

        ObjectBuilder<ADEPropertyOfAbstractCityObject> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractCityObject.class);
        if (builder != null)
            object.getADEPropertiesOfAbstractCityObject().add(reader.getObjectUsingBuilder(builder));
        else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
            object.getADEPropertiesOfAbstractCityObject().add(GenericADEPropertyOfAbstractCityObject.of(reader.getDOMElement()));
        else
            super.buildChildObject(object, name, attributes, reader);
    }
}
