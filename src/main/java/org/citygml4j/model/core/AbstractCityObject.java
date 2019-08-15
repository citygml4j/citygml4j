package org.citygml4j.model.core;

import org.citygml4j.model.deprecated.WeakCityObjectReference;
import org.citygml4j.model.dynamizer.DynamizerProperty;
import org.citygml4j.model.generics.AbstractGenericAttributeProperty;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractCityObject extends AbstractFeatureWithLifespan {
    private List<ExternalReferenceProperty> externalReferences;
    private List<WeakCityObjectReference> generalizesTo;
    private RelativeToTerrain relativeToTerrain;
    private RelativeToWater relativeToWater;
    private List<CityObjectRelationProperty> relatedTo;
    private List<AppearanceMember> appearances;
    private List<AbstractGenericAttributeProperty> genericAttributes;
    private List<DynamizerProperty> dynamizers;
    private List<ADEPropertyOfAbstractCityObject> adeProperties;

    public List<ExternalReferenceProperty> getExternalReferences() {
        if (externalReferences == null)
            externalReferences = new ChildList<>(this);

        return externalReferences;
    }

    public void setExternalReferences(List<ExternalReferenceProperty> externalReferences) {
        this.externalReferences = asChild(externalReferences);
    }

    public List<WeakCityObjectReference> getGeneralizesTo() {
        if (generalizesTo == null)
            generalizesTo = new ChildList<>(this);

        return generalizesTo;
    }

    public void setGeneralizesTo(List<WeakCityObjectReference> generalizesTo) {
        this.generalizesTo = asChild(generalizesTo);
    }

    public RelativeToTerrain getRelativeToTerrain() {
        return relativeToTerrain;
    }

    public void setRelativeToTerrain(RelativeToTerrain relativeToTerrain) {
        this.relativeToTerrain = relativeToTerrain;
    }

    public RelativeToWater getRelativeToWater() {
        return relativeToWater;
    }

    public void setRelativeToWater(RelativeToWater relativeToWater) {
        this.relativeToWater = relativeToWater;
    }

    public List<CityObjectRelationProperty> getRelatedTo() {
        if (relatedTo == null)
            relatedTo = new ChildList<>(this);

        return relatedTo;
    }

    public void setRelatedTo(List<CityObjectRelationProperty> relatedTo) {
        this.relatedTo = asChild(relatedTo);
    }

    public List<AppearanceMember> getAppearances() {
        if (appearances == null)
            appearances = new ChildList<>(this);

        return appearances;
    }

    public void setAppearances(List<AppearanceMember> appearances) {
        this.appearances = asChild(appearances);
    }

    public List<AbstractGenericAttributeProperty> getGenericAttributes() {
        if (genericAttributes == null)
            genericAttributes = new ChildList<>(this);

        return genericAttributes;
    }

    public void setGenericAttributes(List<AbstractGenericAttributeProperty> genericAttributes) {
        this.genericAttributes = asChild(genericAttributes);
    }

    public List<DynamizerProperty> getDynamizers() {
        if (dynamizers == null)
            dynamizers = new ChildList<>(this);

        return dynamizers;
    }

    public void setDynamizers(List<DynamizerProperty> dynamizers) {
        this.dynamizers = asChild(dynamizers);
    }

    public List<ADEPropertyOfAbstractCityObject> getADEPropertiesOfAbstractCityObject() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractCityObject(List<ADEPropertyOfAbstractCityObject> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
