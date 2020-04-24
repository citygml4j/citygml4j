package org.citygml4j.model.core;

import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractCityObject extends AbstractFeatureWithLifespan {
    private List<ExternalReferenceProperty> externalReferences;
    private List<Reference> generalizesTo;
    private RelativeToTerrain relativeToTerrain;
    private RelativeToWater relativeToWater;
    private List<CityObjectRelationProperty> relatedTo;
    private List<AbstractAppearanceProperty> appearances;
    private List<AbstractGenericAttributeProperty> genericAttributes;
    private List<AbstractDynamizerProperty> dynamizers;
    private DeprecatedPropertiesOfAbstractCityObject deprecatedProperties;
    private List<ADEPropertyOfAbstractCityObject<?>> adeProperties;

    public List<ExternalReferenceProperty> getExternalReferences() {
        if (externalReferences == null)
            externalReferences = new ChildList<>(this);

        return externalReferences;
    }

    public void setExternalReferences(List<ExternalReferenceProperty> externalReferences) {
        this.externalReferences = asChild(externalReferences);
    }

    public List<Reference> getGeneralizesTo() {
        if (generalizesTo == null)
            generalizesTo = new ChildList<>(this);

        return generalizesTo;
    }

    public void setGeneralizesTo(List<Reference> generalizesTo) {
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

    public List<AbstractAppearanceProperty> getAppearances() {
        if (appearances == null)
            appearances = new ChildList<>(this);

        return appearances;
    }

    public void setAppearances(List<AbstractAppearanceProperty> appearances) {
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

    public List<AbstractDynamizerProperty> getDynamizers() {
        if (dynamizers == null)
            dynamizers = new ChildList<>(this);

        return dynamizers;
    }

    public void setDynamizers(List<AbstractDynamizerProperty> dynamizers) {
        this.dynamizers = asChild(dynamizers);
    }

    public DeprecatedPropertiesOfAbstractCityObject getDeprecatedProperties() {
        if (deprecatedProperties == null)
            deprecatedProperties = asChild(createDeprecatedProperties());

        return deprecatedProperties;
    }

    public boolean hasDeprecatedProperties() {
        return deprecatedProperties != null;
    }

    protected DeprecatedPropertiesOfAbstractCityObject createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractCityObject();
    }

    public List<ADEPropertyOfAbstractCityObject<?>> getADEPropertiesOfAbstractCityObject() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractCityObject(List<ADEPropertyOfAbstractCityObject<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractCityObject<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractCityObject<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
